package eu.ddmore.libpharmml.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.commontypes.BooleanValue;
import eu.ddmore.libpharmml.dom.commontypes.CategoryRef;
import eu.ddmore.libpharmml.dom.commontypes.Delay;
import eu.ddmore.libpharmml.dom.commontypes.DelayVariable;
import eu.ddmore.libpharmml.dom.commontypes.IdValue;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.LowUpLimit;
import eu.ddmore.libpharmml.dom.commontypes.Matrix;
import eu.ddmore.libpharmml.dom.commontypes.MatrixRow;
import eu.ddmore.libpharmml.dom.commontypes.MatrixRowValue;
import eu.ddmore.libpharmml.dom.commontypes.MatrixSelector;
import eu.ddmore.libpharmml.dom.commontypes.MissingValue;
import eu.ddmore.libpharmml.dom.commontypes.MissingValueSymbol;
import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.Product;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.Scalar;
import eu.ddmore.libpharmml.dom.commontypes.Sequence;
import eu.ddmore.libpharmml.dom.commontypes.StringValue;
import eu.ddmore.libpharmml.dom.commontypes.Sum;
import eu.ddmore.libpharmml.dom.commontypes.SumIndexSet;
import eu.ddmore.libpharmml.dom.commontypes.SumProductIndex;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.Vector;
import eu.ddmore.libpharmml.dom.commontypes.VectorElements;
import eu.ddmore.libpharmml.dom.commontypes.VectorSelector;
import eu.ddmore.libpharmml.dom.commontypes.VectorValue;
import eu.ddmore.libpharmml.dom.dataset.ColumnReference;
import eu.ddmore.libpharmml.dom.maths.Binop;
import eu.ddmore.libpharmml.dom.maths.Binoperator;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.FunctionArgumentType;
import eu.ddmore.libpharmml.dom.maths.FunctionCallType;
import eu.ddmore.libpharmml.dom.maths.LogicBinOp;
import eu.ddmore.libpharmml.dom.maths.LogicCondition;
import eu.ddmore.libpharmml.dom.maths.LogicUniOp;
import eu.ddmore.libpharmml.dom.maths.MatrixUniOp;
import eu.ddmore.libpharmml.dom.maths.Naryop;
import eu.ddmore.libpharmml.dom.maths.Piece;
import eu.ddmore.libpharmml.dom.maths.Piecewise;
import eu.ddmore.libpharmml.dom.maths.ProbabilityFunction;
import eu.ddmore.libpharmml.dom.maths.Statsop;
import eu.ddmore.libpharmml.dom.maths.Statsoperator;
import eu.ddmore.libpharmml.dom.maths.Uniop;
import eu.ddmore.libpharmml.dom.maths.Unioperator;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.dom.modeldefn.Realisation;
import eu.ddmore.libpharmml.dom.tags.MathExpression;
import eu.ddmore.libpharmml.dom.trialdesign.Stage;
import static eu.ddmore.libpharmml.impl.LoggerWrapper.getLogger;

/**
 * Converter from math expression elements to content MathML structures.
 * 
 * <p>This converter generates MathML content markup. The output MathML is not meant for rendering but for expressing
 * the mathematical meaning of the epression (see <a href="http://www.w3.org/TR/MathML2/chapter4.html">http://www.w3.org/TR/MathML2/chapter4.html</a>).
 * 
 * <p>It is possible to extend this class and override the methods that don't have a satisfactory output.
 * 
 * <p>Some elements can not be converted byt this class at the moment. Those are:<br>
 * <ul>
 * <li>{@link Sequence}</li>
 * <li>{@link Probability}</li>
 * <li>{@link ProbabilityFunction}</li>
 * <li>{@link Realisation}</li>
 * </ul>
 * Also, only explicitly encoded {@link Vector} (using {@link VectorElements}) and {@link Matrix} (using unindexed {@link MatrixRow} items) objects can be correctly converted.
 * 
 * @since libPharmML 0.6.2
 * @author F. Yvon
 * @see MathExpressionConverter
 * @see MathExpression
 * @see MathExpressionConverterToExpression
 */
