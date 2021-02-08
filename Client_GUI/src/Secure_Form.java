import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Secure_Form {
	private JPanel leftPanel;
	private JButton join_btn;
	private JTextField portField;
	private JTextField userField;
	private JTextField ipField;
	private JLabel ipLabel;
	private JLabel portLabel;
	private JLabel userLabel;

	private static JFrame frame;

	static String IP_ADDRESS;
	static int PORT;
	static String USERNAME;

	public static void main(String[] args) {

		//creating the main frame/window to choose server settings

		frame = new JFrame("Secure Form");
		frame.setContentPane(new Secure_Form().leftPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(800,400,300,250);
		//frame.pack();
		frame.setVisible(true);
	}

	public Secure_Form(){
		//event listener for the join button that grabs all filled in fields
		join_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				IP_ADDRESS = ipField.getText();
				PORT = Integer.parseInt(portField.getText());
				USERNAME = userField.getText();

				// after that we create the new chat window
				// we also use try/catch statement for the Socket declaration in Secure_Chat()'s constructor
				JFrame frame2 = new JFrame("Secure Chat");
				try {
					frame2.setContentPane(new Secure_Chat().getPanel());
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setBounds(700,300,500,400);
				//frame2.pack();
				frame2.setVisible(true);

				//and for more style points we close the old window :)
				Secure_Form.frame.setVisible(false);
			}
		});
	}
}
