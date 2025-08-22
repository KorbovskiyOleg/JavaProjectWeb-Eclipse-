package com.olegkorbovskij.cardatabase.dto;

public class CarDTO{
	private String brand;
    private String model;
    private String color;
    private int make;
    private int price;
    private String ownerName;  // Имя владельца
    private String ownerSurname; // Фамилия влыдельца
    
    
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMake() {
		return make;
	}
	public void setMake(int make) {
		this.make = make;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerSurname() {
		return ownerSurname;
	}
	public void setOwnerSurname(String ownerSurname) {
		this.ownerSurname = ownerSurname;
	} 
	
    
	
	
}





