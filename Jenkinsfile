pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t java-counter-app:latest .'
            }
        }

        stage('Deploy Container') {
            steps {
                sh '''
                  docker stop java-counter || true
                  docker rm java-counter || true
                  docker run -d --name java-counter -p 8080:8080 java-counter-app:latest
                '''
            }
        }
    }
}
