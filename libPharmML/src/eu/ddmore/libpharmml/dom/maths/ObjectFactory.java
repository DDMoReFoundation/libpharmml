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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.maths;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.modeldefn.Realisation;
import static eu.ddmore.libpharmml.impl.XMLFilter.NS_DEFAULT_MATH;



/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.ddmore.libpharmml.dom.maths package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FunctionCall_QNAME = new QName(NS_DEFAULT_MATH, "FunctionCall");
    private final static QName _Constant_QNAME = new QName(NS_DEFAULT_MATH, "Constant");
    private final static QName _LogicUniop_QNAME = new QName(NS_DEFAULT_MATH, "LogicUniop");
    private final static QName _LogicBinop_QNAME = new QName(NS_DEFAULT_MATH, "LogicBinop");
    private final static QName _Otherwise_QNAME = new QName(NS_DEFAULT_MATH, "Otherwise");
    private final static QName _Uniop_QNAME = new QName(NS_DEFAULT_MATH, "Uniop");
    private final static QName _Binop_QNAME = new QName(NS_DEFAULT_MATH, "Binop");
    private final static QName _EquationTypePiecewise_QNAME = new QName(NS_DEFAULT_MATH, "Piecewise");
    private final static QName _Equation_QNAME = new QName(NS_DEFAULT_MATH, "Equation");
    
    // PharmML 0.7
    private final static QName _MatrixUniop_QNAME = new QName(NS_DEFAULT_MATH, "MatrixUniop");
    
    // PharmML 0.6.2
    private final static QName _LogicBinOpTypeArmRef_QNAME = new QName(NS_DEFAULT_MATH, "ArmRef");
    
    // PharmML 0.8
    private final static QName _HF_QNAME = new QName(NS_DEFAULT_MATH, "HF");
    private final static QName _CDF_QNAME = new QName(NS_DEFAULT_MATH, "CDF");
    private final static QName _SF_QNAME = new QName(NS_DEFAULT_MATH, "SF");
    private final static QName _Naryop_QNAME = new QName(NS_DEFAULT_MATH, "Naryop");
    private final static QName _PDF_QNAME = new QName(NS_DEFAULT_MATH, "PDF");
    private final static QName _Statsop_QNAME = new QName(NS_DEFAULT_MATH, "Statsop");
    private final static QName _BinopTypeRealisation_QNAME = new QName(NS_DEFAULT_MATH, "Realisation");
    private final static QName _ElseTypeConditionalStatement_QNAME = new QName(NS_DEFAULT_MATH, "ConditionalStatement");
    
    // PharmML 0.8.1
    private final static QName _Piecewise_QNAME = new QName(NS_DEFAULT_MATH, "Piecewise");
    
    private final static ObjectFactory instance = new ObjectFactory();
    
    public static ObjectFactory getInstance(){
    	return instance;
    }
    
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.ddmore.libpharmml.dom.maths
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FunctionCallType }
     * 
     */
    public FunctionCallType createFunctionCallType() {
        return new FunctionCallType();
    }

    /**
     * Create an instance of {@link Condition }
     * 
     */
    public Condition createCondition() {
        return new Condition();
    }

    /**
     * Create an instance of {@link LogicCondition }
     * 
     */
    public LogicCondition createLogicConditionType() {
        return new LogicCondition();
    }

    /**
     * Create an instance of {@link LogicBinOp }
     * 
     */
    public LogicBinOp createLogicBinOpType() {
        return new LogicBinOp();
    }

    /**
     * Create an instance of {@link LogicUniOp }
     * 
     */
    public LogicUniOp createLogicUniOpType() {
        return new LogicUniOp();
    }

    /**
     * Create an instance of {@link Binop }
     * 
     */
    public Binop createBinopType() {
        return new Binop();
    }

    /**
     * Create an instance of {@link Equation }
     * 
     */
    @Deprecated
    public Equation createEquation() {
        return new Equation();
    }

    /**
     * Create an instance of {@link EquationType }
     * 
     */
    @Deprecated
    public EquationType createEquationType() {
        return new EquationType();
    }

    /**
     * Create an instance of {@link Uniop }
     * 
     */
    public Uniop createUniopType() {
        return new Uniop();
    }

    /**
     * Create an instance of {@link Piecewise }
     * 
     */
    public Piecewise createPiecewiseType() {
        return new Piecewise();
    }

    /**
     * Create an instance of {@link Constant }
     * 
     */
    public Constant createConstantType() {
        return new Constant();
    }

    /**
     * Create an instance of {@link Expression }
     * 
     */
    public Expression createExprType() {
        return new Expression();
    }

    /**
     * Create an instance of {@link LogicExpression }
     * 
     */
    public LogicExpression createLogicExprType() {
        return new LogicExpression();
    }

    /**
     * Create an instance of {@link Piece }
     * 
     */
    public Piece createPieceType() {
        return new Piece();
    }

    /**
     * Create an instance of {@link FunctionArgumentType }
     * 
     */
    public FunctionArgumentType createFunctionArgumentType() {
        return new FunctionArgumentType();
    }

    /**
     * Create an instance of {@link FunctionCallType.FunctionArgument }
     * 
     */
    public FunctionCallType.FunctionArgument createFunctionCallTypeFunctionArgument() {
        return new FunctionCallType.FunctionArgument();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FunctionCallType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "FunctionCall")
    public JAXBElement<FunctionCallType> createFunctionCall(FunctionCallType value) {
        return new JAXBElement<FunctionCallType>(_FunctionCall_QNAME, FunctionCallType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Constant }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "Constant")
    public JAXBElement<Constant> createConstant(Constant value) {
        return new JAXBElement<Constant>(_Constant_QNAME, Constant.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogicUniOp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "LogicUniop")
    public JAXBElement<LogicUniOp> createLogicUniop(LogicUniOp value) {
        return new JAXBElement<LogicUniOp>(_LogicUniop_QNAME, LogicUniOp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogicBinOp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "LogicBinop")
    public JAXBElement<LogicBinOp> createLogicBinop(LogicBinOp value) {
        return new JAXBElement<LogicBinOp>(_LogicBinop_QNAME, LogicBinOp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "Otherwise")
    public JAXBElement<Otherwise> createOtherwise(Otherwise value) {
        return new JAXBElement<Otherwise>(_Otherwise_QNAME, Otherwise.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Uniop }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "Uniop")
    public JAXBElement<Uniop> createUniop(Uniop value) {
        return new JAXBElement<Uniop>(_Uniop_QNAME, Uniop.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Binop }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "Binop")
    public JAXBElement<Binop> createBinop(Binop value) {
        return new JAXBElement<Binop>(_Binop_QNAME, Binop.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Equation }{@code >}}
     * 
     */
    @Deprecated
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "Equation")
    public JAXBElement<Equation> createEquation(Equation value) {
        return new JAXBElement<Equation>(_Equation_QNAME, Equation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Piecewise }{@code >}}
     * 
     */
	@SuppressWarnings("deprecation")
	@Deprecated
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "Piecewise", scope = EquationType.class)
    public JAXBElement<Piecewise> createEquationTypePiecewise(Piecewise value) {
        return new JAXBElement<Piecewise>(_EquationTypePiecewise_QNAME, Piecewise.class, EquationType.class, value);
    }
	
	// PharmML 0.7
	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link MatrixUniOp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "MatrixUniop")
    public JAXBElement<MatrixUniOp> createMatrixUniop(MatrixUniOp value) {
        return new JAXBElement<MatrixUniOp>(_MatrixUniop_QNAME, MatrixUniOp.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link OidRef }{@code >}}
     * @since PharmML 0.6.2
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "ArmRef", scope = LogicBinOp.class)
    public JAXBElement<OidRef> createLogicBinOpArmRef(OidRef value) {
        return new JAXBElement<OidRef>(_LogicBinOpTypeArmRef_QNAME, OidRef.class, LogicBinOp.class, value);
    }
    
    // PharmML 0.8
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProbabilityFunction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "HF")
    public JAXBElement<ProbabilityFunction> createHF(ProbabilityFunction value) {
        return new JAXBElement<ProbabilityFunction>(_HF_QNAME, ProbabilityFunction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProbabilityFunction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "CDF")
    public JAXBElement<ProbabilityFunction> createCDF(ProbabilityFunction value) {
        return new JAXBElement<ProbabilityFunction>(_CDF_QNAME, ProbabilityFunction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProbabilityFunction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "SF")
    public JAXBElement<ProbabilityFunction> createSF(ProbabilityFunction value) {
        return new JAXBElement<ProbabilityFunction>(_SF_QNAME, ProbabilityFunction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Naryop }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "Naryop")
    public JAXBElement<Naryop> createNaryop(Naryop value) {
        return new JAXBElement<Naryop>(_Naryop_QNAME, Naryop.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProbabilityFunction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "PDF")
    public JAXBElement<ProbabilityFunction> createPDF(ProbabilityFunction value) {
        return new JAXBElement<ProbabilityFunction>(_PDF_QNAME, ProbabilityFunction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Statsop }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "Statsop")
    public JAXBElement<Statsop> createStatsop(Statsop value) {
        return new JAXBElement<Statsop>(_Statsop_QNAME, Statsop.class, null, value);
    }

//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
//     * 
//     */
//    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "Otherwise")
//    public JAXBElement<Object> createOtherwise(Object value) {
//        return new JAXBElement<Object>(_Otherwise_QNAME, Object.class, null, value);
//    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Realisation }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "Realisation", scope = Binop.class)
    public JAXBElement<Realisation> createBinopTypeRealisation(Realisation value) {
        return new JAXBElement<Realisation>(_BinopTypeRealisation_QNAME, Realisation.class, Binop.class, value);
    }

    /**
     * @deprecated Use {@link #createLogicBinOpArmRef(OidRef)}
     */
    @Deprecated
    public JAXBElement<OidRef> createLogicBinOpTypeArmRef(OidRef value) {
        return createLogicBinOpArmRef(value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Realisation }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "Realisation", scope = LogicBinOp.class)
    public JAXBElement<Realisation> createLogicBinOpTypeRealisation(Realisation value) {
        return new JAXBElement<Realisation>(_BinopTypeRealisation_QNAME, Realisation.class, LogicBinOp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConditionalStatement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "ConditionalStatement", scope = ElseCondition.class)
    public JAXBElement<ConditionalStatement> createElseTypeConditionalStatement(ConditionalStatement value) {
        return new JAXBElement<ConditionalStatement>(_ElseTypeConditionalStatement_QNAME, ConditionalStatement.class, ElseCondition.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConditionalStatement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "ConditionalStatement", scope = IfElseIfCondition.class)
    public JAXBElement<ConditionalStatement> createIfElseIfTypeConditionalStatement(ConditionalStatement value) {
        return new JAXBElement<ConditionalStatement>(_ElseTypeConditionalStatement_QNAME, ConditionalStatement.class, IfElseIfCondition.class, value);
    }

    // TODO: check
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "Realisation")
	public JAXBElement<Realisation> createRealisation(Realisation value) {
		return new JAXBElement<Realisation>(_BinopTypeRealisation_QNAME, Realisation.class, null, value);
	}
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Piecewise }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_MATH, name = "Piecewise")
    public JAXBElement<Piecewise> createPiecewise(Piecewise value) {
        return new JAXBElement<Piecewise>(_Piecewise_QNAME, Piecewise.class, null, value);
    }

}
