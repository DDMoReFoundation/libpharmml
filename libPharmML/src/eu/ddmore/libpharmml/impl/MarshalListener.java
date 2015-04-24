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

import eu.ddmore.libpharmml.exceptions.AnnotationException;
import eu.ddmore.libpharmml.util.annotations.HasElementRenamed;
import eu.ddmore.libpharmml.util.annotations.RenamedElement;

public class MarshalListener extends Listener {
	
	PharmMLVersion marshalVersion;
	
	public MarshalListener(PharmMLVersion version){
		this.marshalVersion = version;
	}
	
	public PharmMLVersion getMarshalVersion(){
		return this.marshalVersion;
	}

	@Override
	public void beforeMarshal(Object source) {
		Class<?> _class = source.getClass();
		
		// Checking for renamed elements
		if(_class.isAnnotationPresent(HasElementRenamed.class)){
			
			try {
				
				Annotation annotation = _class.getAnnotation(HasElementRenamed.class);
				HasElementRenamed hasElRenamedAnnot = (HasElementRenamed) annotation;
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
		
	}

	@Override
	public void afterMarshal(Object source) {
		super.afterMarshal(source);
	}
	

}
