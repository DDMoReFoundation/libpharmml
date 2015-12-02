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
package eu.ddmore.libpharmml.dom.maths;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.impl.MathExpressionConverterToMathML;


/**
 * 
 *                 An operator describing a matrix and vector operation.
 *             
 * 
 * 
 *                         Extends the expression which is in effect the operand.
 *                     
 * 
 * <p>Java class for MatrixUniOpType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MatrixUniOpType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/Maths}ExprType">
 *       &lt;attribute name="op" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *             &lt;enumeration value="inverse"/>
 *             &lt;enumeration value="trace"/>
 *             &lt;enumeration value="transpose"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatrixUniOpType")
public class MatrixUniOp
    extends Expression implements ExpressionValue
{

//    @XmlAttribute(name = "op", required = true)
//    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
//    protected String op;
	
	@XmlAttribute(name = "op", required = true)
	protected MatrixUnioperator op;
    
    public MatrixUniOp(){};
    
    public MatrixUniOp(MatrixUnioperator op){
    	this.op = op;
    }

    /**
     * Gets the value of the op property.
     * 
     * @return
     *     possible object is
     *     {@link MatrixUnioperator }
     *     
     */
    public MatrixUnioperator getOp() {
        return op;
    }

    /**
     * Sets the value of the op property.
     * 
     * @param value
     *     allowed object is
     *     {@link MatrixUnioperator }
     *     
     */
    public void setOp(MatrixUnioperator value) {
        this.op = value;
    }

	@Override
	public String toMathExpression() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toMathML() {
		return new MathExpressionConverterToMathML().convert(this);
	}
    
	@Override
	public String convert(MathExpressionConverter converter) {
		return converter.convert(this);
	}
	
//    @Override
//    protected void beforeMarshal(Marshaller m) {
//    	super.beforeMarshal(m);
//    }
//    
//    @Override
//    protected void afterUnmarshal(Unmarshaller u, Object parent) {
//    	super.afterUnmarshal(u, parent);
//    }

}
