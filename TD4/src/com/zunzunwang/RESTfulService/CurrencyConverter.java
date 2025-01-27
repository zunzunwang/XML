package com.zunzunwang.RESTfulService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.DB.DBClass;
import com.rest.util.ToJSON;
import com.zunzunwang.model.Currency;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import java.sql.ResultSet;

@Path("currencyConverter")

public class CurrencyConverter {
	private String version = "1.0";

	private static List<Currency> currencyList = new ArrayList<Currency>();
		
	
	
	private  static void initializeCurrencies()
	{
		currencyList.add(new Currency("USA", "Dollar", 1800,1));
		currencyList.add(new Currency("Japan", "Yen",1945,3));
		currencyList.add(new Currency("EU","Euro",2000,2));

		}
	
	
	/**
	 * 
	 * @return
	 * an explanation of the annotations:
	 */	
	@GET
    @Path("version")
    public String version()
    {
            return "The current version is " +this.version;
    }
	
	@GET
	@Path("currency/{id}")
    public Response currency(@PathParam("id") int id)
    {
		initializeCurrencies();
		String name="error message";
		for(Currency i : currencyList ){
			if(i.get_ID() == id){
				name =i.get_name();
			}
				
		}
		return Response.status(200).entity("currency is called, name : " + name).build();
	}
	
	
	/**
	 * 
	 * @param source
	 * @param destination
	 * @param amount
	 * @return
	 * test lien:http://localhost:8080/TD4/v1/converterApp/currencyConverter/conversion/Dollar/Yen/1000
	 */
	@GET
	@Path("conversion/{source}/{destination}/{amount}")
	public String conversion(@PathParam("source") String source,@PathParam("destination") String destination,@PathParam("amount") int amount){
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
	
/*	
	@GET
	@Path("currencies")
	@Produces(MediaType.TEXT_XML)
	public List<Currency> getCurrenciesXML(){
		initializeCurrencies();
		return currencyList;				
	}
	*/
	
	/*
	@GET
	@Path("currencies")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Currency> getCurrenciesJSON(){
		initializeCurrencies();
		return currencyList;				
	}
	*/
	
	@GET
	@Path("currencies")
	@Produces(MediaType.TEXT_XML)
	public List<Currency> getCurrenciesXML(@QueryParam("sortedYN") String sortedYN){
		initializeCurrencies();		
		if(sortedYN.endsWith("y")){
			List<Currency> currencyList_sorted = new ArrayList<Currency>();
			String[] arraytostring =new String []{ "Dollar","Yen","Euro"};
			Arrays.sort(arraytostring);	
			for(int i=0;i<arraytostring.length;i++)
			{
				for(Currency j : currencyList ){
					if(arraytostring[i].equals(j.get_name()))
							currencyList_sorted.add(j);								
				}
			}		
			return currencyList_sorted;			
		}else{
			return currencyList;			
		}		
	}
	
	@GET
	@Path("currencies")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Currency> getCurrenciesJSON(@QueryParam("sortedYN") String sortedYN){
		initializeCurrencies();		
		if(sortedYN.endsWith("y")){
			List<Currency> currencyList_sorted = new ArrayList<Currency>();
			String[] arraytostring =new String []{ "Dollar","Yen","Euro"};
			Arrays.sort(arraytostring);	
			for(int i=0;i<arraytostring.length;i++)
			{
				for(Currency j : currencyList ){
					if(arraytostring[i].equals(j.get_name()))
							currencyList_sorted.add(j);								
				}
			}		
			return currencyList_sorted;			
		}else{
			return currencyList;			
		}		
	}
	
	/**
	 * http://localhost:8080/TD4/v1/converterApp/currencyConverter/offices/
	 * @return
	 */
	@GET
	@Path("offices")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOffices(){
		
		DBClass dbclass = new DBClass();
		Connection connection = dbclass.returnConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM `office`");
			ResultSet result= statement.executeQuery();
			return "test";

			//String ID = result.getString("ID");
//			String city=result.getString("city");
//			String manager_name=result.getString("manager_name");
//			String email=result.getString("email");
//			String year_founded=result.getString("year_foundedresult");
//			ToJSON tojson=new ToJSON();
//			try {
//				JSONArray jsonarray = tojson.toJSONArray(result);
//				return "test";
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return null;
//			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	


}
