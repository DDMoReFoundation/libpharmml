/*******************************************************************************
 * Copyright (c) 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
package eu.ddmore.libpharmml;

import java.util.ArrayList;
import java.util.Collection;

import eu.ddmore.libpharmml.impl.PharmMLVersion;

public class PharmMLVersionFactory {
	
	public static Collection<PharmMLVersion[]> getParameterizedVersions(){
		Collection<PharmMLVersion[]> param = new ArrayList<PharmMLVersion[]>();
		for(PharmMLVersion version : PharmMLVersion.values()){
			if(getExampleDir(version) != null){
				param.add(new PharmMLVersion[]{version});
			}
		}
		return param;
	}
	
	public static Collection<PharmMLVersion[]> getParameterizedVersionsFrom(PharmMLVersion from){
		Collection<PharmMLVersion[]> param = new ArrayList<PharmMLVersion[]>();
		for(PharmMLVersion version : PharmMLVersion.values()){
			if(getExampleDir(version) != null && version.isEqualOrLaterThan(from)){
				param.add(new PharmMLVersion[]{version});
			}
		}
		return param;
	}
	
	public static String getExampleDir(PharmMLVersion version){
		switch(version){
		case V0_2_1:
			return "examples/0_2_1";
		case V0_3:
			return "examples/0_3";
		case V0_6:
			return "examples/0_6";
		case V0_7:
			return "examples/0_7";
		default:
			return null;
		}
	}
	
}
