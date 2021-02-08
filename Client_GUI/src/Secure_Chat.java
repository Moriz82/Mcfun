import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Secure_Chat {
	private JTextField message_box;
	private JButton send_btn;
	private JTextArea Chat_Area;
	private JPanel panel;

	// here we throw the IOException just in case the server kahoot's itself
	public Secure_Chat() throws IOException {

		/**then we start the server connection processes
			Now it might look like a lot but really we just take the IP from the previous input field along with
		 	the port. Then Socket does its magic and makes love to the server.
		**/

		Socket socket = new Socket(Secure_Form.IP_ADDRESS, Secure_Form.PORT);

		// the serverConnection is used for checking the server for any incoming messages encase were caught lacking
		// and you dont wanna be caught lacking or the info clumps up and kills your eyes ;)
		ServerConnection serverConn = new ServerConnection(socket, this);


		//The bufferedReader Is just like a Scanner but it works better for the socket Library
		// The print Writer is used for sending messages across the internet using socket
		BufferedReader clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter clientOutput = new PrintWriter(socket.getOutputStream(), true);

		//we need start checking for incoming messages from the server using a separate thread to not freeze the GUI
		new Thread(serverConn).start();

		//Waiting for connection message from the server and adding it to the chat area
		String serverResponse = clientInput.readLine();
		Chat_Area.append(serverResponse+"\n");

		// reading the username line from the server auto send the name to the server
		serverResponse = clientInput.readLine();
		clientOutput.println(Secure_Form.USERNAME);
		//Chat_Area.append(serverResponse+"\n");

		//action listener for the send message button which checks to see if we still need to send the server our username
		send_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//takes in the message from the user and send it to the server
				String message = message_box.getText();
				clientOutput.println(message);
			}
		});
	}

	//gets and sets of course :)

	public void setMessage_box(JTextField message_box) {
		this.message_box = message_box;
	}

	public void setSend_btn(JButton send_btn) {
		this.send_btn = send_btn;
	}

	public void setChat_Area(String chat_Area) {
		Chat_Area.append(chat_Area);
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getMessage_box() {
		return message_box;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JButton getSend_btn() {
		return send_btn;
	}

	public JTextArea getChat_Area() {
		return Chat_Area;
	}
}
