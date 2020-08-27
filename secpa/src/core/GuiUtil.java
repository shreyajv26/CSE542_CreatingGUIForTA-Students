package core;

import static view.GuiApplication.frame;
import static view.GuiApplication.listener;
import static view.GuiApplication.queueEntries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import controller.GuiService;

public class GuiUtil {
	
	/*
	 * Method to create initial entries in queue
	 */
	public static void createRandomEntry(GuiService guiService) {
		//Map to store the generated random data to avoid duplicate
		HashMap<String, String> randomData = new HashMap<String, String>();

		//Get random data from list
		List<String> preListKeys = new ArrayList<>(Constants.preList.keySet());

		for(int i=0; i<Constants.randomEntries; i++) {
			String key = preListKeys.get(new Random().nextInt(preListKeys.size()));
			if(!randomData.containsKey(key)) {
				randomData.put(key, Constants.preList.get(key));
				guiService.addEntry(Constants.preList.get(key), key);
			} else {
				i--;
			}
		}
	}
	
	/*
	 * Display list of entries in the queue
	 */
	public static void displayQueueEntries(DefaultTableModel model) {
		model.setRowCount(0);
		queueEntries.forEach(entry -> { 
			model.addRow(new Object[] {model.getRowCount()+1 ,entry.getName(), entry.getEventStatus()});
		});
	}
	
	/*
	 * Adding button attributes like color, listeners
	 */
	public static void addButtonAttributes(JButton button) {
		button.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(listener);
		frame.getContentPane().add(button);
	}
	
}
