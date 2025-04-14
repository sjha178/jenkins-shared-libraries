def call(String img, String tag)
{
  echo "building the code"
  sh "docker build -t ${img}:${tag} ."
}
