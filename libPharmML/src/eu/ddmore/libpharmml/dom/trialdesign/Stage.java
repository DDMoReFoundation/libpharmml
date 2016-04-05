package eu.ddmore.libpharmml.dom.trialdesign;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.tags.LogicBinOperand;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToExpression;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Stage")
public class Stage implements LogicBinOperand {

	@Override
	public JAXBElement<Stage> toJAXBElementOfLogicBinOp() {
		return ObjectFactory.getInstance().createStage(this);
	}
	
	@Override
	public String toMathExpression() {
		return new MathExpressionConverterToExpression().convert(this);
	}

	@Override
	public String toMathML() {
		return new MathExpressionConverterToMathML().convert(this);
	}

	@Override
	public String convert(MathExpressionConverter converter) {
		return converter.convert(this);
	}

}
