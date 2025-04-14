// def call(String credId,String img, String tag){

//   withCredentials([usernamePassword(
//                     credentialsId: credId,
//                     passwordVariable:"dockerHubPass",
//                     usernameVariable:"dockerHubUser")])
//                 {
//                 echo " pushing the image create to docker hun"
//                 sh "docker tag ${img}:{tag} shan365/${img}:${tag}"
//                 echo "docker login"
//                 sh "docker login -u  ${env.dockerHubUser} -p ${env.dockerHubPass}"
//                 sh "docker push shan365/${img}:${tag}"
//                 }
// }

def call(String credId, String img, String tag) {
    withCredentials([usernamePassword(
        credentialsId: credId,
        passwordVariable: 'dockerHubPass',
        usernameVariable: 'dockerHubUser'
    )]) {
        echo "Pushing the image to Docker Hub"

        // Use double quotes for interpolation
        sh "docker tag ${img}:${tag} shan365/${img}:${tag}"
        
        echo "Logging into Docker Hub"
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
        
        sh "docker push shan365/${img}:${tag}"
    }
}
