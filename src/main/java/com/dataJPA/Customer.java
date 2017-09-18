package com.dataJPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
//Indica que es una entidad JPA
//Se va a crear una tabla con el nombre Customer
public class Customer {
	
	@Id //JPA reconocerá el id como objeto ID
	@GeneratedValue(strategy=GenerationType.AUTO)//Para que se generé automaticamente
	private Long id;
	//Se asume que se crearan dos columnas, firstname y lastname
	private String firstName;
	private String lastName;
	
	//Solo existe por el JPA
	protected Customer() {}

	//Para crear instancias de Customer
	public Customer(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	//Imprimirá las propiedades del Customer
	public String toString() {
		return String.format( 
				"Customer[id=%d, firstName='%s', lastName='%s'",
				id, firstName, lastName);
	}
}
