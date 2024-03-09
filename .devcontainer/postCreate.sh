echo "Running devcontainer postcreate"

sudo apt update && sudo apt upgrade -y
sudo apt install -y maven
pwd
mvn -B clean install