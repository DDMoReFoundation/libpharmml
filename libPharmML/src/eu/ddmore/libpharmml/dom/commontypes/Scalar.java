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

import javax.swing.tree.TreeNode;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.maths.ExpressionValue;
import eu.ddmore.libpharmml.dom.maths.Operand;
import eu.ddmore.libpharmml.dom.tags.MathExpression;

/**
 * Interface for scalar values
 * @author florent
 *
 */
@XmlJavaTypeAdapter(ScalarAdapter.class)
public interface Scalar extends VectorCellValue, MatrixCellValue, MatrixRowValue, Operand, ExpressionValue, TreeNode, MathExpression {

	/**
	 * Gets a string representation of the value of this scalar.
	 * @return The value as a {@link String}.
	 */
	String valueToString();
	
	@Override
	public JAXBElement<? extends Scalar> toJAXBElement();
	
}
