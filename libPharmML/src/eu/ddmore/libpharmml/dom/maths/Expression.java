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

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * The schema type defining a mathematical expression.
 * 
 * <p>Java class for ExprType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExprType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Scalar"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbRef" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/Maths}Constant"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/Maths}Binop"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/Maths}Uniop"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/Maths}FunctionCall"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Sum"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Product"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}VectorSelector"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}MatrixSelector"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}Probability"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/Maths}MatrixUniop"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "ExprType", propOrder = {
//    "scalar",
//    "symbRef",
//    "constant",
//    "binop",
//    "uniop",
//    "functionCall",
//    "sum",
//    "product",
//    "vectorSelector",
//    "matrixSelector",
//    "probability"
//})
@XmlType(name = "ExprType", propOrder = {
	    "value"
	})
@XmlSeeAlso({
    Uniop.class,
    Piece.class
})
public class Expression
    extends PharmMLRootType
{
    
//    @XmlElementRefs({
//    	@XmlElementRef(name = "Scalar", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class),
//    	@XmlElementRef(name = "SymbRef", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class),
//    	@XmlElementRef(name = "Sum", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class),
//    	@XmlElementRef(name = "Product", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class),
//    	@XmlElementRef(name = "VectorSelector", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class),
//    	@XmlElementRef(name = "MatrixSelector", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class),
//    	@XmlElementRef(name = "Probability", namespace = XMLFilter.NS_DEFAULT_MDEF, type = JAXBElement.class),
//    	@XmlElementRef(name = "Constant", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class),
//    	@XmlElementRef(name = "Binop", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class),
//    	@XmlElementRef(name = "Uniop", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class),
//    	@XmlElementRef(name = "FunctionCall", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class),
//    	@XmlElementRef(name = "MatrixUniop", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class)
//    })
//    protected JAXBElement<?> jaxb_value;
    
    @XmlElementRefs({
    	@XmlElementRef(name = "Scalar", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class),
    	@XmlElementRef(name = "SymbRef", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class),
    	@XmlElementRef(name = "Sum", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class),
    	@XmlElementRef(name = "Product", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class),
    	@XmlElementRef(name = "VectorSelector", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class),
    	@XmlElementRef(name = "MatrixSelector", namespace = XMLFilter.NS_DEFAULT_CT, type = JAXBElement.class),
    	@XmlElementRef(name = "Probability", namespace = XMLFilter.NS_DEFAULT_MDEF, type = JAXBElement.class),
    	@XmlElementRef(name = "Constant", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class),
    	@XmlElementRef(name = "Binop", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class),
    	@XmlElementRef(name = "Uniop", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class),
    	@XmlElementRef(name = "FunctionCall", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class),
    	@XmlElementRef(name = "MatrixUniop", namespace = XMLFilter.NS_DEFAULT_MATH, type = JAXBElement.class)
    })
    protected ExpressionValue value;
    
    public ExpressionValue getValue(){
    	return value;
    }
    
    public void setValue(ExpressionValue value){
    	this.value = value;
    }

//	protected void beforeMarshal(Marshaller m){
//		if(value != null){
//			jaxb_value = value.toJAXBElement();
//		} else {
//			jaxb_value = null;
//		}
//	}
//	
//	protected void afterUnmarshal(Unmarshaller u, Object parent) {
//		if(jaxb_value != null && jaxb_value.getValue() instanceof ExpressionValue){
//			this.value = (ExpressionValue) jaxb_value.getValue();
//		} else {
//			this.value = null;
//		}
//	}

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>().addIfNotNull(value);
	}

}
