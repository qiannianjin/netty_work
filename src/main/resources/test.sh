docker rm mytest
docker rmi mytest:latest
docker build -t mytest:latest -f Dockerfile .
docker run -p 8000:8080 -v /root/workspace/schedulelogs:/src/main/resources/schedulelogs --restart=always  --name=mytest  mytest:latest
