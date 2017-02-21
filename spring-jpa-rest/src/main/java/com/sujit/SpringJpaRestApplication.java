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
			Arrays.asList("Sujit,Harish,Kittu,Sivanand".split(","))
				.forEach(n -> rr.save(new Reservation(n)));
			
			rr.findAll().forEach(System.out::println);
		};
	}
}


@RestController
class ReservationRestController {
	@RequestMapping("/reservations")
	Collection<Reservation> reservations(){
		return this.reservationRepository.findAll();
	}
	
	@Autowired 
	private ReservationRepository reservationRepository;
	
	
}


interface ReservationRepository extends JpaRepository<Reservation, Long> {
	Collection<Reservation> findByReservationName (String rn);
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

