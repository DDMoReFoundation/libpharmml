package eu.ddmore.libpharmml.dom.trialdesign;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.tags.LogicBinOperand;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Stage")
public class Stage implements LogicBinOperand {

	@Override
	public JAXBElement<Stage> toJAXBElementOfLogicBinOp() {
		return ObjectFactory.getInstance().createStage(this);
	}

}
