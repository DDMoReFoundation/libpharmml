/*******************************************************************************
 * Copyright (c) 2014-2016 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 * 
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 * 
 *  		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 ******************************************************************************/
package eu.ddmore.libpharmml.impl;

import static eu.ddmore.libpharmml.impl.Utils.copyField;
import static eu.ddmore.libpharmml.impl.Utils.eraseField;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.Marshaller.Listener;

import eu.ddmore.libpharmml.IdFactory;
import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.Identifiable;
import eu.ddmore.libpharmml.dom.commontypes.Assignable;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Symbol;
import eu.ddmore.libpharmml.dom.tags.AdaptedClass;
import eu.ddmore.libpharmml.exceptions.AnnotationException;
import eu.ddmore.libpharmml.util.annotations.HasElementRenamed;
import eu.ddmore.libpharmml.util.annotations.HasElementsRenamed;
import eu.ddmore.libpharmml.util.annotations.RenamedElement;
import eu.ddmore.libpharmml.validation.exceptions.DuplicateIdentifierException;

/**
 * Listener used in marshal function performed by {@link MarshallerImpl}.
 * 
 * <p>This class performs the critical function of renaming the attributes that have a different name in XML
 * depending on the PharmML version used. It also generates and registers the "id" attribute values of any
 * identifiable element in the DOM.
 * 
 * <p>If this class is extended, it is important to call the superclass method within any overrided method,
 * especially {@link #beforeMarshal(Object)} and {@link #afterMarshal(Object)}.
 * 
 * @see UnmarshalListener
 * @author F. Yvon
 */
public class MarshalListener extends Listener {
	
	PharmMLVersion marshalVersion;
	private IdFactory idFactory;
	
	private boolean autoset_id = true;
	private boolean describe_variables = false;
	private static MathExpressionConverter descriptionConverter = new MathExpressionConverterToExpression();
	
	public MarshalListener(PharmMLVersion version,IdFactory idFactory){
		this.marshalVersion = version;
		this.idFactory = idFactory;
	}
	
	public PharmMLVersion getMarshalVersion(){
		return this.marshalVersion;
	}

	@Override
	public void beforeMarshal(Object source) {

		// Checking for renamed elements
		checkForRenamedElements(source);
		
		if(source instanceof Identifiable && marshalVersion.isEqualOrLaterThan(PharmMLVersion.V0_6)){
			if(((Identifiable) source).getId() == null && autoset_id){
				Identifiable identifiable = (Identifiable) source;
				String id = idFactory.generateAndStoreIdentifiable(identifiable);
				LoggerWrapper.getLogger().info("Assigning id \""+id+"\" to "+source.getClass()+".");
			} else if (((Identifiable) source).getId() != null ){
				try {
					Identifiable identifiable;
					if(source instanceof AdaptedClass){
						Object pojo = ((AdaptedClass<?>) source).getUnmappedObject();
						if(pojo instanceof Identifiable){
							identifiable = (Identifiable) pojo;
						} else {
							throw new RuntimeException("POJO doesn't implement Identifiable while adapted class does, or is null");
						}
					} else {
						identifiable = (Identifiable) source;
					}
					idFactory.storeIdentifiable(identifiable);
				} catch (DuplicateIdentifierException e) {
					LoggerWrapper.getLogger().warning("Attempt to store a duplicate identifier ("+e.getDuplicate().getId()+").");
				}
			}
		}
		
		if(describe_variables && source instanceof Symbol && source instanceof Assignable && source instanceof PharmMLRootType){
			StringBuilder sb = new StringBuilder();
			sb.append(((Symbol) source).getSymbId());
			sb.append(" = ");
			sb.append(descriptionConverter.convert(((Assignable)source).getAssign()));
			((PharmMLRootType) source).createDescription(sb.toString());
		}
		
	}
	
	protected final void checkForRenamedElements(Object source){
		Class<?> _class = source.getClass();
		checkForRenamedElements(_class, source);
	}
	
	private void checkForRenamedElements(Class<?> _class, Object source){
		// Checking for renamed elements
		if(_class.isAnnotationPresent(HasElementRenamed.class)){
				
				Annotation annotation = _class.getAnnotation(HasElementRenamed.class);
				handleAnnotation((HasElementRenamed) annotation, _class, source);
				
		}
		if(_class.isAnnotationPresent(HasElementsRenamed.class)){
			
			Annotation annotation = _class.getAnnotation(HasElementsRenamed.class);
			handleAnnotation((HasElementsRenamed) annotation, _class, source);
			
		}
		Class<?> superclass = _class.getSuperclass();
		if(superclass != null){
			checkForRenamedElements(superclass, source);
		}
	}
	
	private void handleAnnotation(HasElementRenamed hasElRenamedAnnot, Class<?> _class, Object source){
		
		try {
			
			String transientField = hasElRenamedAnnot.transientField();
			
			List<PharmMLVersion> versionList = new ArrayList<PharmMLVersion>();
			Map<PharmMLVersion,String> versionToField = new HashMap<PharmMLVersion,String>();
			
			for(RenamedElement renamedEl : hasElRenamedAnnot.mappedFields()){
				versionList.add(renamedEl.since());
				versionToField.put(renamedEl.since(), renamedEl.field());
				eraseField(source, _class, renamedEl.field());
			}
			
			Collections.sort(versionList, Collections.reverseOrder());
			for(PharmMLVersion version : versionList){
				if(marshalVersion.isEqualOrLaterThan(version)){

						String mappedField = versionToField.get(version);
						copyField(source, _class, transientField, mappedField, false);
						LoggerWrapper.getLogger().info("Using "+mappedField+" as "+ transientField+" in "+source);
						break;

				}
			}
			
		} catch (NoSuchFieldException e) {
			throw new AnnotationException(source, e.getLocalizedMessage()+" does not exist.");
		}
	}
	
	private void handleAnnotation(HasElementsRenamed annotation, Class<?> _class, Object source){
		for(HasElementRenamed elRenamedAnnot : annotation.value()){
			handleAnnotation(elRenamedAnnot, _class, source);
		}
	}

	@Override
	public void afterMarshal(Object source) {
		super.afterMarshal(source);
	}
	
	public void autosetId(boolean b){
		autoset_id = b;
	}
	
	public void describeVariables(boolean b){
		describe_variables = b;
	}

}
