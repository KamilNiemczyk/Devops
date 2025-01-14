pipeline{
    agent any
    environment{
        NAME = 'kamilniemczyk/jenkins'
        TAG = "${BUILD_NUMBER}"
        DOCKER_CREDENTIALS = credentials('dockerhub-credentials')
    }
    stages{
        stage('Build image'){
            steps{
                script{
                    sh 'docker build -t $NAME:$TAG demo/.'
                }
            }
        }
        stage ('Push image'){
            steps{
                script{
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"
                        sh "docker push $NAME:$TAG"
                    }
                }
        } 
    }    
    } 
}