import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {


	private static final int PORT = 6969;

	private static ArrayList<ClientHandler> clientThreads = new ArrayList<>();
	private static ExecutorService pool = Executors.newFixedThreadPool(Integer.MAX_VALUE);

	public static void main(String[] args) throws IOException {
		//create server connection socket
		ServerSocket incomingPackets = new ServerSocket(PORT);

		//look for incoming people and send them to the ClientHandler
		while (true){
			System.out.println("Waiting for client connections... ");
			Socket client = incomingPackets.accept();
			System.out.println("Client has connected!");

			ClientHandler clientThread = new ClientHandler(client, clientThreads);
			clientThreads.add(clientThread);

			pool.execute(clientThread);
		}

	}
	public static String comparePeople(String name1, String name2) throws IOException{
		Scanner scan = new Scanner(new File("names.txt"));
		ArrayList<String> peoplez = new ArrayList<String>();
		int amnt = scan.nextInt();
		scan.nextLine();

		for (int i = 0; i < amnt; i++) {
			peoplez.add(scan.nextLine());
		}
		if (peoplez.contains(name1)){
			if (peoplez.contains(name2)){
				return "69% match :)";
			}
			return "Error 02: "+name2+" is not found in the database";
		}
		return "Error 01: "+name1+" is not found in the database";
	}
}