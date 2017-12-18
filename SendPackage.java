/*
*	Classe SendPackage padroniza o mecanismo de envio de pacotes.
*	essa classe herda de pacote
*/
import java.io.*;
import java.net.*;
import java.util.*;

class SendPackage extends Package {
    static DatagramSocket socket;
    static BufferedReader inFromUser;
    static byte[] sendData = new byte[1024];
    static byte[] receiveData = new byte[1024];
	static InetAddress IPAddress;
	/*
	*	Método de preparação de pacotes
	*/
    public static void preparing () throws Exception {
        inFromUser = new BufferedReader(new InputStreamReader(System.in));
		socket = new DatagramSocket();
		IPAddress = InetAddress.getByName(router);
    }
	/*
	*	Método de envio de pacotes
	*/
	static void forwarding (byte[] sendData) throws IOException {
		DatagramPacket sendPacket = new DatagramPacket(sendData,
						sendData.length, InetAddress.getByName(router), Integer.parseInt(port));

		System.out.println("Enviando pacote UDP para " + router + ":" + port);
		socket.send(sendPacket);
	}
}