package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long Id;
	String 	fullName;
	String empCode;
	Long mobile;
	String position;
	
	
	public Employee() {
		super();
	}


	public Employee(Long id, String fullName, String empCode, Long mobile, String position) {
		this.Id = id;
		this.fullName = fullName;
		this.empCode = empCode;
		this.mobile = mobile;
		this.position = position;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public Employee(String fullName, String empCode, Long mobile, String position) {
		super();
		this.fullName = fullName;
		this.empCode = empCode;
		this.mobile = mobile;
		this.position = position;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmpCode() {
		return empCode;
	}


	public void setEMPCode(String empCode) {
		this.empCode = empCode;
	}


	public Long getMobile() {
		return mobile;
	}


	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	@Override
	public String toString() {
		return  fullName + ": " + position+" :: "+this.empCode;
	}
	
	
	
	

}
