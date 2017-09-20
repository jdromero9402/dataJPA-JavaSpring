package com.dataJPA;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//CrudRepository ya viene con los metodos crud implementados
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	//findByLastName hace la labor de busqueda por el LastName
	List<Customer> findByLastName(String lastName);
}
