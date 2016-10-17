package com.cisc181.core;

import com.cisc181.core.Person;

public class PersonException extends Exception{
	
	private Person per;

	public PersonException(Person per) {
		
		super();
		this.per = per;
	}

	public Person getPer() {
		return per;
	}
	
}