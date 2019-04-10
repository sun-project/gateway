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
      steps {
        sh './mvnw package'
      }
    }
    stage('Building image') {
      steps {
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

