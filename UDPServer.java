import java.io.*;
import java.net.*;
 
class UDPServer extends SendPackage {
	static int port;
	static Table table;
	static DatagramPacket receivePacket;
	public static void main(String args[]) throws Exception {
		input(args);
		//int porta = 9876;

		socket = new DatagramSocket(port); 		
		started();
	}

	static void started () throws IOException {
		while (true) { 
			receivePacket = new DatagramPacket(receiveData, receiveData.length);
			System.out.println("Esperando por datagrama UDP na porta " + port);
			receiving();
			
			Route route = table.route(change(destiny));
			
			if(route.network.equals("default"))
				System.out.println("destination " + destiny + " not found in routing table, dropping packet ");
			
			resend();
		}
	}

	static String change (String value) {
		String other = "";
		
		for (int i=0, size = value.length(); i != size; i++) {
			if((int) value.charAt(i) > 45 && (int) value.charAt(i) < 58)
				other += value.charAt(i);	
		}
		return other;
	}

	static void resend () throws IOException {
		IPAddress = receivePacket.getAddress();
 
		String capitalizedSentence = message.toUpperCase();

		sendData = capitalizedSentence.getBytes();

		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, IPAddress, receivePacket.getPort());
		
		System.out.print("Enviando " + capitalizedSentence + "...");

		socket.send(sendPacket);
		System.out.println("OK\n");
	}

	static void receiving () throws IOException {
		socket.receive(receivePacket);
		System.out.print("Datagrama UDP messagem  recebido...");

		message = new String(receivePacket.getData());
		System.out.println(message);

		socket.receive(receivePacket);
		System.out.print("Datagrama UDP address  recebido...");

		address = new String(receivePacket.getData());
		System.out.println(address);

		socket.receive(receivePacket);
		System.out.print("Datagrama UDP destiny  recebido...");

		destiny = new String(receivePacket.getData());
		System.out.println(destiny);
	}

	/* Busca na tabela e destino */
	static void table() {
		return;
	}

	static void input (String[] array) {
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