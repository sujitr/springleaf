package com.sujit.dao;

import com.sujit.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Item findById(long id);
}
