package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import core.Constants;
import core.GuiUtil;
import view.GuiApplication;
import view.StudentInfo;
import view.Sessions;

public class ActionListen implements ActionListener {

	GuiService guiService = new GuiServiceImpl();

	private JTextField nameTextField;
	private JTextField emailTextField;
	private JPasswordField pwdField;
	private Object object;

	private String status;
	private int data;

	public ActionListen() {}

	public ActionListen(Object name, JTextField nameTextField, JTextField emailTextField, 
			JPasswordField pwdTextField) {
		this.object = name;
		this.nameTextField = nameTextField;
		this.emailTextField = emailTextField;
		this.pwdField = pwdTextField;
	}

	public ActionListen(Object name, String status, int data, JPasswordField pwdTextField) {
		this.object = name;
		this.status = status;
		this.data = data;
		this.pwdField = pwdTextField;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String name = ae.getActionCommand();

		if(name.equals(Constants.pause) || name.equals(Constants.unpause) ||
				name.equals(Constants.remove)) {
			if (GuiApplication.table.getModel().getRowCount()==0) {
				JOptionPane.showMessageDialog(null, Constants.queueEmptyMsg);
			}
			else if (GuiApplication.table.getSelectionModel().isSelectionEmpty())
			{
				JOptionPane.showMessageDialog(null, Constants.noRowMsg);
			}
			//Pause button action
			else if(name.equals(Constants.pause)) {
				int column = 2;
				int row = GuiApplication.table.getSelectedRow();
				String CurStatus = GuiApplication.table.getModel().getValueAt(row, column).toString();
				if(CurStatus==Constants.paused) {
					JOptionPane.showMessageDialog(GuiApplication.frame, Constants.pauseMsg);
				}
				else {
					Sessions sew =  new Sessions(Constants.pause, row);
					sew.setVisible(true);
				}
			}
			//Unpause button action
			else if(name.equals(Constants.unpause)) {
				int column = 2;
				int row = GuiApplication.table.getSelectedRow();
				String CurStatus = GuiApplication.table.getModel().getValueAt(row, column).toString();
				if(CurStatus==Constants.unpaused) {
					JOptionPane.showMessageDialog(GuiApplication.frame, Constants.unPauseMsg);
				}
				else {
					Sessions sew =  new Sessions(Constants.unpause, row);
					sew.setVisible(true);
				}
			}
			else if(name.equals(Constants.remove))
			{
				Sessions sew =  new Sessions(name, 1);
				sew.setVisible(true);
			}
		}

		//Add student button action
		if(name.equals(Constants.addStuButton)){
			StudentInfo ads = new StudentInfo();
			ads.setVisible(true);
		}

		//Add student submit button action
		if(this.object != null && (this.object instanceof StudentInfo)) {
			if(nameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() ||
					pwdField.getPassword().length == 0) {
				JOptionPane.showMessageDialog(null, Constants.fieldEmptyMsg);
			} else {
				//add entry to the queue
				guiService.addEntry(nameTextField.getText(),emailTextField.getText());
				//display queue details
				GuiUtil.displayQueueEntries((DefaultTableModel)GuiApplication.table.getModel());
				javax.swing.FocusManager.getCurrentManager().getActiveWindow().dispose();
			}
		}

		//common session dialog submit button action
		if(this.object != null && (this.object instanceof Sessions)) {
			if(pwdField.getPassword().length == 0) {
				JOptionPane.showMessageDialog(null, Constants.pwdEmptyMsg);
			}
			else if(this.status == Constants.pause)
			{
				//pause entry in the queue
				guiService.pauseEntry(data);
			}
			else if(this.status == Constants.unpause)
			{
				//unpause entry in the queue
				guiService.unpauseEntry(data);	
			}
			else if(this.status == Constants.remove)
			{
				//remove entry from the queue
				guiService.removeEntry();	
			}
		}
	}

}
