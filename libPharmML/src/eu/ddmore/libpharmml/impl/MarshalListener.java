/*******************************************************************************
 * Copyright (c) 2014,2015 European Molecular Biology Laboratory,
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
import eu.ddmore.libpharmml.dom.Identifiable;
import eu.ddmore.libpharmml.exceptions.AnnotationException;
import eu.ddmore.libpharmml.util.annotations.HasElementRenamed;
import eu.ddmore.libpharmml.util.annotations.HasElementsRenamed;
import eu.ddmore.libpharmml.util.annotations.RenamedElement;
import eu.ddmore.libpharmml.validation.exceptions.DuplicateIdentifierException;

public class MarshalListener extends Listener {
	
	PharmMLVersion marshalVersion;
	private IdFactory idFactory;
	
	private boolean autoset_id = true;
	
	public MarshalListener(PharmMLVersion version,IdFactory idFactory){
		this.marshalVersion = version;
		this.idFactory = idFactory;
	}
	
	public PharmMLVersion getMarshalVersion(){
		return this.marshalVersion;
	}

	@Override
	public void beforeMarshal(Object source) {
		Class<?> _class = source.getClass();
		
		// Checking for renamed elements
		if(_class.isAnnotationPresent(HasElementRenamed.class)){
				
				Annotation annotation = _class.getAnnotation(HasElementRenamed.class);
				handleAnnotation((HasElementRenamed) annotation, source);
				
		}
		if(_class.isAnnotationPresent(HasElementsRenamed.class)){
			
			Annotation annotation = _class.getAnnotation(HasElementsRenamed.class);
			handleAnnotation((HasElementsRenamed) annotation, source);
			
	}
		
		if(source instanceof Identifiable && marshalVersion.isEqualOrLaterThan(PharmMLVersion.V0_6)){
			if(((Identifiable) source).getId() == null && autoset_id){
				String id = idFactory.generateAndStoreIdentifiable((Identifiable) source);
				LoggerWrapper.getLogger().info("Assigning id \""+id+"\" to "+source.getClass()+".");
			} else if (((Identifiable) source).getId() != null ){
				try {
					idFactory.storeIdentifiable((Identifiable) source);
				} catch (DuplicateIdentifierException e) {
					LoggerWrapper.getLogger().warning("Attempt to store a duplicate identifier ("+e.getDuplicate().getId()+").");
				}
			}
		}
		
	}
	
	private void handleAnnotation(HasElementRenamed hasElRenamedAnnot, Object source){
		
		try {
			
			String transientField = hasElRenamedAnnot.transientField();
			
			List<PharmMLVersion> versionList = new ArrayList<PharmMLVersion>();
			Map<PharmMLVersion,String> versionToField = new HashMap<PharmMLVersion,String>();
			
			for(RenamedElement renamedEl : hasElRenamedAnnot.mappedFields()){
				versionList.add(renamedEl.since());
				versionToField.put(renamedEl.since(), renamedEl.field());
				eraseField(source, renamedEl.field());
			}
			
			Collections.sort(versionList, Collections.reverseOrder());
			for(PharmMLVersion version : versionList){
				if(marshalVersion.isEqualOrLaterThan(version)){

						String mappedField = versionToField.get(version);
						copyField(source, transientField, mappedField, false);
						LoggerWrapper.getLogger().info("Using "+mappedField+" as "+ transientField+" in "+source);
						break;

				}
			}
			
		} catch (NoSuchFieldException e) {
			throw new AnnotationException(source, "1 field does not exist.");
		}
	}
	
	private void handleAnnotation(HasElementsRenamed annotation, Object source){
		for(HasElementRenamed elRenamedAnnot : annotation.value()){
			handleAnnotation(elRenamedAnnot, source);
		}
	}

	@Override
	public void afterMarshal(Object source) {
		super.afterMarshal(source);
	}
	
	public void autosetId(boolean b){
		autoset_id = b;
	}

}
