pipeline {
    agent any

    tools {
        maven 'MAVEN_3_9'
    }

    environment {

        DOCKERHUB_USER_NAME = "berciskubrayildiz"
        IMAGE_NAME = "${DOCKERHUB_USER_NAME}/devopsproject"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build(IMAGE_NAME, ".")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    // dockerhub-creds
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-creds') {


                        docker.image(IMAGE_NAME).push("${env.BUILD_NUMBER}")

                        docker.image(IMAGE_NAME).push("latest")
                    }
                }
            }
        }
    }
}