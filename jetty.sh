#!/bin/sh
mvn clean:clean
mvn -U package -Dmaven.test.skip=true
mvn jetty:run
