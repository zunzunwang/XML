package com.zunzunwang.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="currency")
@XmlAccessorType(XmlAccessType.FIELD)

public class Currency {
	private String name="name";
	private String country="country";
	private int yearAdopted=0;
	private int ID;
	
	public Currency(){
		
	}
	
	public Currency(String country,String name,int yearAdopted,int ID){
		this.name=name;
		this.country=country;
		this.yearAdopted=yearAdopted;
		this.ID=ID;		
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
	public int get_ID() {
		return ID;
	}
	public void set_ID(int iD) {
		ID = iD;
	}

	


}
