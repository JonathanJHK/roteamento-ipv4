import java.io.*;
import java.net.*;
import java.util.*;

class SendPackage {
	static String address;
	static String destiny;
	static String router = "localhost";
	static String message;
	static String port;
    static DatagramSocket clientSocket;
    static BufferedReader inFromUser;
    static byte[] sendData;
    static byte[] receiveData;
    static InetAddress IPAddress;
    public static void preparing () throws Exception {
        inFromUser = new BufferedReader(new InputStreamReader(System.in));
		clientSocket = new DatagramSocket();
		IPAddress = InetAddress.getByName(router);
		sendData = new byte[1024];
		receiveData = new byte[1024];
		System.out.println("Digite o texto a ser enviado ao servidor: ");
    }
	
	static void seed (byte[] sendData) throws IOException {
		DatagramPacket sendPacket = new DatagramPacket(sendData,
						sendData.length, InetAddress.getByName(router), Integer.parseInt(port));

		System.out.println("Enviando pacote UDP para " + router + ":" + port);
		clientSocket.send(sendPacket);
	}	
}