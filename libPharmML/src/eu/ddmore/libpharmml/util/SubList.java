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
package eu.ddmore.libpharmml.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Special list for interacting with a bigger one. The sublist is a subpart of a master list.
 * Its content is filtered based on the specified class. Every interaction with this sublist is reflected
 * to the master one. Using both master and sublist in the same programm should be avoided.
 * @author Florent Yvon
 *
 * @param <E>
 */
public class SubList<E> implements List<E>{
	
	private List<? super E> masterList;
	private Class<E> filter;
	
	public SubList(List<? super E> master, Class<E> filter){
		if(master == null || filter == null){
			throw new IllegalArgumentException();
		}
		this.masterList = master;
		this.filter = filter;
	}
	
	@SuppressWarnings("unchecked")
	private List<E> subList(){
		List<E> subList = new ArrayList<E>();
		for(Object element : masterList){
			if(filter.isInstance(element)){
				subList.add((E) element);
			}
		}
		return subList;
	}

	@Override
	public int size() {
		return subList().size();
	}

	@Override
	public boolean isEmpty() {
		return subList().isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return subList().contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return subList().iterator();
	}

	@Override
	public Object[] toArray() {
		return subList().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return subList().toArray(a);
	}

	@Override
	public boolean add(E e) {
		return masterList.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return masterList.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return subList().containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return masterList.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return masterList.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return masterList.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return subList().retainAll(c);
	}

	@Override
	public void clear() {
		for(E element : subList()){
			masterList.remove(element);
		}
	}

	@Override
	public E get(int index) {
		return subList().get(index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E element) {
		int realIndex = masterList.indexOf(subList().get(index));
		return (E) masterList.set(realIndex, element);
	}

	@Override
	public void add(int index, E element) {
		if(index == 0){
			masterList.add(index, element);
		} else {
			// put the element in the master list after the previous one in the sublist
			int previousIndex = masterList.indexOf(subList().get(index-1));
			masterList.add(previousIndex+1, element);
		}
	}

	@Override
	public E remove(int index) {
		E removedEl = subList().get(index);
		masterList.remove(removedEl);
		return removedEl;
	}

	@Override
	public int indexOf(Object o) {
		return subList().indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return subList().lastIndexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {
		return subList().listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return subList().listIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return subList().subList(fromIndex, toIndex);
	}

}
