package com.sujit;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringJpaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaRestApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(ReservationRepository rr){
		return args -> {
			Arrays.asList("Les,Josh,Phil,Sasha,Peter".split(","))
				.forEach(n -> rr.save(new Reservation(n)));
			
			rr.findAll().forEach(System.out::println);
			rr.findByReservationName("Les").forEach(System.out::println);
		};
	}
}


/**
 * Using a Rest Controller is not always a best way to 
 * expose a REST API. It can be done more cleanly with 
 *  a new Spring feature on top of the repository itself.
 *  Like either JpaRepository or CrudRepository.
 */

/*
@RestController
class ReservationRestController {
	@RequestMapping("/reservations")
	Collection<Reservation> reservations(){
		return this.reservationRepository.findAll();
	}
	
	@Autowired 
	private ReservationRepository reservationRepository;
}*/


/**
 * This method automatically exposes the repository as REST interface
 * to browser as HAL+JSON (HATEOAS) documents
 */
@RepositoryRestResource
interface ReservationRepository extends JpaRepository<Reservation, Long> {
	Collection<Reservation> findByReservationName (@Param("rn") String rn);
}

/**
 * This component helps add extra links to the repository resources.
 * In this case it's adding a profile photo link based on the id of the
 * underlying reservation resource.
 * For example, each reservation has a profile photo attached to it.
 */
@Component
class ReservationsResourceProcessor implements ResourceProcessor<Resource<Reservation>> {
	@Override
	public Resource<Reservation> process(Resource<Reservation> resource) {
		resource.add(new Link("http://s3.com.images/"+resource.getContent().getId()+".jpg","profile-photo"));
		return resource;
	}
	
}


@Entity
class Reservation {
	@javax.persistence.Id
	@GeneratedValue
	private Long Id;
	private String reservationName;
	
	public Reservation(){
	}
	
	public Reservation(String reservationName) {
		super();
		this.reservationName = reservationName;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	@Override
	public String toString() {
		return "Reservation {Id=" + Id + ", reservationName='" + reservationName + "'}";
	}
	
}

