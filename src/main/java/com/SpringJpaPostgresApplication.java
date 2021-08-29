package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties({AppProperties.class})
public class SpringJpaPostgresApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringJpaPostgresApplication.class, args);
        AppProperties properties = context.getBean(AppProperties.class);
        properties.generateData(properties.getPersonInfo(), properties.getClient(), properties.getPosition(),
                properties.getTourStaff(), properties.getCountry(), properties.getCity(), properties.getHotel(),
                properties.getTypeOfFood(), properties.getTypeOfRoom(), properties.getTour(),
                properties.getAddService(), properties.getOrder(), properties.getTourists(),
                properties.getTourAddService(), properties.getChoosenService(),
                properties.getInsurance(), properties.getInsuranceType(),
                properties.getInsuranceOption(), properties.getPersonInsurance(),
                properties.getInsuranceCase());
    }
}

