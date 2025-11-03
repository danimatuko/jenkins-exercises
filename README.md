# Jenkins Exercises

This repository is part of the **DevOps Bootcamp** exercise for
**“Build Automation with Jenkins.”**

## Overview

This project demonstrates CI/CD fundamentals using **Jenkins** to automate building, testing, and deployment of a simple Node.js application.

## Shared Library Integration

This project works together with the [**jenkins-exercises-shared-lib**](https://github.com/danimatuko/jenkins-exercises-shared-lib) repository, which contains reusable Jenkins pipeline functions.
The library helps keep pipeline code clean, modular, and easy to maintain.

## Tests

The project uses **Jest** for testing.
It currently includes one test (`server.test.js`) that checks whether the `index.html` file exists.

### Run Tests

```bash
npm install
npm run test
```

To simulate a failing test, rename or remove `index.html` and re-run the tests.
