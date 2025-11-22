pipeline {
    agent any

    triggers {
        // Démarre automatiquement à chaque push (à activer seulement pour les tests)
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                // Récupérer le code source depuis le git
                git(
                    branch: 'main',
                    url: 'https://github.com/LemsiXIV/DevOps_Vagrant.git'
                )
            }
        }
        stage('Show System Date') {
            steps {
                // Afficher la date système
                sh 'date'
            }
        }
    }
}