public class MathExpressionConverterToMathML implements MathExpressionConverter {
	
	public static String MATHML_NAMESPACE = "http://www.w3.org/1998/Math/MathML";
	public static String NULL_NUMBER = "<cn></cn>\n";
	public static String NULL_IDENTIFIER = "<ci></ci>\n";
	
	protected final static String mathML_apply1_pattern = "<apply>\n"
			+ "<%s/>\n"
			+ "%s"
			+ "</apply>\n";
	
	protected final static String mathML_apply2_pattern = "<apply>\n"
			+ "<%s/>\n"
			+ "%s"
			+ "%s"
			+ "</apply>\n";
	
	/**
	 * Generates a N-ary apply element
	 */
	private String apply(String op, List<?> elements){
		StringBuilder sb = new StringBuilder();
		sb.append("<apply>\n");
		sb.append("<"+ op +"/>\n");
		
		for(Object o : elements){
			if(o instanceof MathExpression){
				sb.append(((MathExpression) o).convert(this));
			} else {
				sb.append(NULL_IDENTIFIER);
			}
			
		}
		
		sb.append("</apply>\n");
		return sb.toString();
	}
	
	private static String csymbol(String symbol){
		return "<csymbol>"+symbol+"</csymbol>";
	}

	@Override
	public String convert(RealValue realValue) {
		if(realValue == null){
			return "<cn type=\"real\"></cn>\n";
		}
		return "<cn type=\"real\">"+realValue.valueToString()+"</cn>\n";
	}

	@Override
	public String convert(IdValue idValue) {
		if(idValue == null){
			return NULL_IDENTIFIER;
		}
		return "<ci>"+idValue.valueToString()+"</ci>\n";
	}

	@Override
	public String convert(Delay delay) {
		if(delay == null){
			return NULL_NUMBER;
		}
		return new Binop(Binoperator.TIMES, delay.getSymbRef(), new Binop(Binoperator.MINUS, new SymbolRef("t"), new SymbolRef(convert(delay.getDelayVariable())))).convert(this);
	}

	@Override
	public String convert(DelayVariable delayVariable) {
		if(delayVariable == null){
			return NULL_NUMBER;
		}
		if(delayVariable.getScalar() != null){
			return delayVariable.getScalar().convert(this);
		} else if(delayVariable.getSymbRef() != null){
			return delayVariable.getSymbRef().convert(this);
		} else {
			return NULL_NUMBER;
		}
	}

	@Override
	public String convert(BooleanValue booleanValue) {
		if(booleanValue == null){
			return NULL_IDENTIFIER;
		}
		return "<"+booleanValue.valueToString()+"/>\n";
	}

	@Override
	public String convert(IntValue intValue) {
		if(intValue == null){
			return NULL_NUMBER;
		}
		return "<cn type=\"integer\">"+intValue.valueToString()+"</cn>\n";
	}

	@Override
	public String convert(MatrixSelector matrixSelector) {
		if(matrixSelector == null){
			return NULL_IDENTIFIER;
		}
		if(matrixSelector.getSymbRef() != null){
			return "<ci type=\"matrix\">"+matrixSelector.getSymbRef().getSymbIdRef()+"</ci>\n";
		} else {
			return NULL_IDENTIFIER;
		}
	}

	@Override
	public String convert(MissingValue missingValue) {
		if(missingValue == null){
			return NULL_NUMBER;
		}
		switch(missingValue.getSymbol()){
		case MINUSINF:
			return new Uniop(Unioperator.MINUS, new MissingValue(MissingValueSymbol.PLUSINF)).convert(this);
		case NaN:
			return "<notanumber/>\n";
		case PLUSINF:
			return "<infinity/>\n";
		default:
			return "<ci>"+missingValue.getSymbol().value()+"</ci>\n";
		}
	}

