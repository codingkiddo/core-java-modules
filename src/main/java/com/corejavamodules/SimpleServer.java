package com.corejavamodules;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class SimpleServer {

	static void startServer(int port) throws IOException {
        ServerSocketFactory factory = SSLServerSocketFactory.getDefault();

        try (ServerSocket listener = factory.createServerSocket(port)) {
            System.setProperty("javax.net.debug", "ssl:handshake");
            ((SSLServerSocket) listener).setNeedClientAuth(true);
            ((SSLServerSocket) listener).setEnabledCipherSuites(new String[] { "TLS_RSA_WITH_AES_128_GCM_SHA256" });
            ((SSLServerSocket) listener).setEnabledProtocols(new String[] { "TLSv1.2" });
            while (true) {
                try (Socket socket = listener.accept()) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Hello World!");
                    socket.close();
                } catch (Exception e) {
				}
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.setProperty("javax.net.debug", "ssl:handshake");
        startServer(8443);
    }

}
