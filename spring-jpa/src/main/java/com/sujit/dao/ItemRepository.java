package com.sujit.dao;

import com.sujit.entity.Item;
import org.springframework.data.repository.CrudRepository;


/**
 * Defining a repository interface as below helps us to avoid the 
 * repetitive steps which are needed in general to create a DAO
 * service like - 
 * - declaring a repository (@Repository)
 * - Manage it with @Transactionsal, for declarative transaction management
 * 		which basically says each method within the repo class would be involved in a transaction
 * - Use an Entity Manager with @PersistenceContext for tracking changes etc
 */

public interface ItemRepository extends CrudRepository<Item, Long> {
    Item findById(long id);
}
