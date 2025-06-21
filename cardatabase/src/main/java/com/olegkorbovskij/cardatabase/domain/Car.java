package com.olegkorbovskij.cardatabase.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;;

@Entity
public class Car {
	
	 	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private long id;
	 	
	 	private String brand, model, color, registerNumber;
	 	private int yearOfCar, price;
	 	
	 	
	 	public Car() {}


		public Car(String brand, String model, String color, String registerNumber, int yearOfCar, int price) {
			super();
			this.brand = brand;
			this.model = model;
			this.color = color;
			this.registerNumber = registerNumber;
			this.yearOfCar = yearOfCar;
			this.price = price;
		}
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="owner")
		private Owner owner;
		
		


		public Owner getOwner() {
			return owner;
		}


		public void setOwner(Owner owner) {
			this.owner = owner;
		}


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


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


		public String getRegisterNumber() {
			return registerNumber;
		}


		public void setRegisterNumber(String registerNumber) {
			this.registerNumber = registerNumber;
		}


		public int getYearOfCar() {
			return yearOfCar;
		}


		public void setYearOfCar(int yearOfCar) {
			this.yearOfCar = yearOfCar;
		}


		public int getPrice() {
			return price;
		}


		public void setPrice(int price) {
			this.price = price;
		}
	 	
		
		
		

}
