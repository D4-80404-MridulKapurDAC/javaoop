package com.app.fruits;

import java.util.Objects;

public class Fruit {
	String color;
	double weight;
	String name;
	boolean isFresh;
	
	
	
	public Fruit(String color, double weight, String name, boolean isFresh) {
		this.color = color;
		this.weight = weight;
		this.name = name;
		this.isFresh = isFresh;
	}

	
	public void getName() {
		System.out.println(this.name);
	}
	
	public void setFresh(boolean value) {
		this.isFresh =  value;
	}
	
	public String taste() {
		return "No specific taste.";
	}
	
	
	@Override
	public String toString() {
		return this.name+" "+weight+"gm "+color+" isFresh:"+isFresh;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,color,weight,isFresh);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)return true;
		if(!(obj instanceof Fruit)) {
			return false;
		}
		Fruit f = (Fruit) obj;
		return name==f.name && isFresh==f.isFresh && color==f.color && weight==f.weight; 
	}
}

