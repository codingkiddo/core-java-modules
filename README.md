# java9-learning
java9-learning



mvn exec:java -Dexec.mainClass=com.corejavamodules.SimpleClient -Djavax.net.ssl.keyStore=serverkeystore.jks \
    -Djavax.net.ssl.keyStorePassword=password \
    -Djavax.net.ssl.trustStore=clienttruststore.jks \
    -Djavax.net.ssl.trustStorePassword=password -Djdk.tls.client.protocols=TLSv1.2 -Dhttps.protocols=TLSv1.2 -Djavax.net.debug=ssl

mvn exec:java -Dexec.mainClass=com.corejavamodules.SimpleServer -Djavax.net.ssl.keyStore=serverkeystore.jks \
    -Djavax.net.ssl.keyStorePassword=password \
    -Djavax.net.ssl.trustStore=clienttruststore.jks \
    -Djavax.net.ssl.trustStorePassword=password -Djdk.tls.client.protocols=TLSv1.2 -Dhttps.protocols=TLSv1.2 -Djavax.net.debug=ssl