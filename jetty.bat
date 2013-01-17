call mvn clean:clean
call mvn -U package -Dmaven.test.skip=true 
call mvn jetty:run
@pause
