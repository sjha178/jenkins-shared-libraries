def call(String img, String version)
{
  echo "building the code"
  sh "docker build -t ${img}:${version} ."
}
