import java.io.*;
import java.net.*;
import java.util.*;

public class ServerConnection implements Runnable{
	private Socket socket;
	private BufferedReader serverInput;
	private PrintWriter clientOutput;
	private SecureForm secureForm;

	public ServerConnection(Socket s, SecureForm secureForm) throws IOException{
		socket = s;
		this.secureForm = secureForm;
		serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		clientOutput = new PrintWriter(socket.getOutputStream(), true);
	}

	@Override
	public void	run(){
		try {
			while (true){
				String serverResponse = serverInput.readLine();
				if (serverResponse == null) break;

				System.out.println(serverResponse);
				secureForm.text_j.append(serverResponse);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
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
