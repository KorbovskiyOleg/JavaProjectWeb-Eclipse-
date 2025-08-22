package com.olegkorbovskij.cardatabase.dto;

public class OwnerDTO {
    private String firstName;
    private String lastName;
    
 // Конструкторы
    public OwnerDTO() {}
    
    public OwnerDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
    
 // Геттеры и сеттеры
    

}
