/*******************************************************************************
 * Copyright (c) 2013, 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
package eu.ddmore.libpharmml.dom.examples;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBElement;

import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.PharmMlFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.modeldefn.CommonParameter;
import eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter;
import eu.ddmore.libpharmml.dom.modeldefn.IndividualParameter.GaussianModel;
import eu.ddmore.libpharmml.dom.modeldefn.ParameterModelType;

public class Example3Read {

	public static void main(String[] args) throws Exception {
		ILibPharmML libPml = PharmMlFactory.getInstance().createLibPharmML();
		InputStream eg3Str = new FileInputStream("examples/example3.xml");
			IPharmMLResource res = libPml.createDomFromResource(eg3Str);
			PharmML dom = res.getDom();
			for (ParameterModelType pmt : dom.getModelDefinition()
					.getParameterModel()) {
				System.out.println("Parameter Model: " + pmt.getBlkId());
				for (JAXBElement<? extends CommonParameter> cpt : pmt.getCommonParameterElement()) {
					if(cpt.getDeclaredType().equals(IndividualParameter.class)){
						IndividualParameter ipt = (IndividualParameter)cpt.getValue();
						System.out.println("individual Parameter SymbId="	+ ipt.getSymbId());
						GaussianModel gm = ipt.getGaussianModel();
						Rhs rhs = gm.getLinearCovariate().getPopulationParameter().getAssign();
					}
				}
			}
	}
}
