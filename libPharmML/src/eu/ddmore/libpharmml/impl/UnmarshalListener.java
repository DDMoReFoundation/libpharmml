package eu.ddmore.libpharmml.impl;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.Unmarshaller.Listener;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;
import eu.ddmore.libpharmml.exceptions.AnnotationException;
import eu.ddmore.libpharmml.util.annotations.HasElementRenamed;
import eu.ddmore.libpharmml.util.annotations.RenamedElement;
import static eu.ddmore.libpharmml.impl.Utils.*;

public class UnmarshalListener extends Listener {
	
	private PharmMLVersion docVersion;
	
	public UnmarshalListener(PharmMLVersion docVersion){
		this.docVersion = docVersion;
	}

	@Override
	public void beforeUnmarshal(Object target, Object parent) {
		if(target instanceof PharmMLElement){
			((PharmMLElement)target).setUnmarshalVersion(docVersion);
		}
	}

	@Override
	public void afterUnmarshal(Object target, Object parent) {
		Class<?> _class = target.getClass();
		
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
				}
				
				Collections.sort(versionList, Collections.reverseOrder());
				for(PharmMLVersion version : versionList){
					if(docVersion.isEqualOrLaterThan(version)){
	
							String mappedField = versionToField.get(version);
							copyField(target, mappedField, transientField, true);
							LoggerWrapper.getLogger().info("Using "+mappedField+" as "+ transientField+" in "+target);
							break;
	
					}
				}
			
			} catch (NoSuchFieldException e) {
				throw new AnnotationException(target, "1 field does not exist.");
			}
			
		}
	}

}
