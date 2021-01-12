package com.sujit.rest.webservice.dynamicfilter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class PublisherResource {
	@GetMapping("/publisher")
	public MappingJacksonValue getPublisher() {
		Publisher publisher = new Publisher("PACKT", "Bangalore", "89643");
		
		// need to filter out only phone in this response
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name","address");
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("publisherFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(publisher);
		mapping.setFilters(filterProvider);
		
		return mapping;
	}
	
	@GetMapping("/publisher-list")
	public MappingJacksonValue getAllPublishers() {
		List<Publisher> publisher = Arrays.asList(new Publisher("PACKT", "Bangalore", "89643"), 
				new Publisher("Manning", "New York", "542734"));
		
		// need to filter out only address in this response
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name","phone");
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("publisherFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(publisher);
		mapping.setFilters(filterProvider);
		
		return mapping;
	}
	
	
	
}
