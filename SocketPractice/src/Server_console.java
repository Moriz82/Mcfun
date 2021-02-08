import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.ServerCloneException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server_console {
	private JPanel panel;
	private JTextArea Console_chat;
	private JButton start_btn;
	private JTextField command_field;
	private JButton command_brn;

	private static JFrame frame;
	private static final int PORT = 6969;
	private boolean start_brn_clicked = false;

	private con_users conUsers = new con_users(this);


	public static void main(String[] args) throws IOException {
		frame = new JFrame("Server Console");
		frame.setContentPane(new Server_console().panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(700,300,500,400);
		frame.setVisible(true);
	}
	public Server_console() throws IOException{

		start_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					if (!start_brn_clicked){start_brn_clicked = true;}
					new Thread(conUsers).start();
			}
		});
		command_brn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = command_field.getText();

				setConsole_chat(command+"\n");

				if (command.equals("listUsers")||command.equals("list")){
					ArrayList<ClientHandler> users = con_users.getClientThreads();
					setConsole_chat("Registered Users: ");
					for (ClientHandler ch : users) {
						setConsole_chat(ch.getUsername()+", ");
					}
					setConsole_chat("\n");
				}
				else if(command.contains("say")){
					conUsers.getSERVER().chatToAll(command.substring(command.indexOf("say")+4));
				}
				else {
					setConsole_chat("Error: invalid command +\n");
				}
			}
		});
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JTextArea getConsole_chat() {
		return Console_chat;
	}

	public void setConsole_chat(String console_chat) {
		Console_chat.append(console_chat);
	}

	public JButton getStart_btn() {
		return start_btn;
	}

	public void setStart_btn(JButton start_btn) {
		this.start_btn = start_btn;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		Server_console.frame = frame;
	}

	public static int getPORT() {
		return PORT;
	}

}
class con_users implements Runnable{

	private static ArrayList<ClientHandler> clientThreads = new ArrayList<>();
	private static ExecutorService pool = Executors.newFixedThreadPool(Integer.MAX_VALUE);
	private Server_console s;
	private ServerSocket incomingPackets;
	private ClientHandler SERVER;

	public con_users(Server_console ss) throws IOException{
		s = ss;
		incomingPackets = new ServerSocket(s.getPORT());
		SERVER = new ClientHandler(new Socket("127.0.0.1",6969),con_users.getClientThreads(), s, "SERVER");
	}

	@Override
	public void run() {

		try {
			//look for incoming people and send them to the ClientHandler
			while (true) {
				System.out.println("Waiting for client connections... ");
				s.setConsole_chat("Waiting for client connections... \n");

				Socket client = incomingPackets.accept();
				System.out.println("Client has connected!");
				s.setConsole_chat("Client has connected! \n");

				ClientHandler clientThread = new ClientHandler(client, clientThreads, s);
				clientThreads.add(clientThread);

				pool.execute(clientThread);
			}
		}
		catch (IOException ev){
			ev.printStackTrace();
		}
	}

	public void setIncomingPackets(ServerSocket incomingPackets) {
		this.incomingPackets = incomingPackets;
	}

	public ServerSocket getIncomingPackets() {
		return incomingPackets;
	}

	public static ArrayList<ClientHandler> getClientThreads() {
		return clientThreads;
	}

	public static ExecutorService getPool() {
		return pool;
	}

	public Server_console getS() {
		return s;
	}

	public ClientHandler getSERVER() {
		return SERVER;
	}

	public void setSERVER(ClientHandler SERVER) {
		this.SERVER = SERVER;
	}

	public static void setClientThreads(ArrayList<ClientHandler> clientThreads) {
		con_users.clientThreads = clientThreads;
	}

	public static void setPool(ExecutorService pool) {
		con_users.pool = pool;
	}

	public void setS(Server_console s) {
		this.s = s;
	}
}
