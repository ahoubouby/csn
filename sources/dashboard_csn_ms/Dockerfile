#FROM sal-container-registry.k8s-dev.iamdg.net.ma/baseimg-tomcat:0.0.1
#USER 0
#RUN openssl s_client -showcerts -connect sal-keycloak.k8s-dev.iamdg.net.ma:443 -servername  sal-keycloak.k8s-dev.iamdg.net.ma > cert.pem
#RUN keytool -storepass "changeit" -importcert -file cert.pem -keystore /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.242.b08-0.el7_7.x86_64/jre/lib/security/cacerts -alias "Certifkeyc" -noprompt
#USER 10001

FROM tomcat:jdk8
RUN openssl s_client -showcerts -connect sal-keycloak.k8s-dev.iamdg.net.ma:443 -servername  sal-keycloak.k8s-dev.iamdg.net.ma > cert.pem
RUN keytool -storepass "changeit" -importcert -file cert.pem -keystore /usr/local/openjdk-8/jre/lib/security/cacerts -alias "Certifkeyc" -noprompt

COPY dashboard_csn_service/target/*.war $CATALINA_HOME/webapps/