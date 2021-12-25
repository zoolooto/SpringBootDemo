package com.example.springbootdemo.entity;


import java.io.Serializable;

/**
 * @author liuwang
 * @create 2021-12-06 22:18:41 
 * @description  
 */

@SuppressWarnings("all")
public class Pagelog implements Serializable {

	private Integer id;

	private String name;

	private Integer loginNumber;

	private String consumption;

	public Pagelog() {}

	public Pagelog(Integer id, String name, Integer loginNumber, String consumption) {
		this.id = id;
		this.name = name;
		this.loginNumber = loginNumber;
		this.consumption = consumption;
	}

	public Pagelog(String name, Integer loginNumber, String consumption) {
		this.name = name;
		this.loginNumber = loginNumber;
		this.consumption = consumption;
	}

	@Override
	public String toString() {
		return "Pagelog{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", loginNumber='" + loginNumber + '\'' +
				", consumption='" + consumption + '\'' +
				'}';
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLoginNumber() {
		return this.loginNumber;
	}

	public void setLoginNumber(Integer loginNumber) {
		this.loginNumber = loginNumber;
	}

	public String getConsumption() {
		return this.consumption;
	}

	public void setConsumption(String consumption) {
		this.consumption = consumption;
	}

}
