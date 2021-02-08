import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	public static void main(String[] args) throws IOException {
	//public static void start(SecureForm secureForm ,String IPADDRESS, int PORT) throws IOException {
		String serverIP = "127.0.0.1";
		int serverPort = 6969;

		Socket socket = new Socket(serverIP, serverPort);

		ServerConnection serverConn = new ServerConnection(socket);

		BufferedReader clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		Scanner scan_input = new Scanner(System.in);
		PrintWriter clientOutput = new PrintWriter(socket.getOutputStream(), true);

		new Thread(serverConn).start();

		//connection message wait
		String serverResponse = clientInput.readLine();
		System.out.println(serverResponse);
		//secureForm.text_j.append(serverResponse);

		//username retreval msg
		serverResponse = clientInput.readLine();
		System.out.println(serverResponse);
		//secureForm.text_j.append(serverResponse);

		while (true) {
			System.out.print("/> ");
			String command = scan_input.nextLine();

			if (command.equals("quit")){break;}

			clientOutput.println(command);
		}

		socket.close();
		System.exit(0);
	}
}
