package org.zunzunwang.webservices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class MyCurrencyConvertor2 {
	private List<Currency> set_Currency = null;
	
	public List<Currency> getCurrenciesList(){
		this.initializeList();
		return set_Currency;		
	}
	
	
	@WebMethod(exclude=true)
	public void initializeList(){
		   this.set_Currency=new ArrayList<Currency>();
		   Currency currency=new Currency();
		   int yearAdopted=1991;
		   currency.set_country("EU");
		   currency.set_name("Euro");
		   currency.set_yearAdopted(yearAdopted);		   
		   this.set_Currency.add(currency);
	}
	
	@WebMethod(exclude=true)
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
//	public boolean addCurrency(String name){
//		this.initializeList();
//		int size_ini=set_Currency.size();
//		this.set_Currency.add(name);
//		int size_apr=set_Currency.size();
//		if(size_ini==size_apr)
//			return false;
//		else
//			return true;		
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

