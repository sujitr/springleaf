package com.sujit.rest.webservice.staticfilter;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookResource {
	@GetMapping("/books")
	public List<Book> getBooks(){
		return Arrays.asList(new Book(2345,"Mastering Java 8","Brian Hodge",34.45),
				new Book(4512,"Spring Boot Series 2","Jospeh Gilfoyle",12.34));
	}
}
