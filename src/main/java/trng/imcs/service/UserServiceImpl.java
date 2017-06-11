package trng.imcs.service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletConfig;

import trng.imcs.model.CredentialInfo;
import trng.imcs.model.UserInfo;

public class UserServiceImpl implements UserService {

	public boolean validateUser(UserInfo user, ServletConfig servletConfig) {		
//		Enumeration<String> initParams = servletConfig.getInitParameterNames();
//		boolean validUser = false;
//		
//		while (initParams.hasMoreElements()) {
//			String initParamName = initParams.nextElement();
//			String initParamValue = servletConfig.getInitParameter(initParamName);
//			
//				if (user != null && user.getUserId().equals(initParamName)
//						&& user.getPassword().equals(initParamValue)) {
//				validUser = true;
//			}
//		}
		boolean validUser = false;
		//String compString = new StringBuilder().append(user.getUserId()).append(user.getPassword()).toString();
		CredentialInfo cred = new CredentialInfo();
		HashMap<String,String> credMap = cred.getMap();
		  for(HashMap.Entry<String,String> map:credMap.entrySet()){  
			  if((map.getKey().equals(user.getUserId()))&&(map.getValue().equals(user.getPassword())))
			validUser = true;
		}
		
		
		return validUser;
	}
	
	

}
