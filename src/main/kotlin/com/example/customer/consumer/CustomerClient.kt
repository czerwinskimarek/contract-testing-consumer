package com.example.customer.consumer

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

class CustomerClient(
    private val restTemplate: RestTemplate
) {

    fun getAllCustomers(): Collection<Customer> {
        val responseEntity: ResponseEntity<Collection<Customer>> =
            this.restTemplate.exchange(
                "http://localhost:8081/customers",
                HttpMethod.GET,
                null,
                typeReference<Collection<Customer>>()
            )
        return checkNotNull(responseEntity.body)
    }
}

private inline fun <reified T> typeReference() = object : ParameterizedTypeReference<T>() {}

data class Customer(
    val id: Long,
    val name: String
)
