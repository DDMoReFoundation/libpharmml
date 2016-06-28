package eu.ddmore.libpharmml.dom;

import javax.swing.tree.TreeNode;

import eu.ddmore.libpharmml.visitor.Visitor;

public interface PharmMLNode extends TreeNode {
	
	public void accept(Visitor visitor);

}
