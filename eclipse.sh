#!/bin/sh
mvn eclipse:clean
mvn -U eclipse:eclipse -DdownloadSources=true -DdownloadJavadocs=true
