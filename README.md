Contract Testing Consumer
=======================

[![Renovate enabled](https://img.shields.io/badge/renovate-enabled-brightgreen.svg)](https://renovatebot.com/)

Overview
--------
This repository contains the application which demonstrates how Spring Cloud Contract can be used on the consumer side.

How to run static code analysis
-------------------
Execute:
```bash
./gradlew detekt
```

How to run contract tests
-------------------
Execute:
```bash
./gradlew clean build
```

To:
- build the app
- use spring-cloud-contract-stub-runner-spring to download the stub of contract-testing-producer
- run the tests against stubbed server
