Contract Testing Consumer
=======================
![Build with Gradle](https://github.com/czerwinskimarek/contract-testing-consumer/actions/workflows/gradle.yml/badge.svg)
[![Renovate enabled](https://img.shields.io/badge/renovate-enabled-brightgreen.svg)](https://renovatebot.com/)

Overview
--------
This repository contains the application which demonstrates how Spring Cloud Contract can be used on the consumer side.

How the code is organized
-------------------
- [CustomerClient.kt](src/main/kotlin/com/example/customer/consumer/CustomerClient.kt) - sample client
- [CustomerClientTest.groovy](src/test/kotlin/com/example/customer/consumer/CustomerClientTest.kt) - class which uses stub runner and run contract tests on the consumer side

How to run static code analysis
-------------------
Execute:
```bash
./gradlew detekt
```

How to run contract tests
-------------------
Firstly, [build the app on the producer side](https://github.com/czerwinskimarek/contract-testing-producer#how-to-run-contract-tests) to publish the stubs to Maven Local.

Secondly, Execute:
```bash
./gradlew clean build
```

To:
- build the app
- use spring-cloud-contract-stub-runner-spring to download the stub of contract-testing-producer
- run the tests against stubbed server
