import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable {
	private Socket socket;
	private BufferedReader clientInput;
	private PrintWriter serverOutput;
	private ArrayList<ClientHandler> clients;
	private Server_console server_console;
	private con_users conUsers;

	private String username;
	private Color color;
	private float[] colorHSB = {0f,0f,0f};

	public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients, Server_console server_console, con_users conUsers) throws IOException {
		this.socket = clientSocket;
		this.clients = clients;
		this.conUsers = conUsers;
		this.server_console = server_console;
		clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		serverOutput = new PrintWriter(socket.getOutputStream(), true);
	}

	public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients, Server_console server_console, String username, Color color) throws IOException {
		this.socket = clientSocket;
		this.clients = clients;
		this.color = color;
		this.server_console = server_console;
		this.username = username;
		clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		serverOutput = new PrintWriter(socket.getOutputStream(), true);
	}

	@Override
	public void run() {
		try {
			serverOutput.println("[Server]/> Server Connection Established!");
			serverOutput.println("[Server]/> Please Enter a Username: ");
			username = clientInput.readLine();
			serverOutput.println("[Server]/> Please Enter a Color: ");

			String[] nums = clientInput.readLine().split("[=,]");
			float[] colorHSB = { Float.parseFloat(nums[0].substring(1)) , Float.parseFloat(nums[1]) , Float.parseFloat(nums[2].substring(0,nums[2].indexOf("]")))};
			this.colorHSB = colorHSB;
			color = Color.getHSBColor(Float.parseFloat(nums[0].substring(1)) , Float.parseFloat(nums[1]) , Float.parseFloat(nums[2].substring(0,nums[2].indexOf("]"))));

			conUsers.sayAsSERVER(username+" has joined the chat room");

			while (true) {
				String commandRequest = clientInput.readLine();


				if (commandRequest.contains("/compare")) {
					String[] arguments = commandRequest.split(" ");

					if (arguments.length != 3) {
						serverOutput.println(Arrays.toString(colorHSB)+"~~~~"+username+"[Server]/> Error: Invalid Argument");
					} else {
						serverOutput.println(Arrays.toString(colorHSB)+"~~~~"+username+"[Server]/> "+Server.comparePeople(arguments[1], arguments[2]));
					}
				}
				else{
					chatToAll(commandRequest);
				}
			}
		} catch (IOException e) {
			System.err.println(username+" Timed out");
			server_console.setConsole_chat(username+" Timed out \n");
			//e.printStackTrace();
		} finally {
			try {
				//close connections
				socket.close();
				serverOutput.close();
				clientInput.close();
				System.out.print("Connection closed with"+username);
				server_console.setConsole_chat("Connection closed with "+username+" \n\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void chatToAll(String msg) {
		for (ClientHandler aClient : clients) {
			aClient.serverOutput.println(Arrays.toString(colorHSB)+"~~~~"+"["+username+"]/> "+msg);
		}
		server_console.setConsole_chat("["+username+"]/> "+msg+" \n");
	}

	public String getUsername() {
		return username;
	}
}

