import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable {
	private Socket socket;
	private BufferedReader clientInput;
	private PrintWriter serverOutput;
	private ArrayList<ClientHandler> clients;
	private String username;

	public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients) throws IOException {
		this.socket = clientSocket;
		this.clients = clients;
		clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		serverOutput = new PrintWriter(socket.getOutputStream(), true);
	}

	@Override
	public void run() {
		try {
			serverOutput.println("[Server]/> Server Connection Established!");
			serverOutput.println("[Server]/> Please Enter a Username: ");
			username = clientInput.readLine();
			while (true) {
				String commandRequest = clientInput.readLine();


				if (commandRequest.contains("/compare")) {
					String[] arguments = commandRequest.split(" ");

					if (arguments.length != 3) {
						serverOutput.println("[Server]/> Error: Invalid Argument");
					} else {
						serverOutput.println("[Server]/> "+Server.comparePeople(arguments[1], arguments[2]));
					}
				}
				else{
					chatToAll(commandRequest);
				}
			}
		} catch (IOException e) {
			System.err.println("IO exception in client handler");
			e.printStackTrace();
		} finally {
			try {
				//close connections
				socket.close();
				serverOutput.close();
				clientInput.close();
				System.out.print("Connection closed with client");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void chatToAll(String msg) {
		for (ClientHandler aClient : clients) {
			aClient.serverOutput.println("["+username+"]/> "+msg);
		}
	}
}
