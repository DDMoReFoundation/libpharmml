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
package eu.ddmore.libpharmml.dom.commontypes;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.maths.Binop;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.FunctionCallType;
import eu.ddmore.libpharmml.dom.maths.MatrixUniOp;
import eu.ddmore.libpharmml.dom.maths.Piecewise;
import eu.ddmore.libpharmml.dom.maths.Uniop;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * The type specifying a derivative variable.
 * 
 * <p>Java class for DerivativeVariableType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DerivativeVariableType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}CommonVariableDefinitionType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Assign" minOccurs="0"/>
 *         &lt;element name="IndependentVariable" type="{http://www.pharmml.org/2013/03/CommonTypes}IndependentVariableReferenceType" minOccurs="0"/>
 *         &lt;element name="InitialCondition" type="{http://www.pharmml.org/2013/03/CommonTypes}InitialConditionType" minOccurs="0"/>
 *         &lt;element name="History" type="{http://www.pharmml.org/2013/03/CommonTypes}HistoryType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="compartmentNo" type="{http://www.pharmml.org/2013/03/CommonTypes}CompartmentNoType" />
 *       &lt;attribute name="symbolType" use="required" type="{http://www.pharmml.org/2013/03/CommonTypes}SymbolTypeType" fixed="real" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DerivativeVariableType", propOrder = {
    "assign",
    "independentVariable",
    "initialCondition",
    "history"
})
public class DerivativeVariable
    extends CommonVariableDefinition implements Assignable
{

    @XmlElement(name = "Assign")
    protected Rhs assign;
    @XmlElement(name = "IndependentVariable")
    protected IndependentVariableReference independentVariable;
    @XmlElement(name = "InitialCondition")
    protected InitialCondition initialCondition;
    @XmlElement(name = "History")
    protected History history;
    @XmlAttribute(name = "compartmentNo")
    @Deprecated
    protected Integer compartmentNo;
    @XmlAttribute(name = "symbolType", required = true)
    protected SymbolType symbolType;
    
    /**
     * Empty constructor.
     */
    public DerivativeVariable(){}

    /**
     * Creates a new derivative variable, with the given symbol id and symbol type.
     * @param symbId
     * @param symbolType
     */
    public DerivativeVariable(String symbId, SymbolType symbolType){
    	this.symbId = symbId;
    	this.symbolType = symbolType;
    }
    
    /**
     * The symbol id used to define the variable.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     */
    public Rhs getAssign() {
        return assign;
    }

    /**
     * Sets the value of the assign property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rhs }
     *     
     */
    public void setAssign(Rhs value) {
        this.assign = value;
    }

    /**
     * Gets the value of the independentVariable property.
     * 
     * @return
     *     possible object is
     *     {@link IndependentVariableReference }
     *     
     */
    public IndependentVariableReference getIndependentVariable() {
        return independentVariable;
    }

    /**
     * Sets the value of the independentVariable property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndependentVariableReference }
     *     
     */
    public void setIndependentVariable(IndependentVariableReference value) {
        this.independentVariable = value;
    }

    /**
     * Gets the value of the initialCondition property.
     * 
     * @return
     *     possible object is
     *     {@link InitialCondition }
     *     
     */
    public InitialCondition getInitialCondition() {
        return initialCondition;
    }

    /**
     * Sets the value of the initialCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitialCondition }
     *     
     */
    public void setInitialCondition(InitialCondition value) {
        this.initialCondition = value;
    }

    /**
     * Gets the value of the history property.
     * 
     * @return
     *     possible object is
     *     {@link History }
     *     
     */
    public History getHistory() {
        return history;
    }

    /**
     * Sets the value of the history property.
     * 
     * @param value
     *     allowed object is
     *     {@link History }
     *     
     */
    public void setHistory(History value) {
        this.history = value;
    }

    /**
     * Gets the value of the compartmentNo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     * @deprecated Since PharmML 0.4.1
     *     
     */
    @Deprecated
    public Integer getCompartmentNo() {
        return compartmentNo;
    }
    
    /**
     * Sets the value of the compartmentNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     *     
     * @deprecated Since PharmML 0.4.1
     */
    @Deprecated
    public void setCompartmentNo(Integer value) {
        this.compartmentNo = value;
    }

    /**
     * Gets the value of the symbolType property.
     * 
     * @return
     *     possible object is
     *     {@link SymbolType }
     *     
     */
    public SymbolType getSymbolType() {
        if (symbolType == null) {
            return SymbolType.REAL;
        } else {
            return symbolType;
        }
    }

    /**
     * Sets the value of the symbolType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolType }
     *     
     */
    public void setSymbolType(SymbolType value) {
        this.symbolType = value;
    }

    @Override
	public Rhs assign(Scalar scalar) {
		Rhs rhs = new Rhs(scalar);
		setAssign(rhs);
		return rhs;
	}

	@Deprecated
	public Rhs assign(eu.ddmore.libpharmml.dom.maths.Equation equation) {
		Rhs rhs = new Rhs(equation);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(SymbolRef symbolRef) {
		Rhs rhs = new Rhs(symbolRef);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Sequence sequence) {
		Rhs rhs = new Rhs(sequence);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Vector vector) {
		Rhs rhs = new Rhs(vector);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Interpolation interpolation) {
		Rhs rhs = new Rhs(interpolation);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Matrix matrix) {
		Rhs rhs = new Rhs(matrix);
		setAssign(rhs);
		return rhs;
	}
	
	@Override
	public Rhs assign(Constant constant) {
		Rhs rhs = new Rhs(constant);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Interval interval) {
		Rhs rhs = new Rhs(interval);
		setAssign(rhs);
		return rhs;
	}
	
	@Override
	public Rhs assign(Binop binop) {
		Rhs rhs = new Rhs(binop);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Uniop uniop) {
		Rhs rhs = new Rhs(uniop);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Piecewise piecewise) {
		Rhs rhs = new Rhs(piecewise);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(FunctionCallType functionCall) {
		Rhs rhs = new Rhs(functionCall);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Sum sum) {
		Rhs rhs = new Rhs(sum);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Product product) {
		Rhs rhs = new Rhs(product);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Delay delay) {
		Rhs rhs = new Rhs(delay);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(VectorSelector vectorSelector) {
		Rhs rhs = new Rhs(vectorSelector);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(MatrixSelector matrixSelector) {
		Rhs rhs = new Rhs(matrixSelector);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(MatrixUniOp matrixUniop) {
		Rhs rhs = new Rhs(matrixUniop);
		setAssign(rhs);
		return rhs;
	}

	@Override
	public Rhs assign(Probability probability) {
		Rhs rhs = new Rhs(probability);
		setAssign(rhs);
		return rhs;
	}

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(symbol)
				.addIfNotNull(assign)
				.addIfNotNull(history)
				.addIfNotNull(independentVariable)
				.addIfNotNull(initialCondition);
	}
}
