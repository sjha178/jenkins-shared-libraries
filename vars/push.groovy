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

// def call(Map config = [:]) {
//     def imageName = config.imageName ?: error("Image name is required")
//     def imageTag = config.imageTag ?: 'latest'
//     def credentials = config.credentials ?: 'docker-hub-credentials'
    
//     echo "Pushing Docker image: ${imageName}:${imageTag}"
    
//     withCredentials([usernamePassword(
//         credentialsId: credentials,
//         usernameVariable: 'DOCKER_USERNAME',
//         passwordVariable: 'DOCKER_PASSWORD'
//     )]) {
//         sh """
//             echo "\$DOCKER_PASSWORD" | docker login -u "\$DOCKER_USERNAME" --password-stdin
//             docker push ${imageName}:${imageTag}
//             docker push ${imageName}:latest
//         """
//     }
// }
