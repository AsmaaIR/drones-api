# drones-api

<h3> add applications network : </h3>
docker network create drones-net  <br>
<h4> to add database image => cd to this path /drones-api/src/main/resources/oracledb  and run :</h4>
docker build -t drones-db .  <br>
<h4> database container: </h4>
docker run --network drones-net --network-alias oracledb1.local --name drones-db -d -p 1521:1521 -e ORACLE_ALLOW_REMOTE=true -e NLS_LANG=.AL32UTF8 drones-db 
<br>
<h6> database URL jdbc:oracle:thin:@oracledb.local:1521:XE user:system & pass=oracle </h6>
<br>
*------------------------------------------------------------------------------------------------------------*
<h2> Steps to run App</h2>
cd to drones-api folder <br>
1- mvn clean install -f pom.xml 
<br >
2- docker build -t drones-api-image .
<br >
3- docker run --network drones-net --network-alias drone.local --name drones-api-app -d -p 5555:5555 drones-api-image
<br >
navigate to http://localhost:5555/ <br >
<br>

<h4> OR: </h4>
cd to drones-api folder and open terminal or CMD  <br>

1- mvn clean install -f pom.xml  <br>

2- java -jar target/drones-0.0.1-SNAPSHOT.jar  <br>

*------------------------------------------------------------------------------------------------------------*
