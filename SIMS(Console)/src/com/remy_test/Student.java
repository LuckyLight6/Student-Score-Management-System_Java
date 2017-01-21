package com.remy_test;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = -4776501817076966311L;

	// 学号
	private String studentId;
	// 姓名
	private String name;
	// 专业
	private String specialty;
	// 班级
	private String classAndGrade;
	// 英语成绩
	private int english;
	// C语言成绩
	private int cLanguage;
	// 体育成绩
	private int pe;
	// 高数成绩
	private int math;
	// 大学物理成绩
	private int physics;
	// MATLAB成绩
	private int matlab;

	public Student() {
		super();
	}

	public Student(String studentId, String name, String specialty, String classAndGrade, int english, int cLanguage,
			int pe, int math, int physics, int matlab) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.specialty = specialty;
		this.classAndGrade = classAndGrade;
		this.english = english;
		this.cLanguage = cLanguage;
		this.pe = pe;
		this.math = math;
		this.physics = physics;
		this.matlab = matlab;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getClassAndGrade() {
		return classAndGrade;
	}

	public void setClassAndGrade(String classAndGrade) {
		this.classAndGrade = classAndGrade;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getcLanguage() {
		return cLanguage;
	}

	public void setcLanguage(int cLanguage) {
		this.cLanguage = cLanguage;
	}

	public int getPe() {
		return pe;
	}

	public void setPe(int pe) {
		this.pe = pe;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getMatlab() {
		return matlab;
	}

	public void setMatlab(int matlab) {
		this.matlab = matlab;
	}

	public int getScoreSum() {
		return this.english + this.cLanguage + this.pe + this.math + this.physics + this.matlab;
	}

	public double getScoreAvg() {
		return (this.english + this.cLanguage + this.pe + this.math + this.physics + this.matlab) / 6.0;
	}
}