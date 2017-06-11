package trng.imcs.model;


import java.util.HashMap;

public class CredentialInfo {
	
	private HashMap<String,String> map=new HashMap<String,String>();
	
	public CredentialInfo(){
		map.put("dinesh","dinesh");  
		map.put("gautham","gautham");  
		map.put("dhanush","dhanush");  
		map.put("root","root");
	}
	
	public HashMap<String,String> getMap(){
		return this.map;
	}
	 
}
