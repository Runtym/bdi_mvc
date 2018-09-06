package com.bdi.mvc;

class Person {
	
}
public class PersonFactory {

	private PersonFactory() {
		
	}
	
	public static PersonFactory newInstacne() {
		return new PersonFactory();
	}
}
