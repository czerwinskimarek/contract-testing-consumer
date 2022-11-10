package com.example.customer.consumer

import org.assertj.core.api.BDDAssertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties

@SpringBootTest(classes = [CustomerClientConfiguration::class])
@AutoConfigureStubRunner(
    ids = ["com.example:contract-testing-producer:+:8081"],
    stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
class CustomerClientTest {

    @Autowired
    private lateinit var customerClient: CustomerClient

    @Test
    fun clientShouldReturnAllCustomers() {
        val customers: Collection<Customer> = this.customerClient.getAllCustomers()
        BDDAssertions.then(customers).size().isEqualTo(2)
        BDDAssertions.then(customers.first().id).isEqualTo(1L)
        BDDAssertions.then(customers.iterator().next().name).isEqualTo("Jane")
    }
}
