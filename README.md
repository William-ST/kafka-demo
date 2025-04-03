Kafka 3.4.1
modificar la conf para que trabaje en windows

./mvnw clean package -DskipTests
docker build -t kafka-springboot-demoapp:latest .

docker-compose down -v
docker-compose up -d --build



williamst

docker tag kafka-springboot-demoapp:latest williamst/kafka-springboot-demoapp:latest

docker push williamst/kafka-springboot-demoapp:latest