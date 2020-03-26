package com.awg.j20.simpsons.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartoonCharacter {
	@JsonProperty("_id")
	private String dbId;
	private String key;
	private String firstName;
	private String lastName;
	@JsonProperty("picture")
	private String pictureUrl;
	private int age;
	
	public String dbId() {
		return dbId;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String id) {
		this.key = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("CharacterCartoon: {");
		sb.append("firstname:").append(firstName)
		  .append(",lastname:").append(lastName)
		  .append(",picture:").append(pictureUrl)
		  .append(",age:").append(age)
		  .append("}");
		return sb.toString();
	}
	
	

}
