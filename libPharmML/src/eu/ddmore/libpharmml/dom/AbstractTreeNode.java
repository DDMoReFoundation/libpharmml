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
package eu.ddmore.libpharmml.dom;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public abstract class AbstractTreeNode implements TreeNode{
	
	@XmlTransient
	private TreeNode parent;

	@Override
	public TreeNode getChildAt(int childIndex) {
		return listChildren().get(childIndex);
	}

	@Override
	public int getChildCount() {
		return listChildren().size();
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}
	
	/**
	 * Method used during various libPharmML processes to register the
	 * parent object within the current one. Should never be used by the client.
	 * @param parent The parent node of this node.
	 */
	public void setParent(TreeNode parent){
		this.parent = parent;
	}

	@Override
	public int getIndex(TreeNode node) {
		int i = 0;
		Enumeration<TreeNode> nodes = children();
		while(nodes.hasMoreElements()){
			TreeNode currentNode = nodes.nextElement();
			if(currentNode == node || currentNode.equals(node)){
				return i;
			} else {
				i++;
			}
		}
		return i;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return getChildCount() == 0;
	}

	@Override
	public Enumeration<TreeNode> children() {
		return new Enumeration<TreeNode>(){
			
			private Iterator<TreeNode> it = listChildren().iterator();

			@Override
			public boolean hasMoreElements() {
				return it.hasNext();
			}

			@Override
			public TreeNode nextElement() {
				return it.next();
			}};
	}
	
	protected List<TreeNode> listChildren(){
		return Collections.emptyList();
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
