package eu.ddmore.libpharmml;

import eu.ddmore.libpharmml.dom.commontypes.BooleanValue;
import eu.ddmore.libpharmml.dom.commontypes.CategoryRef;
import eu.ddmore.libpharmml.dom.commontypes.Delay;
import eu.ddmore.libpharmml.dom.commontypes.DelayVariable;
import eu.ddmore.libpharmml.dom.commontypes.IdValue;
import eu.ddmore.libpharmml.dom.commontypes.IntValue;
import eu.ddmore.libpharmml.dom.commontypes.LowUpLimit;
import eu.ddmore.libpharmml.dom.commontypes.Matrix;
import eu.ddmore.libpharmml.dom.commontypes.MatrixSelector;
import eu.ddmore.libpharmml.dom.commontypes.MissingValue;
import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.commontypes.Product;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.commontypes.Sequence;
import eu.ddmore.libpharmml.dom.commontypes.StringValue;
import eu.ddmore.libpharmml.dom.commontypes.Sum;
import eu.ddmore.libpharmml.dom.commontypes.SumIndexSet;
import eu.ddmore.libpharmml.dom.commontypes.SumProductIndex;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.Vector;
import eu.ddmore.libpharmml.dom.commontypes.VectorElements;
import eu.ddmore.libpharmml.dom.commontypes.VectorSelector;
import eu.ddmore.libpharmml.dom.dataset.ColumnReference;
import eu.ddmore.libpharmml.dom.maths.Binop;
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
import eu.ddmore.libpharmml.dom.maths.Uniop;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.dom.modeldefn.Realisation;
import eu.ddmore.libpharmml.dom.trialdesign.Stage;

public interface MathExpressionConverter {

	String convert(RealValue realValue);

	String convert(IdValue idValue);

	String convert(Delay delay);

	String convert(DelayVariable delayVariable);

	String convert(BooleanValue booleanValue);

	String convert(IntValue intValue);

	String convert(MatrixSelector matrixSelector);

	String convert(MissingValue missingValue);

	String convert(Product product);

	String convert(Rhs rhs);

	String convert(Sequence sequence);

	String convert(StringValue stringValue);

	String convert(Sum sum);

	String convert(SumIndexSet sumIndexSet);

	String convert(SumProductIndex sumProductIndex);

	String convert(Vector vector);

	String convert(VectorElements vectorElements);

	String convert(SymbolRef symbolRef);

	String convert(VectorSelector vectorSelector);

	String convert(ColumnReference columnReference);

	String convert(Binop binop);

	String convert(Constant constant);

	String convert(FunctionCallType functionCallType);
	
	String convert(FunctionArgumentType fa);

	String convert(LogicBinOp logicBinOp);

	String convert(LogicCondition logicCondition);

	String convert(LogicUniOp logicUniOp);

	String convert(MatrixUniOp matrixUniOp);

	String convert(Piece piece);

	String convert(Uniop uniop);

	String convert(Probability probability);

	String convert(Piecewise piecewise);

	String convert(LowUpLimit lowUpLimit);
	
	String convert(Naryop naryop);
	
	String convert(Statsop statsop);
	
	String convert(ProbabilityFunction pf);
	
	String convert(Matrix matrix);
	
	String convert(Realisation realisation);
	
	String convert(OidRef oidRef);
	
	String convert(CategoryRef categoryRef);
	
	String convert(Stage stage);

}
