# Dockerfile for Drone database
FROM wnameless/oracle-xe-11g-r2
EXPOSE 1521
# Set oracle db encoding to UTF-8
ENV NLS_LANG=.AL32UTF8
# Add scripts that creates the default schemas needed by Drone
#all scripts exist in this init-scripts
ADD init-scripts/* /docker-entrypoint-initdb.d/