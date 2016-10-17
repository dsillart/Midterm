package com.cisc181.core;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	@BeforeClass
	public static void setup() {
	}
	
	@Test
	public void testAvg() {
		
		ArrayList<Staff> staff_members = new ArrayList();
		
		Staff Staff1 = new Staff (eTitle.MR);
		Staff Staff2 = new Staff (eTitle.MS);
		Staff Staff3 = new Staff (eTitle.MRS);
		Staff Staff4 = new Staff (eTitle.MS);
		Staff Staff5 = new Staff (eTitle.MR);
		
		Staff1.setSalary(51000);
		Staff2.setSalary(62000);
		Staff3.setSalary(98000);
		Staff4.setSalary(45000);
		Staff5.setSalary(77000);
		
		staff_members.add(Staff1);
		staff_members.add(Staff2);
		staff_members.add(Staff3);
		staff_members.add(Staff4);
		staff_members.add(Staff5);
		
		double avg = 0;
		
		for (Staff staff: staff_members){
			avg += staff.getSalary() / staff_members.size();}
	
		double result = (51000 + 62000 + 98000 + 45000 + 77000)/5;
	
		assertEquals(average,result, 0);
	}
	
	@Test
	public void testDOBException() throws PersonException {
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 777);
		
		Staff staff_member = new Staff(eTitle.MR);
		staff_member.setDOB(calendar.getTime());
	}
	
	@Test
	public void testNumException() throws PersonException {
		
		Staff staff_member = new Staff(eTitle.MS);
		staff_member.setPhone("(123)4567890");
	}

}