import java.io.*;
import java.net.*;
import java.util.*;

//we implement Runnable so we can run the class in a seperate thread
public class ServerConnection implements Runnable{
	private Socket socket;
	private BufferedReader serverInput;
	private PrintWriter clientOutput;
	private Secure_Chat secure_Chat;

	//the constructor of course
	public ServerConnection(Socket s,Secure_Chat secure_Chat) throws IOException{
		socket = s;
		this.secure_Chat = secure_Chat;
		serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		clientOutput = new PrintWriter(socket.getOutputStream(), true);
	}

	//here we override the default run method from the Runnable interface
	@Override
	public void	run(){
		//we use try/catch because we are using socket which can get sketchy
		try {
			//checking for messages 24/7 and if there is one we add it to the chat
			while (true){
				String serverResponse = serverInput.readLine();
				if (serverResponse == null) {break;}

				System.out.println(serverResponse);
				secure_Chat.setChat_Area(serverResponse+"\n");
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
		//we use this to close the socket and message objects so it doesnt become a error in the future
		finally {
			try {
				serverInput.close();
				socket.close();
				clientOutput.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
