# core-java-security


## Introduction to SSL in Java
SHA2-256(stdin)= 93c89241c2172f4c6ff432accffa93f0e92d5dc77bd397418e4044b4bff56980




https://stackoverflow.com/questions/10108374/maven-how-to-run-a-java-file-from-command-line-passing-arguments
https://stackoverflow.com/questions/66966896/keytool-error-java-lang-exception-the-keyalg-option-must-be-specified


keytool -genkey -keypass password \                                                                        
                  -storepass password \      
                  -keystore serverkeystore.jks
                  

keytool -genkey -keypass password -keyalg RSA \                                                            
-storepass password \                        
-keystore serverkeystore.jks


keytool -export -storepass password \                                                                        
-file server.cer -keystore serverkeystore.jks

keytool -import -v -trustcacerts \                                                                           
                     -file server.cer \
                     -keypass password \
                     -storepass password \
                     -keystore clienttruststore.jks

mvn exec:java -Dexec.mainClass=com.corejavamodules.SimpleClient -Djavax.net.ssl.keyStore=serverkeystore.jks \
    -Djavax.net.ssl.keyStorePassword=password \
    -Djavax.net.ssl.trustStore=clienttruststore.jks \
    -Djavax.net.ssl.trustStorePassword=password -Djdk.tls.client.protocols=TLSv1.2 -Dhttps.protocols=TLSv1.2 -Djavax.net.debug=ssl

mvn exec:java -Dexec.mainClass=com.corejavamodules.SimpleServer -Djavax.net.ssl.keyStore=serverkeystore.jks \
    -Djavax.net.ssl.keyStorePassword=password \
    -Djavax.net.ssl.trustStore=clienttruststore.jks \
    -Djavax.net.ssl.trustStorePassword=password -Djdk.tls.client.protocols=TLSv1.2 -Dhttps.protocols=TLSv1.2 -Djavax.net.debug=ssl