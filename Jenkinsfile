pipeline {
  agent none

  options {
    disableConcurrentBuilds()
  }

  stages {
    stage('package and publish') {
      agent any
      steps {
         sh 'sbt clean compile'
      }
    }
  }
  post {
    always {
      node("") {
        cleanWs()
      }
    }
  }
}
