package com.theanilpaudel.architecturesample.entity;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Brand {

	@SerializedName("name")
	private String name;

	@SerializedName("ID")
	private int iD;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setID(int iD){
		this.iD = iD;
	}

	public int getID(){
		return iD;
	}

	@Override
 	public String toString(){
		return 
			"Brand{" +
			"name = '" + name + '\'' + 
			",iD = '" + iD + '\'' + 
			"}";
		}
}