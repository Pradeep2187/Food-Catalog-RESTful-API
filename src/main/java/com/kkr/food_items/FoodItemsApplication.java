package com.kkr.food_items;

import com.kkr.food_items.Model.FoodItems;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableAutoConfiguration

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
public class FoodItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodItemsApplication.class, args);
	}

}
