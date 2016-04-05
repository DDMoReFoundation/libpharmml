package eu.ddmore.libpharmml.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import eu.ddmore.libpharmml.dom.commontypes.MatrixBlockSelector;
import eu.ddmore.libpharmml.dom.commontypes.MatrixCellSelector;
import eu.ddmore.libpharmml.dom.commontypes.MatrixRow;
import eu.ddmore.libpharmml.dom.commontypes.MatrixRowValue;
import eu.ddmore.libpharmml.dom.commontypes.MatrixSelector;
import eu.ddmore.libpharmml.dom.commontypes.MatrixVectorIndex;
import eu.ddmore.libpharmml.dom.commontypes.MissingValue;
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
import eu.ddmore.libpharmml.dom.commontypes.VectorSegmentSelector;
import eu.ddmore.libpharmml.dom.commontypes.VectorSelector;
import eu.ddmore.libpharmml.dom.commontypes.VectorValue;
import eu.ddmore.libpharmml.dom.dataset.ColumnReference;
import eu.ddmore.libpharmml.dom.maths.Binop;
import eu.ddmore.libpharmml.dom.maths.Condition;
import eu.ddmore.libpharmml.dom.maths.Constant;
import eu.ddmore.libpharmml.dom.maths.ExpressionValue;
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
import eu.ddmore.libpharmml.dom.maths.Uniop;
import eu.ddmore.libpharmml.dom.maths.Unioperator;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.dom.modeldefn.Realisation;
import eu.ddmore.libpharmml.dom.tags.MathExpression;
import eu.ddmore.libpharmml.dom.trialdesign.Stage;

public class MathExpressionConverterToExpression implements MathExpressionConverter {
	
	public static String NULL = "null";
	
	protected String convertChoice(MathExpression[] args){
		for(MathExpression exp : args){
			if(exp != null){
				return exp.convert(this);
			}
		}
		return NULL;
	}
	
	protected String identifier(String identifier){
		return identifier;
	}

	@Override
	public String convert(RealValue realValue) {
		if(realValue == null){
			return NULL;
		}
		return realValue.valueToString();
	}

	@Override
	public String convert(IdValue idValue) {
		if(idValue == null){
			return NULL;
		}
		return idValue.valueToString();
	}

	@Override
	public String convert(Delay delay) {
		if(delay == null){
			return NULL;
		}
		return convert(delay.getSymbRef())+"(t-"+convert(delay.getDelayVariable())+")";
	}

	@Override
	public String convert(DelayVariable delayVariable) {
		if(delayVariable == null){
			return NULL;
		}
		if(delayVariable.getScalar() != null){
			return delayVariable.getScalar().convert(this);
		} else if(delayVariable.getSymbRef() != null){
			return delayVariable.getSymbRef().convert(this);
		} else {
			return NULL;
		}
	}

	@Override
	public String convert(BooleanValue booleanValue) {
		if(booleanValue == null){
			return NULL;
		}
		return booleanValue.valueToString();
	}

	@Override
	public String convert(IntValue intValue) {
		if(intValue == null){
			return NULL;
		}
		return intValue.valueToString();
	}

	@Override
	public String convert(MatrixSelector matrixSelector) {
		if(matrixSelector == null){
			return NULL;
		}
		StringBuilder expression = new StringBuilder(convert(matrixSelector.getSymbRef()));
		expression.append("[");
		if(matrixSelector.getBlock() != null){
			expression.append(convert(matrixSelector.getBlock()));
		} else if(matrixSelector.getCell() != null){
			expression.append(convert(matrixSelector.getCell()));
		} else if(matrixSelector.getColumn() != null){
			expression.append(",").append(convert(matrixSelector.getColumn()));
		} else if(matrixSelector.getRow() != null){
			expression.append(convert(matrixSelector.getRow()));
		}
		expression.append("]");
		return expression.toString();
	}
	
	protected String convert(MatrixBlockSelector selector){
		if(selector == null){
			return NULL;
		}
		return convert(selector.getBlockStartRow())+"+"+convert(selector.getRowsNumber())+":"
		+convert(selector.getBlockStartColumn())+"+"+convert(selector.getColumnsNumber());
	}
	
