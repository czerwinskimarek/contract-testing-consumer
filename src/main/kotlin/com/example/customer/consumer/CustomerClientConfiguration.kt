package com.example.customer.consumer

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class CustomerClientConfiguration {

    @Bean
    fun restTemplate(): RestTemplate = RestTemplate()

    @Bean
    fun customerClient(restTemplate: RestTemplate): CustomerClient = CustomerClient(restTemplate)
}
