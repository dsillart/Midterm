package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import com.cisc181.eNums.*;
import com.cisc181.eNums.eMajor;
import org.junit.BeforeClass;
import org.junit.Test;

public class studentTest {
	
	private static ArrayList<Course> courses = new ArrayList();
	private static ArrayList<Semester> semesters = new ArrayList();
	private static ArrayList<Section> sections = new ArrayList();
	private static ArrayList<Student> students = new ArrayList();
	
	@BeforeClass
	public static void addData() throws PersonException {
		
		Course course = new Course();
		
		course.setCourseID(UUID.randomUUID());
		course.setCourseName("Physics");
		course.setGradePoints(4);
		course.seteMajor(eMajor.PHYSICS);
		
		courses.add(course);
		
		course = new Course();
		
		course.setCourseID(UUID.randomUUID());
		course.setCourseName("Computer Science");
		course.setGradePoints(3);
		course.seteMajor(eMajor.COMPSCI);
		
		courses.add(course);
		
		course = new Course();
		
		course.setCourseID(UUID.randomUUID());
		course.setCourseName("Chemistry");
		course.setGradePoints(3);
		course.seteMajor(eMajor.CHEM);
		
		courses.add(course);
		
		Semester semester = new Semester();
		
		semester.setSemesterID(UUID.randomUUID());
		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, Calendar.July,7);
		semester.setStartDate(calendar.getTime());
		calendar.set(2015, Calendar.October,22);
		semester.setEndDate(calendar.getTime());
		
		semesters.add(semester);
		
		semester = new Semester();
		
		semester.setSemesterID(UUID.randomUUID());
		calendar.set(2014, Calendar.February,3);
		semester.setStartDate(calendar.getTime());
		calendar.set(2015, Calendar.August,26);
		semester.setEndDate(calendar.getTime());
		
		semesters.add(semester);
		
		
		for (Semester s:semesters) {
			
			for (Course c:courses) {
				
				Section section = new Section();
				
				section.setCourseID(c.getCourseID());
				section.setSemesterID(s.getSemesterID());
				section.setRoomID(111);
				
				sections.add(section);
				
				section = new Section();
				
				section.setCourseID(c.getCourseID());
				section.setSemesterID(s.getSemesterID());
				section.setRoomID(100);
				
				sections.add(section);
			}
		}
		
		calendar.set(1990, Calendar.JANUARY,1);
		Student student = new Student("Ajay", "Ray", "Brown", calendar.getTime(), eMajor.BUSINESS, "1 Main Lane", "(123)-456-7890", "ajayray@udel.edu");
		
		students.add(student);
		
		calendar.set(1991, Calendar.FEBRUARY,2);
		Student student = new Student("Brandon", "Jay", "White", calendar.getTime(), eMajor.COMPSI, "2 Main Lane", "(234)-567-8901", "white@udel.edu");
		
		students.add(student);
		
		calendar.set(1992, Calendar.MARCH,3);
		Student student = new Student("Christina", "Mitchell", "Connors", calendar.getTime(), eMajor.CHEM, "3 Main Lane", "(345)-678-9012", "cconnors@udel.edu");
		
		students.add(student);
		
		calendar.set(1993, Calendar.APRIL,4);
		Student student = new Student("Dylan", "Dunkin", "Doobee", calendar.getTime(), eMajor.NURSING, "4 Main Lane", "(456)-789-0123", "doob@udel.edu");
		
		students.add(student);
		
		calendar.set(1994, Calendar.MAY,5);
		Student student = new Student("Egg", "Mick", "Cheedar", calendar.getTime(), eMajor.CHEM, "5 Main Lane", "(789)-012-3456", "egg@udel.edu");
		
		students.add(student);
		
		calendar.set(1995, Calendar.JUNE,6);
		student = new Student("Foxy", "Gordon", "Grey", calendar.getTime(), eMajor.BUSINESS, "6 Foxy Street", "(890)-123-4567", "thefoxyG@udel.edu");
		
		students.add(student);
		
		calendar.set(1996, Calendar.JULY,7);
		student = new Student("Mister", "Halo", "Chief", calendar.getTime(), eMajor.COMPSI, "7 Mombasa Avenue", "(777)-777-7777", "mc@udel.edu");
		
		students.add(student);
		
		calendar.set(1997, Calendar.AUGUST,8);
		student = new Student("Greasy", "Deaf", "Guy", calendar.getTime(), eMajor.NURSING, "8 Main Lane", "(901)-234-5678", "ooooogreasy@udel.edu");
		
		students.add(student);
		
		calendar.set(1998, Calendar.SEPTEMBER,9);
		student = new Student("Kevin", "Clef", "Stephen", calendar.getTime(), eMajor.CHEM, "9 Chins", "(012)-345-6789", "cleftheboychinwonder@udel.edu");
		
		students.add(student);
		
		calendar.set(1999, Calendar.OCTOBER,10);
		student = new Student("The", "Big", "Meech", calendar.getTime(), eMajor.BUSINESS, "Meeeeeeech", "(000)-000-0000", "Meechyodaddy@udel.edu");
		
