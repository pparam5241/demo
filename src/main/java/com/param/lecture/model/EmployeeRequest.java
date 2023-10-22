package com.param.lecture.model;

public class EmployeeRequest {

	private int id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String mobileNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public EmployeeRequest(String name, String address, String city, String state, String mobileNo) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.mobileNo = mobileNo;
	}

	public EmployeeRequest(int id, String name, String address, String city, String state, String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.mobileNo = mobileNo;
	}

	public EmployeeRequest() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeRequest [name=" + name + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", mobileNo=" + mobileNo + "]";
	}
}