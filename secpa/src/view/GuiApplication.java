package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.ActionListen;
import controller.GuiService;
import controller.GuiServiceImpl;
import core.Constants;
import core.Data;
import core.GuiUtil;

public class GuiApplication {

	public static JFrame frame;
	
	public static JTable table;
	
	//LinkedList to maintain the insertion order as queue
	public static List<Data> queueEntries = new LinkedList<Data>();
	
	public static ActionListen listener = new ActionListen();
	
	public static GuiService guiService = new GuiServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiApplication window = new GuiApplication();
					GuiApplication.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 500, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton addButton = new JButton(Constants.addStuButton);
		addButton.setBounds(32, 74, 109, 21);
		GuiUtil.addButtonAttributes(addButton);
		
		JButton pauseButton = new JButton(Constants.pause);
		pauseButton.setBounds(32, 147, 109, 21);
		GuiUtil.addButtonAttributes(pauseButton);
		
		JButton unpauseButton = new JButton(Constants.unpause);
		unpauseButton.setBounds(32, 215, 109, 21);
		GuiUtil.addButtonAttributes(unpauseButton);
		
		JButton removeButton = new JButton(Constants.remove);
		removeButton.setBounds(32, 294, 109, 21);
		GuiUtil.addButtonAttributes(removeButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 23, 446, 396);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						Constants.order, Constants.colName, Constants.colStatus}
				));
		scrollPane.setViewportView(table);
		
		//create random entries
		GuiUtil.createRandomEntry(guiService);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		//display queue details
		GuiUtil.displayQueueEntries(model);
		
	}

}
