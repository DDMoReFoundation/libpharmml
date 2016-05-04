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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.maths.Equation;
import eu.ddmore.libpharmml.exceptions.UndeclaredInterfaceImplementer;
import eu.ddmore.libpharmml.impl.NamespaceFilter;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

@SuppressWarnings("deprecation")
public class MatrixCellValueAdapter extends XmlAdapter<JAXBElement<? extends MatrixCellValue>, MatrixCellValue>{

	@Override
	public MatrixCellValue unmarshal(JAXBElement<? extends MatrixCellValue> v) throws Exception {
		Object el = v.getValue();
		if(el instanceof MatrixCellValue){
			return (MatrixCellValue) el;
		} else {
			return null;
		}
	}

	@Override
	public JAXBElement<? extends MatrixCellValue> marshal(MatrixCellValue v) throws Exception {
		JAXBElement<? extends MatrixCellValue> jaxbEl;
		if(v != null){
			if(v instanceof Scalar){
				jaxbEl = MasterObjectFactory.createScalar((Scalar) v);
			} else if (v instanceof SymbolRef){
				jaxbEl = MasterObjectFactory.COMMONTYPES_OF.createSymbRef((SymbolRef) v);
			} else if (v instanceof Rhs){
				PharmMLVersion version = ((PharmMLElement)v).getMarshalVersion();
				if(version.isEqualOrLaterThan(PharmMLVersion.V0_7_3)){
					jaxbEl = MasterObjectFactory.COMMONTYPES_OF.createAssign((Rhs) v);
				} else {
					jaxbEl = MasterObjectFactory.MATHS_OF.createEquation(Equation.fromRhs((Rhs) v));
				}
			} else if (v instanceof Equation){
				jaxbEl = new JAXBElement<Equation>(new QName(NamespaceFilter.NS_DEFAULT_MATH, "Equation"), Equation.class, (Equation) v);
			} else {
				throw new UndeclaredInterfaceImplementer(this, v);
			}
		} else {
			jaxbEl = null;
		}
		return jaxbEl;
	}

	
}
