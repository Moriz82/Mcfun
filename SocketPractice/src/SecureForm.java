import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.net.*;
import java.util.*;

public class SecureForm {
	private JButton checkButton;
	private JPanel mainPanel;
	private JTextField serverIp;
	private JLabel ServerIpText;
	private JTextField PortField;
	JTextArea text_j;
	private static JScrollPane Chat_Room;

	private String IPADDRESS;
	private int PORT;
	private boolean inSession;

	public static void main(String[] args) {
		JFrame frame = new JFrame("SecureForm");
		frame.setContentPane(new SecureForm().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public SecureForm() {

		checkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)  {
				IPADDRESS = serverIp.getText();
				PORT = Integer.parseInt(PortField.getText());
				try {
					Client.start(SecureForm.this,IPADDRESS, PORT);
				}
				catch (IOException ev){
					ev.printStackTrace();
				}
			}
		});
	}

	private void createUIComponents() {
		// TODO: place custom component creation code here
	}


	//gets and sets

	public JButton getCheckButton() {
		return checkButton;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public JTextField getServerIp() {
		return serverIp;
	}

	public JLabel getServerIpText() {
		return ServerIpText;
	}

	public JTextField getPortField() {
		return PortField;
	}

	public JScrollPane getChat_Room() {
		return Chat_Room;
	}

	public String getIPADDRESS() {
		return IPADDRESS;
	}

	public int getPORT() {
		return PORT;
	}

	public void setCheckButton(JButton checkButton) {
		this.checkButton = checkButton;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public void setServerIp(JTextField serverIp) {
		this.serverIp = serverIp;
	}

	public void setServerIpText(JLabel serverIpText) {
		ServerIpText = serverIpText;
	}

	public void setPortField(JTextField portField) {
		PortField = portField;
	}

	public void setChat_Room(JScrollPane chat_Room) {
		Chat_Room = chat_Room;
	}

	public void setIPADDRESS(String IPADDRESS) {
		this.IPADDRESS = IPADDRESS;
	}

	public void setPORT(int PORT) {
		this.PORT = PORT;
	}
}
