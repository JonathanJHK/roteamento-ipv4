/*
*	Classe que representa o cliente ou emissor
*   essa classe herda de SendPackage
*/
import java.io.*;
import java.net.*;
import java.util.*;
class UDPClient extends SendPackage {
	/* Método principal 
	*  Faz a comunicação com o roteador, enviando um pacote	
	*/
	public static void main(String args[]) throws Exception {
		input(args);
		preparing();
		
		forwarding(message.getBytes());
		forwarding(address.getBytes());
		forwarding(destiny.getBytes());
		
		DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length);
		
		socket.receive(receivePacket);
		System.out.println("Pacote UDP recebido...");

		String modifiedSentence = new String(receivePacket.getData());

		System.out.println("Texto recebido do servidor:" + modifiedSentence);
		socket.close();
		System.out.println("Socket cliente fechado!");
	}
	
	/* 
	*	Método input, responsavel por trata do recebimento dos dados pelo terminal	
	*/
    static void input(String[] array) {
		if(array.length == 0) {
				System.out
						.println("Obrigatorio, argumento\n exemplo: (ex) java UDPClient.java  127.0.0.1  12345  10.0.0.5   1.2.3.4  Hello");
				System.exit(0);
		}		
		router = array[0];
		port = array[1];
		address = array[2];
		destiny = array[3];
		message = array[4];
    }	
}