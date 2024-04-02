package net.youssfi.customerservice;

import net.youssfi.customerservice.config.GlobalConfig;
import net.youssfi.customerservice.entities.Customer;
import net.youssfi.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class})
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {

			List<Customer> customerList=List.of(
					Customer.builder()
							.firstName("Name 1")
							.lastName("LName 1")
							.email("name1@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Name 2")
							.lastName("LName 2")
							.email("name2@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Name 3")
							.lastName("LName 3")
							.email("name3@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Name 4")
							.lastName("LName 4")
							.email("name4@gmail.com")
							.build()


			);
			customerRepository.saveAll(customerList);
		};
	}

}