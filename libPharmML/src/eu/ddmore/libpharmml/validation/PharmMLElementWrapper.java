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
package eu.ddmore.libpharmml.validation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Class for wrapping XML-mapped objects and access their mapped children and attributes with generic methods.
 * @author Florent Yvon
 * 
 */
@Deprecated
public class PharmMLElementWrapper {
	
	// TODO: ad hoc class for symbol resolution. Needs improvement.
	
	private Object element;
	private Class<?> workingClass;
	
	/**
	 * Contructs a wrapper around the provided object. If the object class is {@link JAXBElement},
	 * the wrapped element will be the value of this JAXB element and not the {@link JAXBElement} object itself.
	 * @param element Object with XML mapped attributes and elements.
	 */
	public PharmMLElementWrapper(Object element){
		this.element = filterElement(element); // get value if JAXBElement
		
		for(Class<?> seeAlso : getSeeAlso(this.element.getClass())){
			if(seeAlso.isInstance(element)){
				workingClass = seeAlso;
			}
		}
		
		if(workingClass == null){
			workingClass = this.element.getClass();
		}
	}
	
	public Object getElement(){
		return this.element;
	}
	
	public Class<?> getWorkingClass(){
		return this.workingClass;
	}
	
	public Collection<PharmMLElementWrapper> getChildren(){
		try {
			Collection<PharmMLElementWrapper> children = new ArrayList<PharmMLElementWrapper>();
			for(Field field : getAllFields()){
				Object attr = field.get(element);
				if(isMappedElement(field)){
					if(attr instanceof List){
						for(Object singleAttr : (List<?>) attr){
							children.add(new PharmMLElementWrapper(singleAttr));
						}
					} else {
						children.add(new PharmMLElementWrapper(attr));
					}
				}
			}
			return children;
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public String getSymbId(){
		for(Field field : getAllFields()){
			if(isSymbol(field)){
				return getStringFieldValue(field);
			}
		}
		return null;
	}
	
	public String getBlkId(){
		for(Field field : getAllFields()){
			if(isBlkId(field)){
				return getStringFieldValue(field);
			}
		}
		return null;
	}
	
	public String getSymbIdRef(){
		for(Field field : getAllFields()){
			if(isSymbolRef(field)){
				return getStringFieldValue(field);
			}
		}
		return null;
	}
	
	public String getBlkIdRef(){
		for(Field field : getAllFields()){
			if(isAttrName(field, "blkIdRef")){
				return getStringFieldValue(field);
			}
		}
		return null;
	}
	
	private String getStringFieldValue(Field field){
		try {
			return (String) field.get(element);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static boolean isBlkId(Field field){
		return isAttrName(field, "blkId");
	}
	
	private static boolean isSymbol(Field field){
		return isAttrName(field, "symbId");
	}
	
	private static boolean isSymbolRef(Field field){
		return isAttrName(field, "symbIdRef");
	}
	
	private static boolean isAttrName(Field field, String name){
		if(field.isAnnotationPresent(XmlAttribute.class)){
			XmlAttribute attr = field.getAnnotation(XmlAttribute.class);
			if(attr.name().equals(name)){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private boolean isMappedElement(Field field) throws IllegalArgumentException, IllegalAccessException{
		return (field.isAnnotationPresent(XmlElement.class) || field.isAnnotationPresent(XmlElementRef.class)
				|| field.isAnnotationPresent(XmlElements.class) || field.isAnnotationPresent(XmlElementRefs.class)) 
				&& (field.get(element) != null);
	}
	
	private Object filterElement(Object element){
		if(element instanceof JAXBElement<?>){
			return ((JAXBElement<?>)element).getValue();
		} else {
			return element;
		}
	}
	
	private List<Field> getAllFields(){
		List<Field> fields = getDeclaredFields(element.getClass());
		fetchParentFields(element.getClass(), fields);
		return fields;
	}
	
	private static void fetchParentFields(Class<?> clazz, List<Field> fields){
		if(clazz != null){
			Class<?> parentClass = clazz.getSuperclass();
			fields.addAll(getDeclaredFields(parentClass));
			fetchParentFields(parentClass, fields);
		}
	}
	
	private static List<Field> getDeclaredFields(Class<?> clazz){
		List<Field> fields = new ArrayList<Field>();
		if(clazz != null){
			for(Field field : clazz.getDeclaredFields()){
				field.setAccessible(true);
				fields.add(field);
			}
			
		}
		return fields;
	}
	
	private static List<Class<?>> getSeeAlso(Class<?> c){
		List<Class<?>> classList = new ArrayList<Class<?>>();
		if(c.isAnnotationPresent(XmlSeeAlso.class)){
			XmlSeeAlso a = c.getAnnotation(XmlSeeAlso.class);
			for(Class<?> seeAlso : a.value()){
				classList.add(seeAlso);
			}
		}
		return classList;
	}

	public String getId() {
		for(Field field : getAllFields()){
			if(isAttrName(field, "id")){
				return getStringFieldValue(field);
			}
		}
		return null;
	}

}
