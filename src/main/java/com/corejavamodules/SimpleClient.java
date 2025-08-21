package com.corejavamodules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.net.SocketFactory;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SimpleClient {

	static void startClient(String host, int port) throws IOException {
        SocketFactory factory = SSLSocketFactory.getDefault();

        try (Socket connection = factory.createSocket(host, port)) {
            ((SSLSocket) connection).setEnabledCipherSuites(new String[] { "TLS_RSA_WITH_AES_128_GCM_SHA256" });
            ((SSLSocket) connection).setEnabledProtocols(new String[] { "TLSv1.2" });
            SSLParameters sslParams = new SSLParameters();
            sslParams.setEndpointIdentificationAlgorithm("HTTPS");
            ((SSLSocket) connection).setSSLParameters(sslParams);
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.println(input.readLine());;
            input.close();
            connection.close();
        } catch (Exception e) {
			// TODO: handle exception
		}
    }

    public static void main(String[] args) throws IOException {
        System.setProperty("javax.net.debug", "ssl:handshake");
//        System.out.println(startClient("localhost", 8443));
        startClient("localhost", 8443);
    }
}
