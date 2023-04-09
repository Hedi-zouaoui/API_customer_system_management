def buildJar() {
    echo "building the application..."
    bat 'mvn -B -DskipTests clean package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        bat 'docker build -t hedi3zouaoui/demo-app .'

        bat "docker login -u $USER -p $PASS "
        bat 'docker push hedi3zouaoui/demo-app'
    }

    
} 



return this
