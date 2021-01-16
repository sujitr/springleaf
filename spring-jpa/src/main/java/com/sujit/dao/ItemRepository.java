package com.sujit.dao;

import com.sujit.entity.Item;
import org.springframework.data.repository.CrudRepository;


/**
 * Defining a repository interface as below helps us to avoid the 
 * repetitive steps which are needed in general to create a DAO
 * service like - 
 * - declaring a repository (@Repository)
 * - Manage it with @Transactionsal
 * - Use an Entity Manager with @PersistenceContext etc
 */

public interface ItemRepository extends CrudRepository<Item, Long> {
    Item findById(long id);
}
