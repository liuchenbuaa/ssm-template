mvn clean package

cp target/ssm-template-1.0-SNAPSHOT.war /Users/liuchen/tomcat/tomcat/webapps/ROOT.war

id=`ps -ef|grep tomcat|grep -v grep|grep -v PPID|awk '{ print $2}'`

echo $id

kill -9 $id

rm -rf /Users/liuchen/tomcat/tomcat/webapps/ROOT

/Users/liuchen/tomcat/tomcat/bin/startup.sh

tail -f /Users/liuchen/tomcat/tomcat/logs/catalina.out
