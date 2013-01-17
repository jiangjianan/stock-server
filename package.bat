call mvn clean:clean
call mvn -U package -Dmaven.test.skip=true 
@pause
