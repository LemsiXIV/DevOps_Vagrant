pipeline {
    agent any

    stages {
        stage('checkout git') {
            steps {
                echo 'pulling...'
                git(
                    branch: 'main',
                    url: 'https://github.com/LemsiXIV/DevOps_Vagrant.git'
                )
            }
        }
    }
}