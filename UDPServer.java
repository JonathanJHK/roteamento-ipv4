import java.io.*;
import java.net.*;
 
class UDPServer extends SendPackage {
	static int port;
	static int numConn;
	static Table table;
	public static void main(String args[]) throws Exception {
		input(args);
		//int porta = 9876;
		int porta = port;
		numConn = 1;

		String sentence;	
		
		socket = new DatagramSocket(porta);
 		
		while (true) {
 
			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
			System.out.println("Esperando por datagrama UDP na porta " + porta);


			socket.receive(receivePacket);
			System.out.print("Datagrama UDP messagem [" + numConn + "] recebido...");
 
			sentence = new String(receivePacket.getData());
			System.out.println(sentence);

			socket.receive(receivePacket);
			System.out.print("Datagrama UDP address [" + numConn + "] recebido...");
 
			sentence = new String(receivePacket.getData());
			System.out.println(sentence);


			socket.receive(receivePacket);
			System.out.print("Datagrama UDP destiny [" + numConn + "] recebido...");
 
			sentence = new String(receivePacket.getData());
			System.out.println(sentence);

			

			
			IPAddress = receivePacket.getAddress();
 
			port = receivePacket.getPort();
 
			String capitalizedSentence = sentence.toUpperCase();
 
			sendData = capitalizedSentence.getBytes();
 
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, IPAddress, port);
			
			System.out.print("Enviando " + capitalizedSentence + "...");
 
			socket.send(sendPacket);
			System.out.println("OK\n");
		}
		//socket.close();
	}

	/* Busca na tabela e destino */
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
		
		table = new Table(array.length - 1);

		for(String value : array)
			table.add(value.split("/"));
		
		
		//System.out.exit();
		//table = new Table(array[1]);
	}
}