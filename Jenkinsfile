def gv

pipeline {
    agent any
  //  {
    //   docker{ image 'demo-app:1.0' }
  //}
     tools {
        maven 'maven'
      
    }
 stages {
    stage('increment version') {
            steps {
                script {
                    echo 'incrementing app version...'
                    bat 'mvn build-helper:parse-version versions:set -DnewVersion=${parsedVersion.majorVersion}.${parsedVersion.minorVersion}.${parsedVersion.nextIncrementalVersion} versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                
                }
            }
         }
       

    
    stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
    stage("build jar") {
            steps {
                script {
                    echo "building jar"
                      echo "building the docker image..."
        withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        bat 'docker build -t hedi3zouaoui/demo-app:%BUILD_NUMBER% .'

        bat "docker login -u $USER -p $PASS "
        bat 'docker push hedi3zouaoui/demo-app:%BUILD_NUMBER%'
    }
                }
            }
        }

 
    stage('commit version update') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: '3f34454e-e1b3-4991-810e-c7c116ffd197', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        // git config here for the first time run
                        bat 'git config --global user.email "jenkins@example.com"'
                        bat 'git config --global user.name "jenkins"'

                        bat "git remote set-url origin https://${USER}:${PASS}@gitlab.com/Hedi-zouaoui/API_customer_system_management.git"
                        bat 'git add .'
                        bat 'git commit -m "ci: version bump"'
                        bat 'git push origin HEAD:master'
                    }
                }
            }
        }

      
  }
}
