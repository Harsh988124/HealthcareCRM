package com.healthcare.crm.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI healthcareCrmOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Healthcare CRM API")
                        .description("REST API documentation and interactive test UI for Healthcare CRM (Patients, Doctors, Appointments, Prescriptions, Medical Records, Billing, and Admin).")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Healthcare CRM Support")
                                .email("support@healthcare-crm.com"))
                        .license(new License().name("Apache 2.0")));
    }
}
