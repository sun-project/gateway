pipeline {
  environment {
    image = 'sun-project/gateway'
    registry = 'https://registry.kirin.mydns.jp'
    registryCredential = 'registry.kirin.mydns.jp'
  }
  agent {
    label 'docker'
  }
  stages {
    stage('Build') {
      agent {
        docker { image 'java:8-jdk-alpine' }
      }
      steps {
        sh './mvnw package'
      }
      post {
        success {
          stash name: 'jar', includes: 'target/*.jar'
        }
      }
    }
    stage('Building image') {
      steps {
        unstash name: 'jar'
        script {
          dockerImage = docker.build env.image
        }
      }
    }
    stage('Deploy image') {
      steps {
        script {
          docker.withRegistry(registry, registryCredential) {
            dockerImage.push(env.BUILD_NUMBER)
            dockerImage.push("latest")
          }
        }
      }
    }
  }
  post {
    always {
      deleteDir()
    }
  }
}

