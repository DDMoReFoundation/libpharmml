package eu.ddmore.libpharmml.impl;

import java.lang.reflect.Field;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import eu.ddmore.libpharmml.dom.Identifiable;

class Utils {
	
	/**
	 * Copy 1 field value to an other field using reflection.
	 * @param o The object to be modified
	 * @param from The name of the attribute to be copied.
	 * @param to The name of the attribute where the value of "from" will be copied to.
	 * @param move If the value of the "from" has to be set to null or not afterwards.
	 * @throws NoSuchFieldException
	 */
	static void copyField(Object o, String from, String to, boolean move) throws NoSuchFieldException{
		Class<?> _class = o.getClass();
		
		try {
		
			Field fromField = _class.getDeclaredField(from);
			fromField.setAccessible(true);
			Object fromValue = fromField.get(o);
			
			Field toField = _class.getDeclaredField(to);
			toField.setAccessible(true);
			toField.set(o, fromValue);
			
			if(move){
				fromField.set(o, null);
			}
		
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * Set the value of a property to null by using reflection.
	 * @param o 
	 * @param field
	 * @throws NoSuchFieldException
	 */
	static void eraseField(Object o, String field) throws NoSuchFieldException{
		try {
			Class<?> _class = o.getClass();
			Field fromField = _class.getDeclaredField(field);
			fromField.setAccessible(true);
			fromField.set(o, null);
		} catch (IllegalArgumentException e){
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Identifiable findById(TreeNode node, String id){
		if(node instanceof Identifiable){
			if(((Identifiable) node).getId() != null && 
					((Identifiable) node).getId().equals(id)){
				return (Identifiable) node;
			}
		}
		@SuppressWarnings("unchecked")
		Enumeration<TreeNode> children = node.children();
		while(children.hasMoreElements()){
			Identifiable foundChild = findById(children.nextElement(), id);
			if(foundChild != null){
				return foundChild;
			}
		}
		return null;
	}

}
