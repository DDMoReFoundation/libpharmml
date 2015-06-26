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
package eu.ddmore.libpharmml.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlTransient;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;

/**
 * Class for handling wrapped lists in the Domain Object Model. This class implements {@link List},
 * so it can be processed as a common list.
 * 
 * <p>The elements of that list are marshalled within a wrapping element. The name of the wrapping
 * element and the name of the wrapped elements are set by the parent element, i.e. the one that
 * contains this wrapped list.
 * 
 * <p>Moreover, this class extends {@link PharmMLRootType}, so it may be possible to add an id
 * to the wrapper as any other element in the DOM.
 * 
 * <p>If the given wrapper is not meant to have an id or any other {@link PharmMLRootType} 
 * attribute, it would be more clear for developers to use the {@link List} interface instead
 * of this concrete class.
 * 
 * @author F. Yvon
 * 
 * @since libPharmML 0.4
 *
 * @param <E> The class of the wrapped elements.
 */
@XmlTransient
public class WrappedList<E extends TreeNode> extends PharmMLRootType implements List<E>{
	
	/**
	 * The list that contains the wrapped elements.
	 */
	@XmlTransient
	private ArrayList<E> list = new ArrayList<E>();
    
    /**
     * Empty constructor.
     */
    public WrappedList(){
    }

    // Delagated methods from list
	public void trimToSize() {
		list.trimToSize();
	}
	public void ensureCapacity(int minCapacity) {
		list.ensureCapacity(minCapacity);
	}
	public int size() {
		return list.size();
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public boolean contains(Object o) {
		return list.contains(o);
	}
	public boolean containsAll(Collection<?> c) {
		return list.containsAll(c);
	}
	public int indexOf(Object o) {
		return list.indexOf(o);
	}
	public int lastIndexOf(Object o) {
		return list.lastIndexOf(o);
	}
	public Object clone() {
		return list.clone();
	}
	public Object[] toArray() {
		return list.toArray();
	}
	public <T> T[] toArray(T[] a) {
		return list.toArray(a);
	}
	public E get(int index) {
		return list.get(index);
	}
	public String toString() {
		return list.toString();
	}
	public E set(int index, E element) {
		return list.set(index, element);
	}
	public boolean add(E e) {
		return list.add(e);
	}
	public void add(int index, E element) {
		list.add(index, element);
	}
	public boolean equals(Object o) {
		return list.equals(o);
	}
	public E remove(int index) {
		return list.remove(index);
	}
	public boolean remove(Object o) {
		return list.remove(o);
	}
	public int hashCode() {
		return list.hashCode();
	}
	public void clear() {
		list.clear();
	}
	public boolean addAll(Collection<? extends E> c) {
		return list.addAll(c);
	}
	public boolean addAll(int index, Collection<? extends E> c) {
		return list.addAll(index, c);
	}
	public boolean removeAll(Collection<?> c) {
		return list.removeAll(c);
	}
	public boolean retainAll(Collection<?> c) {
		return list.retainAll(c);
	}
	public ListIterator<E> listIterator(int index) {
		return list.listIterator(index);
	}
	public ListIterator<E> listIterator() {
		return list.listIterator();
	}
	public Iterator<E> iterator() {
		return list.iterator();
	}
	public List<E> subList(int fromIndex, int toIndex) {
		return list.subList(fromIndex, toIndex);
	}

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(list);
	}
		
}
