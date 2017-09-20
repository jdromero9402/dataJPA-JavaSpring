package com.dataJPA;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class App 
{
	private static final Logger log = LoggerFactory.getLogger(App.class);
	private Long id = (long) 0;
	
    public static void main( String[] args ){
        SpringApplication.run(App.class);
    }
    
    @Bean 
    public CommandLineRunner demo(CustomerRepository repository) {
    	
    	return (arg) -> {
    		//guarda algunos customers
    		repository.save(new Customer(id,"Jack","Bauer"));
    		repository.save(new Customer(id,"Chloe","O'Brian"));
    		repository.save(new Customer(id,"Kim","Bauer"));
    		repository.save(new Customer(id,"David","Palmer"));
    		repository.save(new Customer(id,"Michelle","Dessler"));
    		
    		//Busca todos los clientes
    		log.info("Customers found with findAll():");
    		log.info("-------------------------------");
    		for (Customer customer : repository.findAll()) {
    			log.info(customer.toString());
    		}
    		log.info("");
    		
    		//Busca a un customer por ID
    		Customer customer = repository.findOne(1L);
    		log.info("Customer found with findOne(1L):");
    		log.info("--------------------------------");
    		log.info(customer.toString());
    		log.info("");
    		
    		//Busca los customers por el apellido
    		log.info("Customer found with findLastName('Bauer'):");
    		log.info("------------------------------------------");
    		for (Customer bauer : repository.findByLastName("Bauer")) {
    			log.info(bauer.toString());
    		}
    		log.info("");
    	};
    }
}

