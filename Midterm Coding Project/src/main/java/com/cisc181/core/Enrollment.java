package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	
	private UUID sectionID;
	private UUID studentID;
	private UUID enrollmentID;
	private double grade;
	
	public void setSectionID(UUID SectionID) {
		
		sectionID = SectionID;
	}
		
	public UUID getSectionID() {
		
		return sectionID;
	}

	public void setStudentID(UUID StudentID) {
		
		studentID = StudentID;
	}
	
	public UUID getStudentID() {
		
		return studentID;
	}
	
	public void setEnrollmentID(UUID enrollmentID) {
		
		EnrollmentID = enrollmentID;
	}
	
	public UUID getEnrollmentID() {
		
		return EenrollmentID;
	}
	
	public void setGrade(double Grade) {
		
		grade = Grade;
	}
	
	public double getGrade() {
		
		return grade;
	}
	
	private Enrollment() { }

	public Enrollment(UUID SectionID, UUID StudentID) {
		
		super();
		this.SectionID = SectionID;
		this.StudentID = StudentID;
		this.setEnrollmentID(EnrollmentID);
	}
}
