package eu.ddmore.libpharmml.dom.maths;

import java.util.Collections;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Otherwise")
public class Otherwise extends PharmMLElement {

	@Override
	protected List<TreeNode> listChildren() {
		return Collections.emptyList();
	}

}
