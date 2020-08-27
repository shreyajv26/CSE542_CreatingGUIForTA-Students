package controller;

import java.awt.Color;
import java.awt.Component;

import javax.swing.table.DefaultTableModel;

import core.Data;
import core.GuiUtil;
import core.GuiEnums.EventStatus;
import view.GuiApplication;

public class GuiServiceImpl implements GuiService {

	/*
	 * Adding entries to the queue
	 */
	@Override
	public void addEntry(String name, String email) {
		GuiApplication.queueEntries.add(new Data(name, email, EventStatus.unpaused));
	}

	/*
	 * Removing an entry from the queue
	 */
	@Override
	public void removeEntry() {
		int row = GuiApplication.table.getSelectedRow();
		for (int i = 0; i<=row; i++)
		{
			if(i==row)
			{
				GuiApplication.queueEntries.remove(i);
			}
		}
		GuiUtil.displayQueueEntries((DefaultTableModel)GuiApplication.table.getModel());
		javax.swing.FocusManager.getCurrentManager().getActiveWindow().dispose();
	}

	/*
	 * pausing an entry in the queue
	 */
	@Override
	public void pauseEntry(int rownumber) {
		Data data = GuiApplication.queueEntries.get(rownumber);
		data.setEventStatus(EventStatus.paused);
		//display queue details
		GuiUtil.displayQueueEntries((DefaultTableModel)GuiApplication.table.getModel());
		javax.swing.FocusManager.getCurrentManager().getActiveWindow().dispose();
	}
	
	/*
	 * Unpausing an entry in the queue
	 */
	@Override
	public void unpauseEntry(int rownumber) {
		Data data = GuiApplication.queueEntries.get(rownumber);
		data.setEventStatus(EventStatus.unpaused);
		//display queue details
		GuiUtil.displayQueueEntries((DefaultTableModel)GuiApplication.table.getModel());
		javax.swing.FocusManager.getCurrentManager().getActiveWindow().dispose();
	}
	
}
