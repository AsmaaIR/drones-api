# drones-api


// add applications network <br>
docker network create drones-net  <br>

// database image /drones-api/src/main/resources/oracledb  <br>
docker build -t drones-db . 
<br>

// database container
docker run --network drones-net --network-alias oracledb1.local --name drones-db -d -p 1521:1521 -e ORACLE_ALLOW_REMOTE=true -e NLS_LANG=.AL32UTF8 drones-db 
<br>

// database URL jdbc:oracle:thin:@oracledb.local:1521:XE user:system & pass=oracle