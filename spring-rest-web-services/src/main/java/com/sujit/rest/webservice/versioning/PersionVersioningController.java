package com.sujit.rest.webservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * There are various ways in which versioning could be implemented.
 * Each having their own pros and cons.
 * In general below are the list of factors/tradeoffs while going for any
 * one of them.
 * 
 * - URI Pollution
 * - Misuse of HTTP Headers
 * - Caching
 * - Can one execute the request on the browser?
 * - API Documentation
 * 
 * There are no perfect solution for this, but it depends on use case.
 */
@RestController
public class PersionVersioningController {
	
	// Basic way of versioning with different request mapping
	@GetMapping("v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Rudy Mancuso");
	}
	
	// Basic way of versioning with different request mapping
	@GetMapping("v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Rudy","Mancuso"));
	}
	
	/*
	 * Another method of versioning with request query parameters
	 */
	@GetMapping(value="/person/param",params="version=1")
	public PersonV1 getPersonParamV1() {
		return new PersonV1("Rudy Mancuso");
	}
	
	@GetMapping(value="/person/param",params="version=2")
	public PersonV2 getPersonParamV2() {
		return new PersonV2(new Name("Rudy","Mancuso"));
	}
	
	/*
	 * Another method of versioning with header parameters
	 */
	@GetMapping(value="/person/header",headers="X-API-VERSION=1")
	public PersonV1 getPersonHeaderV1() {
		return new PersonV1("Rudy Mancuso");
	}
	
	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public PersonV2 getPersonHeaderV2() {
		return new PersonV2(new Name("Rudy","Mancuso"));
	}
	
	/*
	 * Another method of versioning with MIME type or 'Content Negotiation' or 'Accept Versioning'
	 * GET request head should have 'Accept' key with one of the two produces value below.
	 */
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public PersonV1 getPersonProducesV1() {
		return new PersonV1("Rudy Mancuso");
	}
	
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+json")
	public PersonV2 getPersonProducesV2() {
		return new PersonV2(new Name("Rudy","Mancuso"));
	}
}
