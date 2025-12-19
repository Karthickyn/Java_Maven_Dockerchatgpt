pipeline {
    agent any

    environment {
        IMAGE_NAME = "java-counter-app"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Docker Image (Maven inside Docker)') {
            steps {
                sh 'docker build -t $IMAGE_NAME:latest .'
            }
        }
          stage('Deploy Container') {
    steps {
        sh '''
          docker stop java-counter || true
          docker rm java-counter || true
          docker run -d --name java-counter -p 9090:8080 java-counter-app:latest
        '''
    }
}

        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed!'
        }
        
    }
}
