package com.app.fruits;

import com.app.fruits.Fruit;

public class Orange extends Fruit{

	public Orange(String color, double weight, String name, boolean isFresh) {
		super(color, weight, name, isFresh);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String taste() {
		return "Sour";
	}
}
