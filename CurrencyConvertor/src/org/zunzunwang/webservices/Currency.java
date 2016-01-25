package org.zunzunwang.webservices;

public class Currency {
	private String name="name";
	private String country="country";
	private int yearAdopted=0;
	
	Currency(String name,String country,int yearAdopted){
		this.name=name;
		this.country=country;
		this.yearAdopted=yearAdopted;

		
		
		
	}
	
	public void set_name(String name){
		this.name=name;
		
	}
	public void set_country(String country){
		this.country=country;
		
	}
	public void set_yearAdopted(int yearAdopted){
		this.yearAdopted=yearAdopted;
		
	}
	public String get_name(){
		return this.name;
	}
	public String get_country(){
		return this.country;
	}
	public int get_yearAdopted(){
		return this.yearAdopted;
		
	}
	


}