	protected String convert(MatrixCellSelector selector){
		if(selector == null){
			return NULL;
		}
		return convert(selector.getRowIndex())+","+convert(selector.getColumnIndex());
	}

	protected String convert(MatrixVectorIndex index) {
		if(index == null){
			return NULL;
		}
		return convertChoice(new MathExpression[]{index.getIntValue(),index.getSymbolRef(),index.getAssign()});
	}

	@Override
	public String convert(MissingValue missingValue) {
		if(missingValue == null){
			return NULL;
		}
		return missingValue.valueToString();
	}

	@Override
	public String convert(Product product) {
		if(product == null || product.getVariable() == null){
			return NULL;
		}
		StringBuilder sb = new StringBuilder("product(");
		sb.append("index=").append(convert(product.getProductIndex()));
		sb.append(",");
		if(product.getLowLimit() != null){
			sb.append("lowLimit=").append(convert(product.getLowLimit()));
			sb.append(",");
		}
		if(product.getUpLimit() != null){
			sb.append("upLimit=").append(convert(product.getUpLimit()));
			sb.append(",");
		}
		sb.append(product.getVariable().convert(this));
		sb.append(")");
		return sb.toString();
	}

	@Override
	public String convert(Rhs rhs) {
		if(rhs == null){
			return NULL;
		}
		Object o = rhs.getContent();
		if(o instanceof MathExpression){
			return ((MathExpression) o).convert(this);
		} else {
			return NULL;
		}
	}

