import java.io.*;
import java.net.*;
 
class UDPServer {
	static int port;
	static int numConn;
	public static void main(String args[]) throws Exception {
		input(args);
		//int porta = 9876;
		int porta = port;
		numConn = 1;

		String sentence;	
		
		DatagramSocket serverSocket = new DatagramSocket(porta);
 		
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
 
		while (true) {
 
			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
			System.out.println("Esperando por datagrama UDP na porta " + porta);


			serverSocket.receive(receivePacket);
			System.out.print("Datagrama UDP messagem [" + numConn + "] recebido...");
 
			sentence = new String(receivePacket.getData());
			System.out.println(sentence);

			serverSocket.receive(receivePacket);
			System.out.print("Datagrama UDP address [" + numConn + "] recebido...");
 
			sentence = new String(receivePacket.getData());
			System.out.println(sentence);


			serverSocket.receive(receivePacket);
			System.out.print("Datagrama UDP destiny [" + numConn + "] recebido...");
 
			sentence = new String(receivePacket.getData());
			System.out.println(sentence);



			
			InetAddress IPAddress = receivePacket.getAddress();
 
			int port = receivePacket.getPort();
 
			String capitalizedSentence = sentence.toUpperCase();
 
			sendData = capitalizedSentence.getBytes();
 
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, IPAddress, port);
			
			System.out.print("Enviando " + capitalizedSentence + "...");
 
			serverSocket.send(sendPacket);
			System.out.println("OK\n");
		}
		//serverSocket.close();
	}

	/* Busca na tabela e destinação */
	static void table() {
		return;
	}

	static void input(String[] array) {
		if(array.length == 0) {
			System.out
					.println("Obrigatorio, argumento\n exemplo: (ex) java UDPServer.java 12345");
			System.exit(0);
		}		

		port = Integer.parseInt(array[0]);

		new Table(array[1].split("/"));
		
		//System.out.exit();
		//table = new Table(array[1]);


}