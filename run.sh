sudo mvn clean install &&
$(sudo nohup mvn tomcat7:run &>/dev/null &);
echo "starting server";
while [ $(wget "localhost:8000" > grep -o -i "refused" | wc -l) -eq 1 ];
do sleep 2;
done;
echo "server started at port 8000"