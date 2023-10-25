package com.app.fruits;

import com.app.fruits.Fruit;

public class Apple extends Fruit{

	public Apple(String color, double weight, String name, boolean isFresh) {
		super(color, weight,name, isFresh);
	}
	
	@Override
	public String taste() {
		return "Sweet n Sour";
	}
		
}
