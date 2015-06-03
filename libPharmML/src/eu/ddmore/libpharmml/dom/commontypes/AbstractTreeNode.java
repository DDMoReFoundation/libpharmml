package eu.ddmore.libpharmml.dom.commontypes;

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
