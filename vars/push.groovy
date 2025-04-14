def call(String credId,String img, String tag){

  withCredentials([usernamePassword(
                    credentialsId: credId,
                    passwordVariable:"dockerHubPass",
                    usernameVariable:"dockerHubUser")])
                {
                echo " pushing the image create to docker hun"
                sh "docker tag ${img}:{tag} shan365/${img}:${tag}"
                echo "docker login"
                sh "docker login -u  ${env.dockerHubUser} -p ${env.dockerHubPass}"
                sh "docker push shan365/${img}:${tag}"
                }
}
