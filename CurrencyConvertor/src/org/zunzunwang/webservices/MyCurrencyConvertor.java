package org.zunzunwang.webservices;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class MyCurrencyConvertor {
	Set set = null;
	public Collection<String> getCurrenciesList(){
		this.initializeList();
		return set;		
	}
	
	public void initializeList(){
		   this.set=new HashSet();
		   set.add("Dollar");
		   set.add("Euro");
		   set.add("Yen");
	}
	
	public String convert( String source, String destination, double amount){
		double result = 0;		
		if(source.equals(destination)){
			return "you get"+amount;
		}else{
			if(source.equals("Dollar")){
				if(destination.equals("Euro")){
					result=amount*0.9221;
					return "you get "+result+"Euro";
				}else if(destination.equals("Yen")){
					result=amount*6.5732;					
					return "you get "+result+"Yen";			
				}
				else
					return "0";
			}
			else if(source.equals("Euro")){
				if(destination.equals("Dollar")){
					result=amount*1.0849;
					return "you get "+result+"Dollar";
				}else if(destination.equals("Yen")){
					result=amount*7.1278;					
					return "you get "+result+"Yen";			
				}
				else
					return "0";
			}
			else if(source.equals("Yen")){
				if(destination.equals("Euro")){
					result=amount*0.1403;
					return "you get "+result+"Euro";
				}else if(destination.equals("Dollar")){
					result=amount*0.1522;					
					return "you get "+result+"Dollar";			
				}
				else
					return "0";
			}
			else
				return "0";			
		}
		
	}
	
	@WebMethod(exclude=true)
	public boolean addCurrency(String name){
		this.initializeList();
		int size_ini=set.size();
		this.set.add(name);
		int size_apr=set.size();
		if(size_ini==size_apr)
			return false;
		else
			return true;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
