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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class StudentInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	GuiService guiService = new GuiServiceImpl();
	
	public JTextField nameTextField;
	public JTextField emailTextField;
	public JPasswordField pwdTextField;

	private static StudentInfo stInfo = new StudentInfo();
	
	/**
	 * Create the frame.
	 */
	public StudentInfo() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel name = new JLabel(Constants.name);
		name.setBounds(64, 38, 175, 13);
		contentPane.add(name);
		
		JLabel email = new JLabel(Constants.email);
		email.setBounds(64, 90, 175, 13);
		contentPane.add(email);
		
		JLabel sessionPwd = new JLabel(Constants.password);
		sessionPwd.setBounds(64, 144, 175, 13);
		contentPane.add(sessionPwd);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(256, 28, 114, 31);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(256, 80, 114, 31);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);
		
		pwdTextField = new JPasswordField();
		pwdTextField.setBounds(256, 134, 114, 31);
		contentPane.add(pwdTextField);
		pwdTextField.setColumns(10);

		JButton submitButton = new JButton(Constants.submit);
		//initialize particular action listener constructor for studentInfo class submit button
		submitButton.addActionListener(new ActionListen(stInfo, nameTextField,
				emailTextField, pwdTextField));
		submitButton.setBackground(Color.LIGHT_GRAY);
		submitButton.setBounds(177, 199, 85, 21);
		contentPane.add(submitButton);
		
	}

}
