pipeline{
    agent any

    tools{
        maven "maven"
    }

    stages{

        stage("SCM checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/vanithakannanjo/jenkin-ci-cd.git']])
            }
        }

        stage("Build Process"){
            steps{
                script{
                    bat 'mvn clean install'
                }
            }
        }

        stage("Deploy to Container"){
            steps{
               deploy adapters: [tomcat9(credentialsId: 'cf8dabd5-1c21-4478-9966-715112b26d87', path: '', url: 'http://localhost:8092/')], contextPath: 'jenkinsCiCd', war: '**/*.war'
            }
        }

    }

    post{
        always{
            emailext attachLog: true,
            body: ''' <html>
    <body>
        <p>Build Status: ${BUILD_STATUS}</p>
        <p>Build Number: ${BUILD_NUMBER}</p>
        <p>Check the <a href="${BUILD_URL}">console output</a>.</p>
    </body>
</html>''', mimeType: 'text/html', replyTo: 'vkgenps@gmail.com', subject: 'Pipeline Status : ${BUILD_NUMBER}', to: 'vkgenps@gmail.com'

        }
    }
}