	@Override
	public String convert(Sequence sequence) {
		if(sequence == null){
			return NULL;
		}
		StringBuilder sb = new StringBuilder("sequence(");
		if(sequence.getBegin() != null){
			sb.append("begin=").append(sequence.getBegin().convert(this));
			sb.append(",");
		}
		if(sequence.getStepSize() != null){
			sb.append("stepSize=").append(sequence.getStepSize().convert(this));
			sb.append(",");
		}
		if(sequence.getStepNumber() != null){
			sb.append("stepNumber=").append(sequence.getStepNumber().convert(this));
			sb.append(",");
		}
		if(sequence.getEnd() != null){
			sb.append("end=").append(sequence.getEnd().convert(this));
			sb.append(",");
		}
		if(sequence.getRepetitions() != null){
			sb.append("repetitions=").append(sequence.getRepetitions().convert(this));
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(")");
		return sb.toString();
	}

	@Override
	public String convert(StringValue stringValue) {
		if(stringValue == null){
			return NULL;
		}
		return stringValue.valueToString();
	}

	@Override
	public String convert(Sum sum) {
		if(sum == null || sum.getVariable() == null){
			return NULL;
		}
		StringBuilder sb = new StringBuilder("sum(");
		sb.append("index=").append(convert(sum.getSumIndex()));
		sb.append(",");
		if(sum.getLowLimit() != null){
			sb.append("lowLimit=").append(convert(sum.getLowLimit()));
			sb.append(",");
		}
		if(sum.getUpLimit() != null){
			sb.append("upLimit=").append(convert(sum.getUpLimit()));
			sb.append(",");
		}
		if(sum.getSumIndexSet() != null){
			sb.append("indexSet=").append(convert(sum.getSumIndexSet()));
			sb.append(",");
		}
		sb.append(sum.getVariable().convert(this));
		sb.append(")");
		return sb.toString();
	}

	@Override
	public String convert(SumIndexSet sumIndexSet) {
		if(sumIndexSet == null){
			return NULL;
		}
		return convert(sumIndexSet.getVector());
	}

	@Override
	public String convert(SumProductIndex sumProductIndex) {
		if(sumProductIndex == null){
			return NULL;
		}
		return convert(sumProductIndex.getSymbRef());
	}

	@Override
	public String convert(Vector vector) {
		if(vector == null){
			return NULL;
		} else {
			if(vector.getVectorElements() != null){
				return convert(vector.getVectorElements());
			} else {
				//TODO: sparse vectors
				return String.valueOf(vector);
			}
		}
	}

	@Override
	public String convert(VectorElements vectorElements) {
		StringBuilder sb = new StringBuilder("{");
		String prefix = "";
		for(VectorValue value : vectorElements.getListOfElements()){
			sb.append(prefix);
			sb.append(value.convert(this));
			prefix = ",";
		}
		sb.append("}");
		return sb.toString();
	}

	@Override
	public String convert(SymbolRef symbolRef) {
		if(symbolRef == null){
			return NULL;
		}
		if(symbolRef.getBlkIdRef() != null){
			return "["+symbolRef.getBlkIdRef()+"]"+symbolRef.getSymbIdRef();
		} else {
			return symbolRef.getSymbIdRef();
		}
	}

	@Override
	public String convert(VectorSelector vectorSelector) {
		if(vectorSelector == null || vectorSelector.getSymbRef() == null){
			return NULL;
		}
		StringBuilder sb = new StringBuilder(convert(vectorSelector.getSymbRef()));
		sb.append("[");
		if(vectorSelector.getHead() != null){
			sb.append("[1:");
			sb.append(convert(vectorSelector.getHead()));
			sb.append("]");
		}
		for(PharmMLRootType cellOrSegment : vectorSelector.getCellOrSegment()){
			sb.append("[");
			if(cellOrSegment instanceof MatrixVectorIndex){
				sb.append(convert((MatrixVectorIndex)cellOrSegment)); 
			} else if(cellOrSegment instanceof VectorSegmentSelector){
				sb.append(convert(((VectorSegmentSelector) cellOrSegment).getStartIndex()));
				sb.append("->");
				sb.append(convert(((VectorSegmentSelector) cellOrSegment).getSegmentLength()));
			}
			sb.append("]");
		}
		if(vectorSelector.getTail() != null){
			sb.append("[-");
			sb.append(convert(vectorSelector.getTail()));
			sb.append("]");
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public String convert(ColumnReference columnReference) {
		if(columnReference == null){
			return NULL;
		}
		String exp = columnReference.getColumnIdRef();
		if(columnReference.getTransformIdRef() != null){
			return columnReference.getTransformIdRef()+"("+exp+")";
		} else {
			return exp;
		}
	}

	@Override
	public String convert(Binop binop) {
		String operand1String;
		String operand2String;
		if(binop.getOperand1() instanceof MathExpression){
			operand1String = ((MathExpression) binop.getOperand1()).convert(this);
		} else {
			operand1String = String.valueOf(binop.getOperand1());
		}
		if(binop.getOperand2() instanceof MathExpression){
			operand2String = ((MathExpression) binop.getOperand2()).convert(this);
		} else {
			operand2String = String.valueOf(binop.getOperand2());
		}
		String string;
		switch (binop.getOperator()) {
			case ATAN2:
				string = "atan2( "+operand1String+","+operand2String+" )";
				break;
			case DIVIDE:
				string = operand1String+"/"+operand2String;
				break;
			case LOGX:
				string = operand1String+"log "+operand2String;
				break;
			case MAX:
				string = "max{ "+operand1String+","+operand2String+" }";
				break;
			case MIN:
				string = "min{ "+operand1String+","+operand2String+" }";
				break;
			case MINUS:
				string = operand1String+"-"+operand2String;
				break;
			case PLUS:
				string = operand1String+"+"+operand2String;
				break;
			case POWER:
				string = operand1String+"^"+operand2String;
				break;
			case REM:
				string = operand1String+"%"+operand2String;
				break;
			case ROOT:
				string = operand2String+"root( "+operand1String+" )";
				break;
			case TIMES:
				string = operand1String+"*"+operand2String;
				break;
			default:
				string = "" + operand1String + binop.getOperator() + operand2String;
				break;
		}
		return "("+string+")";
	}

	@Override
	public String convert(Constant constant) {
		if(constant == null){
			return NULL;
		}
		return constant.getOp();
	}

	@Override
	public String convert(FunctionCallType functionCall) {
		if(functionCall == null || functionCall.getSymbRef() == null){
			return NULL;
		}
		StringBuilder sb = new StringBuilder(functionCall.getSymbRef().convert(this)).append("(");
		String prefix = "";
		for(FunctionArgumentType arg : functionCall.getListOfFunctionArgument()){
			sb.append(prefix);
			sb.append(convert(arg));
			prefix = ",";
		}
		sb.append(")");
		return sb.toString();
	}

	@Override
	public String convert(FunctionArgumentType fa) {
		if(fa == null || fa.getScalar() == null){
			return NULL;
		}
		Scalar scalar = (Scalar) fa.getScalar().getValue();
		return fa.getSymbId()+"="+convertChoice(new MathExpression[]{fa.getAssign(),fa.getSymbRef(),scalar});
	}

	@Override
	public String convert(LogicBinOp logicBinOp) {
		if(logicBinOp == null){
			return NULL;
		}
		String operand1String = NULL;
		String operand2String = NULL;
		List<JAXBElement<?>> content = logicBinOp.getContent();
		if(content.size() >= 1){
			Object el1 = content.get(0).getValue();
			if(el1 instanceof MathExpression){
				operand1String = ((MathExpression) el1).convert(this);
			} else {
				operand1String = String.valueOf(el1);
			}
		}
		if(content.size() >= 2){
			Object el2 = content.get(1).getValue();
			if(el2 instanceof MathExpression){
				operand2String = ((MathExpression) el2).convert(this);
			} else {
				operand2String = String.valueOf(el2);
			}
		}
		return operand1String+" "+logicBinOp.getOp()+" "+operand2String+" ";
	}

	@Override
	public String convert(LogicCondition logicCondition) {
		if(logicCondition == null){
			return NULL;
		}
		return convertChoice(new MathExpression[]{logicCondition.getLogicBinop(),logicCondition.getLogicUniop()});
	}

	@Override
	public String convert(LogicUniOp logicUniOp) {
		if(logicUniOp == null){
			return NULL;
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
			return NULL;
		}
		return logicUniOp.getOp()+" "+value.convert(this);
	}

	@Override
	public String convert(MatrixUniOp matrixUniOp) {
		if(matrixUniOp == null || matrixUniOp.getOp() == null || matrixUniOp.getValue() == null){
			return NULL;
		}
		return matrixUniOp.getOp().value()+"("+matrixUniOp.getValue().convert(this)+")";
	}

	@Override
	public String convert(Piece piece) {
		if(piece == null || piece.getValue() == null){
			return NULL;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(piece.getValue().convert(this));
		Condition condition = piece.getCondition();
		String conditionString = "if{"+NULL+"}";
		if(condition != null){
			if(condition.getLogicBinop() != null){
				conditionString = "if{"+convert(condition.getLogicBinop())+"}";
			} else if(condition.getLogicUniop() != null){
				conditionString = "if{"+convert(condition.getLogicUniop())+"}";
			} else if(condition.getOtherwise() != null){
				conditionString = "otherwise";
			}
		}
		sb.append(" ").append(conditionString);
		return sb.toString();
	}

	@Override
	public String convert(Uniop uniop) {
		if(uniop == null){
			return NULL;
		}
		ExpressionValue value = uniop.getValue();
		Unioperator operator = uniop.getOperator();
		String content;
		if(value instanceof MathExpression){
			content = ((MathExpression) value).toMathExpression();
		} else {
			content = String.valueOf(value);
		}
		StringBuilder sb = new StringBuilder("(");
		switch (operator){
		case MINUS:
			sb.append("-"+content);
			break;
		default:
			sb.append(operator.value()+"("+content+")");
			break;
		}
		sb.append(")");
		return sb.toString();
	}

	@Override
	public String convert(Probability probability) {
		// TODO Auto-generated method stub
		return String.valueOf(probability);
	}

	@Override
	public String convert(Piecewise piecewise) {
		if(piecewise != null){
			StringBuilder sb = new StringBuilder();
			String prefix = "";
			for(Piece piece : piecewise.getListOfPiece()){
				sb.append(prefix).append(piece.convert(this));
				prefix = ", ";
			}
			return sb.toString();
		} else {
			return NULL;
		}
	}

	@Override
	public String convert(LowUpLimit lowUpLimit) {
		if(lowUpLimit == null){
			return null;
		}
		return convertChoice(new MathExpression[]{lowUpLimit.getAssign(),lowUpLimit.getInt(),lowUpLimit.getSymbRef()});
	}

	@Override
	public String convert(Naryop naryop) {
		if(naryop == null || naryop.getOp() == null){
			return NULL;
		}
		FunctionString fct = new FunctionString(naryop.getOp().value());
		for(PharmMLRootType value : naryop.getContent()){
			String stringvalue;
			if(value instanceof MathExpression){
				stringvalue = ((MathExpression) value).convert(this);
			} else {
				stringvalue = String.valueOf(value);
			}
			fct.addValue(stringvalue);
		}
		return fct.toString();
	}

	@Override
	public String convert(Statsop statsop) {
		if(statsop == null || statsop.getOp() == null){
			return NULL;
		}
		FunctionString fct = new FunctionString(statsop.getOp().value());
		for(JAXBElement<?> jaxb_value : statsop.getRest()){
			String stringvalue;
			Object value = jaxb_value.getValue();
			if(value instanceof MathExpression){
				stringvalue = ((MathExpression) value).convert(this);
			} else {
				stringvalue = String.valueOf(value);
			}
			fct.addValue(stringvalue);
		}
		return fct.toString();
	}

	@Override
	public String convert(ProbabilityFunction pf) {
		if(pf == null){
			return NULL;
		}
		FunctionString fct = new FunctionString("probabilityFunction");
		fct.addArg("distribution", String.valueOf(pf.getDistribution())); //TODO: convert distribution
		if(pf.getAssign() != null){
			fct.addValue(pf.getAssign().convert(this));
		}
		return fct.toString();
		
	}

	@Override
	public String convert(Matrix matrix) {
		if(matrix == null){
			return NULL;
		}
		FunctionString fct = new FunctionString("matrix");
		fct.addArg("type", matrix.getMatrixType());
		//TODO: other arguments (diagDefault...)
		StringBuilder matrixSb = new StringBuilder("{");
		String matrixPrefix = "";
		for(PharmMLRootType element : matrix.getListOfMatrixElements()){
			if(element instanceof MatrixRow){
				StringBuilder sb = new StringBuilder();
				sb.append(matrixPrefix);
				sb.append("[");
				String prefix = "";
				for(MatrixRowValue value : ((MatrixRow) element).getListOfValues()){
					sb.append(prefix);
					sb.append(value.convert(this));
					prefix = ",";
				}
				sb.append("]");
			}
			matrixPrefix = ",";
		}
		matrixSb.append("}");
		fct.addValue(matrixSb.toString());
		return fct.toString();
	}

	@Override
	public String convert(Realisation realisation) {
		if(realisation == null){
			return NULL;
		}
		FunctionString fct = new FunctionString("realisation");
		if(realisation.getProbOnto() != null){
			fct.addArg("distribution", realisation.getProbOnto().toString()); //TODO: convert distribution
		} else if(realisation.getUncertML() != null){
			fct.addArg("distribution", realisation.getUncertML().toString()); //TODO: convert distribution
		} else if(realisation.getPiecewise() != null){
			fct.addArg("piecewise", realisation.getPiecewise().convert(this));
		}
		return fct.toString();
	}
	
	private class FunctionString {
		private final String fct;
		private final Map<String, String> args;
		private final List<String> values;
		FunctionString(String fct){
			this.fct = fct;
			args = new HashMap<String,String>();
			values = new ArrayList<String>();
		}
		void addValue(String value){
			values.add(value);
		}
		void addArg(String key, String value){
			args.put(key, value);
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(fct).append("(");
			String prefix = "";
			for(Map.Entry<String, String> entry : args.entrySet()){
				sb.append(prefix);
				sb.append(entry.getKey()).append("=").append(entry.getValue());
				prefix = ",";
			}
			for(String value : values){
				sb.append(prefix);
				sb.append(value);
				prefix = ",";
			}
			sb.append(")");
			return sb.toString();
		}
	}

	@Override
	public String convert(OidRef oidRef) {
		if(oidRef == null){
			return NULL;
		}
		return identifier(oidRef.getOidRef());
	}

	@Override
	public String convert(CategoryRef categoryRef) {
		if(categoryRef == null){
			return NULL;
		}
		return identifier(categoryRef.getCatIdRef());
	}

	@Override
	public String convert(Stage stage) {
		if(stage == null){
			return NULL;
		}
		return "stage";
	}

}
