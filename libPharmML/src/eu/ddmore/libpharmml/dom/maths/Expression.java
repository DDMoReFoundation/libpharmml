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
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Scalar"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}SymbRef" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Constant"/>
 *         &lt;element name="Realisation" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}RealisationType"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}PDF"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}CDF"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}HF"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}SF"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Statsop"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Naryop"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Binop"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}Uniop"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}FunctionCall"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Sum"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Product"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Vector"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}Matrix"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}VectorSelector"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/CommonTypes}MatrixSelector"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}Probability"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.8/Maths}MatrixUniop"/>
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
    
    @XmlElementRefs({
    	@XmlElementRef(name = "Scalar", namespace = NS_DEFAULT_CT, type = JAXBElement.class),
    	@XmlElementRef(name = "SymbRef", namespace = NS_DEFAULT_CT, type = JAXBElement.class),
    	@XmlElementRef(name = "Sum", namespace = NS_DEFAULT_CT, type = JAXBElement.class),
    	@XmlElementRef(name = "Product", namespace = NS_DEFAULT_CT, type = JAXBElement.class),
    	@XmlElementRef(name = "VectorSelector", namespace = NS_DEFAULT_CT, type = JAXBElement.class),
    	@XmlElementRef(name = "MatrixSelector", namespace = NS_DEFAULT_CT, type = JAXBElement.class),
    	@XmlElementRef(name = "Probability", namespace = NS_DEFAULT_MDEF, type = JAXBElement.class),
    	@XmlElementRef(name = "Constant", namespace = NS_DEFAULT_MATH, type = JAXBElement.class),
    	@XmlElementRef(name = "Binop", namespace = NS_DEFAULT_MATH, type = JAXBElement.class),
    	@XmlElementRef(name = "Uniop", namespace = NS_DEFAULT_MATH, type = JAXBElement.class),
    	@XmlElementRef(name = "FunctionCall", namespace = NS_DEFAULT_MATH, type = JAXBElement.class),
    	@XmlElementRef(name = "MatrixUniop", namespace = NS_DEFAULT_MATH, type = JAXBElement.class),
    	@XmlElementRef(name = "Vector", namespace = NS_DEFAULT_CT, type = JAXBElement.class), // PharmML 0.8
    	@XmlElementRef(name = "Matrix", namespace = NS_DEFAULT_CT, type = JAXBElement.class), // PharmML 0.8
    	@XmlElementRef(name = "Realisation", namespace = NS_DEFAULT_MATH, type = JAXBElement.class), // PharmML 0.8
    	@XmlElementRef(name = "Statsop", namespace = NS_DEFAULT_MATH, type = JAXBElement.class), // PharmML 0.8
    	@XmlElementRef(name = "Naryop", namespace = NS_DEFAULT_MATH, type = JAXBElement.class), // PharmML 0.8
    	@XmlElementRef(name = "PDF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class), // PharmML 0.8
    	@XmlElementRef(name = "CDF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class), // PharmML 0.8
    	@XmlElementRef(name = "HF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class), // PharmML 0.8
    	@XmlElementRef(name = "SF", namespace = NS_DEFAULT_MATH, type = JAXBElement.class) // PharmML 0.8
    })
    protected ExpressionValue value; // TODO: test 0.8
    
    public ExpressionValue getValue(){
    	return value;
    }
    
    public void setValue(ExpressionValue value){
    	this.value = value;
    }

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>(super.listChildren()).addIfNotNull(value);
	}

}
