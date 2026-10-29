# Jenkins Shared Library

Reusable Jenkins pipeline functions used by my CI/CD projects.

This library was created to move common pipeline logic out of individual Jenkinsfiles and keep CI/CD workflows smaller and easier to reuse.

## Functions

The library currently includes:

- `incrementVersion()` — increments the Node.js application version
- `runTests()` — installs dependencies and runs application tests
- `buildAndPushDockerImage()` — builds a versioned Docker image and pushes it to Docker Hub
- `commitVersionUpdate()` — commits the updated application version back to GitHub

## Structure

```text
jenkins-shared-library/
└── vars/
    ├── incrementVersion.groovy
    ├── runTests.groovy
    ├── buildAndPushDockerImage.groovy
    └── commitVersionUpdate.groovy
```

## Usage

The library is configured in Jenkins as a Global Pipeline Library and loaded in a Jenkinsfile with:

```groovy
@Library('jenkins-shared-library') _
```

Pipeline stages can then call the shared functions instead of repeating the underlying Jenkins and Groovy logic:

```groovy
incrementVersion()
runTests()
buildAndPushDockerImage('teanaa/jenkins-node-app', version)
commitVersionUpdate()
```

## Related Project

This library is used by my [jenkins-ci-cd-pipeline](https://github.com/Tea-naa/jenkins-ci-cd-pipeline) project, which automates Node.js application testing, versioning, Docker image publishing, and deployment to AWS EC2.

The `commitVersionUpdate()` function was implemented as part of the Jenkins CI/CD workflow. Its pipeline stage is currently disabled to prevent automated GitHub commits from repeatedly triggering webhook builds.
