import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Secure_Chat {
	private JTextField message_box;
	private JButton send_btn;
	private JPanel panel;
	private JScrollPane mainPane;
	private JTextPane mainTextPane;

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

		//Waiting for connection message from the server and adding it to the chat area
		String serverResponse = clientInput.readLine();
		appendToPane(mainTextPane, serverResponse + "\n", Color.getHSBColor(Secure_Form.COLOR[0], Secure_Form.COLOR[1], Secure_Form.COLOR[2]));
		//Chat_Area.append(serverResponse + "\n");

		// reading the username line from the server auto send the name to the server
		serverResponse = clientInput.readLine();
		clientOutput.println(Secure_Form.USERNAME);

		//reading the color line from server and auto send the color selection
		serverResponse = clientInput.readLine();
		clientOutput.println(Arrays.toString(Secure_Form.COLOR));

		//we need start checking for incoming messages from the server using a separate thread to not freeze the GUI
		new Thread(serverConn).start();

		//action listener for the send message button which checks to see if we still need to send the server our username
		send_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//takes in the message from the user and send it to the server
				String message = message_box.getText();
				clientOutput.println(Arrays.toString(Secure_Form.COLOR) + "~~~~" + message);
				message_box.setText("");
			}
		});
		message_box.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					String message = message_box.getText();
					clientOutput.println(message);
					message_box.setText("");
				}
			}
		});
	}

	private void appendToPane(JTextPane tp, String msg, Color c) {
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

		aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
		aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

		int len = tp.getDocument().getLength();
		tp.setCaretPosition(len);
		tp.setCharacterAttributes(aset, false);
		tp.replaceSelection(msg);
		tp.setText(tp.getText() + msg);
	}
	//gets and sets of course :)

	public void setMessage_box(JTextField message_box) {
		this.message_box = message_box;
	}

	public void setSend_btn(JButton send_btn) {
		this.send_btn = send_btn;
	}

	public void addText(String msg, Color color) {
		appendToPane(mainTextPane, msg, color);
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


	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		panel = new JPanel();
		panel.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
		panel.setBackground(new Color(-11382188));
		mainPane = new JScrollPane();
		mainPane.setBackground(new Color(-11382188));
		panel.add(mainPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
		mainTextPane = new JTextPane();
		mainTextPane.setBackground(new Color(-11382188));
		mainTextPane.setEditable(false);
		mainPane.setViewportView(mainTextPane);
		message_box = new JTextField();
		message_box.setBackground(new Color(-11382188));
		message_box.setEditable(true);
		message_box.setForeground(new Color(-5066062));
		message_box.setText("");
		panel.add(message_box, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		send_btn = new JButton();
		send_btn.setBackground(new Color(-11382188));
		send_btn.setEnabled(true);
		send_btn.setForeground(new Color(-5066062));
		send_btn.setText("Send");
		panel.add(send_btn, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return panel;
	}

}
