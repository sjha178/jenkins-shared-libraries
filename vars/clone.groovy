// def call(String url, String branch){
//   git url: "${url}", branch: "${branch}"
// }
def clone(String url, String branch){
  git url: url, branch: branch
}

