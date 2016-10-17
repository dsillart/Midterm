package com.cisc181.core;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.cisc181.core.PersonException;

public abstract class Person implements java.io.Serializable {

	private String FirstName;
	private String MiddleName;
	private String LastName;
	private Date DOB;
	private String address;
	private String phone_number;
	private String email_address;

	public String getFirstName() {
		
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		
		this.FirstName = FirstName;
	}

	public String getMiddleName() {
		
		return MiddleName;
	}

	public void setMiddleName(String MiddleName) {
		
		this.MiddleName = MiddleName;
	}

	public String getLastName() {
		
		return LastName;
	}

	public void setLastName(String LastName) {
		
		this.LastName = LastName;
	}

	public Date getDOB() {
		
		return DOB;
	}

	public void setDOB(Date DOB) {
		
		this.DOB = DOB;
	}

	public void setAddress(String newAddress) {
		
		address = newAddress;
	}

	public String getAddress() {
		
		return address;
	}

	public void setPhone(String newPhone_number) {
		
		phone_number = newPhone_number;
	}

	public String getPhone() {
		
		return phone_number;
	}

	public void setEmail(String newEmail) {
		
		email_address = newEmail;
	}

	public String getEmail() {
		
		return email_address;
	}

	//No-Arg Constructor
	public Person() { }

	//Constructor with arguments
	public Person(String FirstName, String MiddleName, String LastName,
			Date DOB, String Address, String Phone_number, String Email) {
		
		this.FirstName = FirstName;
		this.MiddleName = MiddleName;
		this.LastName = LastName;
		this.setDOB(DOB);
		this.address = Address;
		this.setPhone(Phone_number);
		this.email_address = Email;
	}

	public void PrintName() {
		
		System.out.println(this.FirstName + ' ' + this.MiddleName + ' ' + this.LastName);
	}

	public void PrintDOB() throws PersonException {
		
		System.out.println(this.DOB);
	}

	public int PrintAge() throws PersonException {

		//future birthday exception
		int age = 0;
		birthDate.setTime(this.DOB);
		if (birthDate.after(today)) {
			throw new IllegalArgumentException("Can't be born in the future");
		}
		age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

		// most likely too old to live exception
		if (today.get(Calendar.DAY_OF_YEAR)- birthDate.get(Calendar.DAY_OF_YEAR)>= 100){
			throw new PersonException(null);
		}
		age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
		
		if ((birthDate.get(Calendar.DAY_OF_YEAR)
				- today.get(Calendar.DAY_OF_YEAR) > 3)
				|| (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
			age--;
		}
		
		else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
				&& (birthDate.get(Calendar.DAY_OF_MONTH) > today
						.get(Calendar.DAY_OF_MONTH))) {
			age--;
		}
		
		else {
			
			age = age;
		}
		
			System.out.println("age is " + age);
			
			return age;

	public void PrintPhoneNumber() {
		
		System.out.println(this.phone_number);
	}
	
	//phone number formatter
	public void PrintPhone_Number() throws PersonException {
		 
		List<String> phone_numbers = new ArrayList<String>();
		phone_numbers.add(phone_number);
		
		boolean number= false;
		 
		if (number == false) {
			 
			throw new PersonException(null);
		}
	
		String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
			 
		Pattern pattern = Pattern.compile(regex); {
			 
		for (String phone_number : phone_numbers) {
			   
				Matcher matcher = pattern.matcher(PhoneNumber);
			    
			    if (matcher.matches()) {
			  
			    	System.out.println(matcher.replaceFirst("($1)-$2-$3"));
		    	}
		    }
		}
	}
}