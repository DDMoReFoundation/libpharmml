package eu.ddmore.libpharmml;

import java.util.ArrayList;
import java.util.Collection;

import eu.ddmore.libpharmml.impl.PharmMLVersion;

public class PharmMLVersionFactory {
	
	public static Collection<PharmMLVersion[]> getParameterizedVersions(){
		Collection<PharmMLVersion[]> param = new ArrayList<PharmMLVersion[]>();
		for(PharmMLVersion version : PharmMLVersion.values()){
			param.add(new PharmMLVersion[]{version});
		}
		return param;
	}
	
	public static String getExampleDir(PharmMLVersion version){
		switch(version){
		case V0_2_1:
			return "examples/0_2_1";
		default:
			return "examples/0_3";
		}
	}
	
}
