package com.core.pojo;

public enum BookGenre {

	EDU("Education"), 
	ADV("Adventure"),
	C("Classic"),
	CB("Comic_Book"),
	MYS("Mystery"),
	HI("History"),
	HR("Horror"),
	NO("Novel"),
	P("Poetry"),
	FF("Fantasy_Fiction");
		
	private String value;
	
	private BookGenre(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
