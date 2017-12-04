import java.io.*;
import java.net.*;
import java.util.*;

class UDPClient {
	static String address;
	static String destiny;
	static String router;
	static String message;
	static String port;
	public static void main(String args[]) throws Exception {
		input(args);
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		DatagramSocket clientSocket = new DatagramSocket();

		//String servidor = "localhost";
		//int porta = 9876;
		String servidor = router;
		int porta = Integer.parseInt(port);

		InetAddress IPAddress = InetAddress.getByName(servidor);

		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];

		System.out.println("Digite o texto a ser enviado ao servidor: ");
		//String sentence = inFromUser.readLine();
		//DatagramPacket receivePacket = seedPackge(message.getBytes(), receiveData);
		
		String sentence = message;
		sendData = sentence.getBytes();
		
		DatagramPacket sendPacket = new DatagramPacket(sendData,
						sendData.length, IPAddress, porta);

		System.out.println("Enviando pacote UDP para " + servidor + ":" + porta);
		clientSocket.send(sendPacket);

		DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length);
		
		clientSocket.receive(receivePacket);
		System.out.println("Pacote UDP recebido...");

		String modifiedSentence = new String(receivePacket.getData());

		System.out.println("Texto recebido do servidor:" + modifiedSentence);
		clientSocket.close();
		System.out.println("Socket cliente fechado!");
	}
	/*
	static DatagramPacket seedPackge(byte[] sendData, byte[] receiveData)
	{
		DatagramPacket sendPacket = new DatagramPacket(sendData,
						sendData.length, IPAddress, port);

		System.out.println("Enviando pacote UDP para " + router + ":" + port);
		clientSocket.send(sendPacket);

		DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length);
	}
	*/
    static void input(String[] array)
    {
		//if(array.length < 5) version full
		if(array.length == 0)
		{
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