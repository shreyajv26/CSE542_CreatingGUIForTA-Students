package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import controller.ActionListen;
import controller.GuiService;
import controller.GuiServiceImpl;
import core.Constants;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.JButton;

public class Sessions extends JFrame {

	private static final long serialVersionUID = 1L;
	
	GuiService guiService = new GuiServiceImpl();
	
	private static Sessions session = new Sessions();
	
	private JPanel contentPane;

	public Sessions() {}
	
	/**
	 * Create the frame.
	 */
	public Sessions(String status, int data) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel pwdLabel = new JLabel(Constants.password);
		pwdLabel.setBounds(62, 89, 129, 13);
		contentPane.add(pwdLabel);

		JPasswordField pwdField = new JPasswordField();
		pwdField.setBounds(245, 80, 139, 31);
		contentPane.add(pwdField);
		pwdField.setColumns(10);

		JButton submitButton = new JButton(Constants.submit);
		//initialize particular action listener constructor for session class submit button
		submitButton.addActionListener(new ActionListen(session, status, data, pwdField));
		submitButton.setBackground(Color.LIGHT_GRAY);
		submitButton.setBounds(175, 158, 85, 21);
		contentPane.add(submitButton);
	}
}



