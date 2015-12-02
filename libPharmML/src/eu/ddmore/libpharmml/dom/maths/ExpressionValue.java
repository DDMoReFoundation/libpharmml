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

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.commontypes.MatrixSelector;
import eu.ddmore.libpharmml.dom.commontypes.ObjectFactory;
import eu.ddmore.libpharmml.dom.commontypes.Product;
import eu.ddmore.libpharmml.dom.commontypes.Scalar;
import eu.ddmore.libpharmml.dom.commontypes.Sum;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.dom.commontypes.VectorSelector;
import eu.ddmore.libpharmml.dom.modeldefn.Probability;
import eu.ddmore.libpharmml.dom.tags.MathExpression;

/**
 * Interface implemented by any possible type of value within {@link Expression} objects, such as
 * {@link Uniop} or {@link Piece}.
 * @author F. Yvon
 *
 */
@XmlJavaTypeAdapter(ExpressionValue.ExpressionValueAdapter.class)
public interface ExpressionValue extends TreeNode,MathExpression {
	
	/**
	 * Adapter class to convert ExpressionValue object to/from mapped JAXBElement objects.
	 */
	public static class ExpressionValueAdapter extends XmlAdapter<JAXBElement<? extends ExpressionValue>, ExpressionValue>{
		
		private static ObjectFactory cof = MasterObjectFactory.COMMONTYPES_OF;
		private static eu.ddmore.libpharmml.dom.modeldefn.ObjectFactory mdof = MasterObjectFactory.MODELDEFN_OF;
		private static eu.ddmore.libpharmml.dom.maths.ObjectFactory mathof = MasterObjectFactory.MATHS_OF;

		@Override
		public ExpressionValue unmarshal(JAXBElement<? extends ExpressionValue> v) throws Exception {
			if(v != null){
				return v.getValue();
			} else {
				return null;
			}
		}
	
		@Override
		public JAXBElement<? extends ExpressionValue> marshal(ExpressionValue v) throws Exception {
			if(v == null){
				return null;
			} else {
				if(v instanceof Scalar){
					return MasterObjectFactory.createScalar((Scalar) v);
				} else if(v instanceof SymbolRef){
					return cof.createSymbRef((SymbolRef) v);
				} else if(v instanceof Sum){
					return cof.createSum((Sum) v);
				} else if(v instanceof Product){
					return cof.createProduct((Product) v);
				} else if(v instanceof VectorSelector){
					return cof.createVectorSelector((VectorSelector) v);
				} else if(v instanceof MatrixSelector){
					return cof.createMatrixSelector((MatrixSelector) v);
				} else if(v instanceof Probability){
					return mdof.createProbability((Probability) v);
				} else if(v instanceof Constant){
					return mathof.createConstant((Constant) v);
				} else if(v instanceof Binop){
					return mathof.createBinop((Binop) v);
				} else if(v instanceof Uniop){
					return mathof.createUniop((Uniop) v);
				} else if(v instanceof FunctionCallType){
					return mathof.createFunctionCall((FunctionCallType) v);
				} else if(v instanceof MatrixUniOp){
					return mathof.createMatrixUniop((MatrixUniOp) v);
				} else {
					throw new RuntimeException("ExpressionValue must be defined in ExpressionValueAdapter");
				}
			}
		}
		
	}

}