	@Override
	public String convert(Product product) {
		if(product == null){
			return NULL_NUMBER;
		}
		String variableString;
		if(product.getVariable() != null){
			variableString = product.getVariable().convert(this);
		} else {
			variableString = NULL_NUMBER;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<apply>\n");
		sb.append("<product/>\n");
		sb.append("<bvar>\n");
		sb.append(convert(product.getProductIndex()));
		sb.append("</bvar>\n");
		sb.append("<lowlimit>\n");
		sb.append(convert(product.getLowLimit()));
		sb.append("</lowlimit>\n");
		sb.append("<uplimit>\n");
		sb.append(convert(product.getUpLimit()));
		sb.append("</uplimit>\n");
		sb.append(variableString);
		sb.append("</apply>\n");
		return sb.toString();
	}

	@Override
	public String convert(Rhs rhs) {
		if(rhs == null){
			return NULL_NUMBER;
		}
		Object content = rhs.getContent();
		if(content instanceof MathExpression){
			return ((MathExpression) content).convert(this);
		} else {
			return NULL_NUMBER;
		}
	}

	@Override
	public String convert(Sequence sequence) {
		// TODO Convertible ?
		getLogger().severe("Sequence cannot be converted to MathML");
		return NULL_NUMBER;
	}

	@Override
	public String convert(StringValue stringValue) {
		if(stringValue == null){
			return NULL_NUMBER;
		}
		return "<ci>"+stringValue.getValue()+"</ci>\n";
	}

	@Override
	public String convert(Sum sum) {
		if(sum == null){
			return NULL_NUMBER;
		}
		String variableString;
		if(sum.getVariable() != null){
			variableString = sum.getVariable().convert(this);
		} else {
			variableString = NULL_NUMBER;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<apply>\n");
		sb.append("<sum/>\n");
		sb.append("<bvar>\n");
		sb.append(convert(sum.getSumIndex()));
		sb.append("</bvar>\n");
		if(sum.getSumIndexSet() != null){
			sb.append("<condition>\n");
			sb.append("<apply>\n");
			sb.append("<in>\n");
			sb.append(convert(sum.getSumIndex()));
			sb.append(convert(sum.getSumIndexSet()));
			sb.append("<apply>\n");
			sb.append("</apply>\n");
			sb.append("</condition>\n");
		} else {
			sb.append("<lowlimit>\n");
			sb.append(convert(sum.getLowLimit()));
			sb.append("</lowlimit>\n");
			sb.append("<uplimit>\n");
			sb.append(convert(sum.getUpLimit()));
			sb.append("</uplimit>\n");
		}
		sb.append(variableString);
		sb.append("</apply>\n");
		return sb.toString();
	}

	@Override
	public String convert(SumIndexSet sumIndexSet) {
		if(sumIndexSet == null){
			return NULL_NUMBER;
		}
		if(sumIndexSet.getVector() != null){
			return convert(sumIndexSet.getVector());
		} else {
			return NULL_NUMBER;
		}
	}

	@Override
	public String convert(SumProductIndex sumProductIndex) {
		if(sumProductIndex == null){
			return NULL_NUMBER;
		}
		if(sumProductIndex != null && sumProductIndex.getSymbRef() != null){
			return convert(sumProductIndex.getSymbRef());
		} else {
			return NULL_NUMBER;
		}
	}

	@Override
	public String convert(Vector vector) {
		if(vector == null){
			return NULL_NUMBER;
		}
		if(vector.getVectorElements() != null){
			return vector.getVectorElements().convert(this);
		} else {
			getLogger().severe("Sparse vectors can't be converted to MathML");
			return NULL_NUMBER;
		}
	}

	@Override
	public String convert(VectorElements vectorElements) {
		if(vectorElements == null){
			return NULL_NUMBER;
		}
		StringBuilder sb = new StringBuilder("<vector>\n");
		for(VectorValue value : vectorElements.getListOfElements()){
			sb.append(value.convert(this));
		}
		sb.append("</vector>\n");
		return sb.toString();
	}

	@Override
	public String convert(SymbolRef symbolRef) {
		if(symbolRef == null){
			return NULL_IDENTIFIER;
		}
		return "<ci>"+symbolRef.getSymbIdRef()+"</ci>\n";
	}

	@Override
	public String convert(VectorSelector vectorSelector) {
		if(vectorSelector == null){
			return NULL_IDENTIFIER;
		}
		if(vectorSelector.getSymbRef() != null){
			return "<ci type=\"vector\">"+vectorSelector.getSymbRef().getSymbIdRef()+"</ci>\n";
		} else {
			return NULL_IDENTIFIER;
		}
	}

	@Override
	public String convert(ColumnReference columnReference) {
		if(columnReference == null){
			return NULL_IDENTIFIER;
		}
		return "<ci>"+columnReference.getColumnIdRef()+"</ci>\n";
	}

	@Override
	public String convert(Binop binop) {
		if(binop == null){
			return NULL_NUMBER;
		}
		return String.format(mathML_apply2_pattern ,
				binop.getOperator().getOperator(),
				binop.getOperand1().convert(this),
				binop.getOperand2().convert(this));
	}

	@Override
	public String convert(Constant constant) {
		if(constant == null){
			return NULL_NUMBER;
		}
		return "<"+constant.getOp()+"/>\n";
	}

	@Override
	public String convert(FunctionCallType functionCallType) {
		if(functionCallType == null){
			return NULL_NUMBER;
		}
		StringBuilder sb = new StringBuilder("<apply>\n");
		sb.append("<csymbol>\n");
		sb.append(functionCallType.getSymbRef().getSymbIdRef());
		sb.append("</csymbol>\n");
		for(FunctionArgumentType fa : functionCallType.getListOfFunctionArgument()){
			sb.append(convert(fa));
		}
		sb.append("</apply>\n");
		return sb.toString();
	}

	@Override
	public String convert(FunctionArgumentType fa) {
		if(fa == null){
			return NULL_NUMBER;
		}
		if(fa.getAssign() != null){
			return convert(fa.getAssign());
		} else if(fa.getScalar() != null){
			return ((Scalar)(fa.getScalar().getValue())).convert(this);
		} else if(fa.getSymbRef() != null){
			return convert(fa.getSymbRef());
		} else {
			return NULL_NUMBER;
		}
	}

	@Override
	public String convert(LogicBinOp logicBinOp) {
		if(logicBinOp == null){
			return NULL_NUMBER;
		}
		List<JAXBElement<?>> content = logicBinOp.getContent();
		if(content.size() >= 2 && logicBinOp.getOp() != null
				&& content.get(0).getValue() instanceof MathExpression 
				&& content.get(1).getValue() instanceof MathExpression){
			MathExpression operand1 = (MathExpression) content.get(0).getValue();
			MathExpression operand2 = (MathExpression) content.get(1).getValue();
			return String.format(mathML_apply2_pattern, logicBinOp.getOp(), operand1.convert(this), operand2.convert(this));
		} else {
			return NULL_NUMBER;
		}
	}

	@Override
	public String convert(LogicCondition logicCondition) {
		if(logicCondition == null){
			return NULL_NUMBER;
		}
		if(logicCondition.getLogicBinop() != null){
			LoggerWrapper.getLogger().warning(logicCondition.getLogicBinop().toString());
			return logicCondition.getLogicBinop().convert(this);
		} else if(logicCondition.getLogicUniop() != null){
			return logicCondition.getLogicUniop().convert(this);
		} else if(logicCondition.getBoolean() != null){
			return logicCondition.getBoolean().getValue().convert(this);
		} else {
			return NULL_NUMBER;
		}
	}

	@Override
	public String convert(LogicUniOp logicUniOp) {
		if(logicUniOp == null){
			return NULL_NUMBER;
		}
		MathExpression value;
		if(logicUniOp.getLogicBinop() != null){
			value = logicUniOp.getLogicBinop();
		} else if(logicUniOp.getLogicUniop() != null){
			value = logicUniOp.getLogicUniop();
		} else if(logicUniOp.getScalar() != null){
			value = (Scalar) logicUniOp.getScalar().getValue();
		} else if(logicUniOp.getConstant() != null){
			value = logicUniOp.getConstant();
		} else if(logicUniOp.getSymbRef() != null){
			value = logicUniOp.getSymbRef();
		} else if(logicUniOp.getBinop() != null){
			value = logicUniOp.getBinop();
		} else if(logicUniOp.getUniop() != null){
			value = logicUniOp.getUniop();
		} else if(logicUniOp.getFunctionCall() != null){
			value = logicUniOp.getFunctionCall();
		} else if(logicUniOp.getSum() != null){
			value = logicUniOp.getSum();
		} else if(logicUniOp.getProduct() != null){
			value = logicUniOp.getProduct();
		} else if(logicUniOp.getVectorSelector() != null){
			value = logicUniOp.getVectorSelector();
		} else if(logicUniOp.getMatrixSelector() != null){
			value = logicUniOp.getMatrixSelector();
		} else if(logicUniOp.getProbability() != null){
			value = logicUniOp.getProbability();
		} else {
			return NULL_NUMBER;
		}
		return String.format(mathML_apply1_pattern, logicUniOp.getOp(), value.convert(this));
	}

	@Override
	public String convert(MatrixUniOp matrixUniOp) {
		String matrixString;
		if(matrixUniOp != null && matrixUniOp.getValue() != null){
			matrixString = matrixUniOp.getValue().convert(this);
		} else {
			matrixString = NULL_NUMBER;
		}
		return String.format(mathML_apply1_pattern, matrixUniOp.getOp().value(), matrixString);
	}

	@Override
	public String convert(Piece piece) {
		if(piece != null && piece.getCondition() != null && piece.getValue() != null){
			if(piece.getCondition().getOtherwise() != null){
				StringBuilder sb = new StringBuilder("<otherwise>\n");
				sb.append(piece.getValue().convert(this));
				sb.append("</otherwise>\n");
				return sb.toString();
			} else {
				StringBuilder sb = new StringBuilder("<piece>\n");
				sb.append(piece.getValue().convert(this));
//				LoggerWrapper.getLogger().warning(piece.getCondition().getLogicBinop().getOp());
//				LoggerWrapper.getLogger().warning(piece.getCondition().convert(this));
				sb.append(piece.getCondition().convert(this));
				sb.append("</piece>\n");
				return sb.toString();
			}
		} else {
			return NULL_NUMBER;
		}
	}

	@Override
	public String convert(Uniop uniop) {
		if(uniop != null){
			return String.format(mathML_apply1_pattern, uniop.getOperator().value(), uniop.getValue().convert(this));
		} else {
			return NULL_NUMBER;
		}
	}

	@Override
	public String convert(Probability probability) {
		getLogger().severe("Probability cannot be converted to MathML");
		// TODO
		return NULL_NUMBER;
	}

	@Override
	public String convert(Piecewise piecewise) {
		StringBuilder sb = new StringBuilder("<piecewise>\n");
		if(piecewise != null){
			for(Piece piece : piecewise.getListOfPiece()){
				sb.append(piece.convert(this));
			}
		}
		sb.append("</piecewise>\n");
		return sb.toString();
	}

	@Override
	public String convert(LowUpLimit lowUpLimit) {
		if(lowUpLimit != null){
			if(lowUpLimit.getAssign() != null){
				return lowUpLimit.getAssign().convert(this);
			} else if(lowUpLimit.getInt() != null){
				return lowUpLimit.getInt().convert(this);
			} else if(lowUpLimit.getSymbRef() != null){
				return lowUpLimit.getSymbRef().convert(this);
			} else {
				return NULL_NUMBER;
			}
		} else {
			return NULL_NUMBER;
		}
	}

	@Override
	public String convert(Naryop naryop) {
		if(naryop == null || naryop.getOp() == null){
			return NULL_IDENTIFIER;
		}
		if(naryop.getContent().size() == 1 && naryop.getContent().get(0) instanceof Vector){
			Vector v = (Vector) naryop.getContent().get(0);
			if(v.getVectorElements() != null){
				return apply(naryop.getOp().value(), v.getVectorElements().getListOfElements());
			}
		}
		return apply(naryop.getOp().value(), naryop.getContent());
	}

	@Override
	public String convert(Statsop statsop) {
		if(statsop == null || statsop.getOp() == null){
			return NULL_IDENTIFIER;
		}
		Statsoperator op = statsop.getOp();
		String operator;
		switch (op) {
		
		case CENTRED_MOMENT:
			operator = csymbol(op.value()); // unknown function in MathML
			break;
		case COEFFICIENT_OF_VARIATION:
			operator = csymbol(op.value());
			break;
		case CORRELATION:
			operator = csymbol(op.value());
			break;
		case DECILE:
			operator = csymbol(op.value());
			break;
		case GEOMETRIC_MEAN:
			operator = csymbol(op.value());
			break;
		case KURTOSIS:
			operator = csymbol(op.value());
			break;
		case MOMENT:
			operator = csymbol(op.value());
			break;
		case PERCENTILE:
			operator = csymbol(op.value());
			break;
		case QUANTILE:
			operator = csymbol(op.value());
			break;
		case QUARTILE:
			operator = csymbol(op.value());
			break;
		case RANGE:
			operator = csymbol(op.value());
			break;
		case SKEWNESS:
			operator = csymbol(op.value());
			break;
		case STANDARD_DEVATION:
			operator = "sdev";
			break;
		default: // supported by MathML
			operator = op.value();
			break;
		}
		List<Object> elements = new ArrayList<Object>();
		for(JAXBElement<?> jaxbEl : statsop.getRest()){
			elements.add(jaxbEl.getValue());
		}
		
		return apply(operator, elements);
	}

	@Override
	public String convert(ProbabilityFunction pf) {
		getLogger().severe("Realisation cannot be converted to MathML");
		// TODO
		return NULL_NUMBER;
	}

	@Override
	public String convert(Matrix matrix) {
		if(matrix == null){
			return NULL_IDENTIFIER;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<matrix>\n");
		boolean fullMatrix = true;
		for(PharmMLRootType el : matrix.getListOfMatrixElements()){
			if(el instanceof MatrixRow){
				sb.append(convert((MatrixRow)el));
			} else {
				fullMatrix = false;
			}
		}
		if(!fullMatrix){
			LoggerWrapper.getLogger().severe("Only matrixes with explicit rows can be converted to MathML");
		}
		sb.append("</matrix>\n");
		return sb.toString();
	}
	
	private String convert(MatrixRow matrixRow){
		StringBuilder sb = new StringBuilder();
		sb.append("<matrixrow>\n");
		if(matrixRow != null){
			for(MatrixRowValue value : matrixRow.getListOfValues()){
				sb.append(value.convert(this));
			}
		}
		sb.append("</matrixrow>\n");
		return sb.toString();
	}

	@Override
	public String convert(Realisation realisation) {
		getLogger().severe("Realisation cannot be converted to MathML");
		// TODO
		return NULL_NUMBER;
	}
	
	public static String wrapMathML(String mathML){
		return "<math xmlns=\""+MATHML_NAMESPACE+"\">"+mathML+"</math>";
	}

	@Override
	public String convert(OidRef oidRef) {
		if(oidRef == null){
			return NULL_IDENTIFIER;
		}
		return "<ci>"+oidRef.getOidRef()+"</ci>\n";
	}

	@Override
	public String convert(CategoryRef categoryRef) {
		if(categoryRef == null){
			return NULL_IDENTIFIER;
		}
		return "<ci>"+categoryRef.getCatIdRef()+"</ci>\n";
	}

	@Override
	public String convert(Stage stage) {
		if(stage == null){
			return NULL_IDENTIFIER;
		}
		return "<ci>stage</ci>\n";
	}

}
