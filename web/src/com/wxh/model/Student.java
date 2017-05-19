package com.wxh.model;

import java.util.Date;

public class Student {

	private Date birth;

	private int studentId;

	private String studentNum;

	private String studentName;

	private String studentGrade;

	public Date getBirth() {
		return birth;
	}

	 public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getStudentId() {
		return studentId;
	}

	 public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentNum() {
		return studentNum;
	}

	 public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentName() {
		return studentName;
	}

	 public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentGrade() {
		return studentGrade;
	}

	 public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}

}