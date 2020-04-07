package com.sujit;

import com.sujit.dao.EmployeeJoinRepository;
import com.sujit.dao.ItemRepository;
import com.sujit.dto.EmployeeDepartmentDto;
import com.sujit.entity.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    /*
    Demo bean to query all items and items by ID.
    This bean uses the ItemRepository for queries.
     */
    @Bean
    public CommandLineRunner itemDemo(ItemRepository itemRepository){
        return (args)->{
          for(Item item : itemRepository.findAll()){
              logger.info("Item is : {}",item);
          }

          int itemId = 2;
          Item item = itemRepository.findById(itemId);
          logger.info("Item with ID {} is {}",itemId, item);
        };
    }

    /*
    Demo bean to show inner join query between employee table and
    department table. The query results are achieved by using
    EmployeeJoinRepository and query data collected at
    EmployeeDepartmentDto class.
     */
    @Bean
    public CommandLineRunner empDemo(EmployeeJoinRepository employeeJoinRepository){
        return (args)->{
            for(EmployeeDepartmentDto item : employeeJoinRepository.fetchEmpDeptCrossJoin()){
                logger.info("Join Query Item is {}",item);
            }
        };
    }
}