		students.add(student);
		
		}
	
	private int getHours(UUID sectionID) {
		
		for (Section section: sections) {
			
			if (section.getSectionID()==(sectionID)) {
				
				for (Course course: courses) {
					
					if (course.getCourseID()== (section.getCourseID())){
						
						return course.getGradePoints();
						}
					}
				}
		
			throw new RuntimeException("Error: This course does not exist.");
		}
	
	throw new RuntimeException ("Error: section does not exist.");
}

	private double calculateGPA(ArrayList<Enrollment> enrollments, Student student){
		
		ArrayList<Enrollment> e = new ArrayList();
		
		for (Enrollment enrollment: enrollments){
			
			if (enrollment.getStudentsID() == (student.getStudentID())) {
				
				e.add(enrollment);
			}
		}
		
		double totalGrade = 0;
		int totalHours = 0;
		
		for (Enrollment enrollment:e) {
			
			UUID id = enrollment.getSectionID();
			double gradepoints = enrollment.getGrade();
			double hours = getCourseHours(id);
			totalGrade += gradepoints;
			TotalHours += hours;
		}
		
		double GPA = totalGrade / toalHours;
		return GPA;
	}
	
	private double getGPA(double grade) {
		
		if (grade<0) {
			
			throw new RuntimeException("Invalid Grade: too low.");
		}
		
		if (grade < 60) {
			
			return 0;
		}
		
		else if (grade < 70) {
			
			return 1;
		}
		
		else if (grade < 80) {
			
			return 2;
		}
		
		else if (grade < 90) {
			
			return 3;
		}
		
		else if (grade <= 100) {
			
			return 4;
		}
		
		else {
			
			throw new RuntimeException("Invalid Grade: too high.");
		}
	}
	
	@Test
	public void testEnrollment() {
		ArrayList<Enrollment> enrollments = new ArrayList();
		for (Section sections:sections) {
		
			Student student = students.get(0);
			Enrollment enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(100);
			
			enrollments.add(enrollment);
			
			student = students.get(1);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(95);
			
			enrollments.add(enrollment);
	
			student = students.get(2);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(90);
			
			enrollments.add(enrollment);
			
			student = students.get(3);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(85);
			
			enrollments.add(enrollment);
	
			student = students.get(4);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(80);
			
			enrollments.add(enrollment);
	
			student = students.get(5);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(75);
			
			enrollments.add(enrollment);

			student = students.get(6);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(70);
			
			enrollments.add(enrollment);

			student = students.get(7);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(65);
			
			enrollments.add(enrollment);

			student = students.get(8);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(60);
			
			enrollments.add(enrollment);

			student = students.get(9);
			enrollment = new Enrollment(student.getStudentID(),sections.getSectionID());
			enrollment.setGrade(77);
			
			enrollments.add(enrollment);
		}
		
		assertEquals(getGPA(100),4,0);
		assertEquals(getGPA(95),4,0);
		assertEquals(getGPA(90),4,0);
		assertEquals(getGPA(85),3,0);
		assertEquals(getGPA(80),3,0);
		assertEquals(getGPA(75),2,0);
		assertEquals(getGPA(70),2,0);
		assertEquals(getGPA(65),1,0);
		assertEquals(getGPA(60),1,0);
		assertEquals(getGPA(77),2,0);
	
	}
	
	@Test
	public double getAvg(ArrayList<Enrollment> enrollments, Course course){
		
		ArrayList<Enrollment> totalGrades = enrollments;
		ArrayList<Course> physAvg = new ArrayList();
		ArrayList<Course> nursingAvg = new ArrayList();
		ArrayList<Course> chemAvg = new ArrayList();
		ArrayList<Course> compsiAvg = new ArrayList();
		ArrayList<Course> businessAvg = new ArrayList();
		
		if (course.getCourseName() == "Physics") {
			
			for (Enrollment enrollment : totalGrades){
				
				double total = 0;
				total += enrollment.getGrade();
				physAvg.add(total);
				
				double physAverage = total/physAvg.size();
				return physAverage;
				}
			}
		
		if (course.getCourseName() == "Nursing") {
			
			for (Enrollment enrollment : totalGrades){
				
				double total = 0;
				total += enrollment.getGrade();
				nursingAvg.add(total);
				
				double nursingAverage = total/nursingAvg.size();
				return nursingAverage;
			
				}
			}
		
		if (course.getCourseName() == "Chemistry") {
			
			for (Enrollment enrollment : totalGrades) {
				
				double total = 0;
				total += enrollment.getGrade();
				chemAvg.add(total);
				
				double chemAverage = total/chemAvg.size();
				return chemAverage;
				}
			}
		
		if (course.getCourseName() == "Computer Science") {
			
			for (Enrollment enrollment : totalGrades){
				
				double total = 0;
				total += enrollment.getGrade();
				compsiAvg.add(total);
				
				double compsiAverage = total/compsiAvg.size();
				return compsiAverage;
			
				}
			}
		
		if (course.getCourseName() == "Business") {
			
			for (Enrollment enrollment : totalGrades){
				
				double total = 0;
				total += enrollment.getGrade();
				businessAvg.add(total);
				
				double businessAverage = total/businessAvg.size();
				return businessAverage;
				}
			}
		
		else {
			
			throw new RuntimeException ("Error: course does not exist.");
		}
		
		assertEquals(getAvg(enrollments, course),(100+99+98+97+96+95+94)/7,0);
		
	}

	@Test
	public void testAvg() {
		
		for (Course course:courses) {
		
			assertEquals(97,(100+99+98+97+96+95+94)/7,0);
		}
	}

	students.get(1).seteMajor(eMajor.COMPSI);

}