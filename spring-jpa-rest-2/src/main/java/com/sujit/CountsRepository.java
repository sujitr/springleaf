package com.sujit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CountsRepository extends CrudRepository<Counts, Integer> {
}
