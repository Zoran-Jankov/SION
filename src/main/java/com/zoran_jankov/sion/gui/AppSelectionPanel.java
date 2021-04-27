package com.zoran_jankov.sion.gui;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import com.zoran_jankov.sion.app.InstallerSettings;

import net.miginfocom.swing.MigLayout;

public class AppSelectionPanel extends JPanel {
	private static final long serialVersionUID = 2024293821169454146L;
	private InstallerSettings settings = InstallerSettings.getInstance();
	private Map<String, JCheckBox> checkBoxes = new HashMap<String, JCheckBox>();

	public AppSelectionPanel(int numberOfColumns) {
		String[] layout = generateLayout(numberOfColumns);
		setLayout(new MigLayout(layout[0], layout[1], layout[2]));
		int column = 0;
		int row = 0;
		for (String Application : settings.getAppNames()) {
			JCheckBox appCheckBox = CheckBoxFactoryUtils.getInstance(Application);
			if (column == numberOfColumns) {
				row++;
				column = 0;
			}
			String cell = "cell " + Integer.toString(column) + " "
					+ Integer.toString(row);
			column++;
			add(appCheckBox, cell);
			checkBoxes.put(Application, appCheckBox);
		}
	}

	private String[] generateLayout(int numberOfColumns) {
		String[] layout = new String[3];
		StringBuilder layoutColumns = new StringBuilder();

		for (int columnNumber = 0; columnNumber < numberOfColumns; columnNumber++) {
			layoutColumns.append("[200px:200px:200px]");
		}
		int numberOfApps = settings.getAppNames().size();
		int numberOfRows = numberOfApps / numberOfColumns;
		if (numberOfApps % numberOfColumns > 0) {
			numberOfRows++;
		}
		StringBuilder layoutRows = new StringBuilder();
		for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
			layoutRows.append("[]");
		}
		layout[0] = "";
		layout[1] = layoutColumns.toString();
		layout[2] = layoutRows.toString();
		return layout;
	}
	
	public Map<String, Boolean> getAppsForInstall() {
		Map<String, Boolean> applications = new HashMap<String, Boolean>();
		checkBoxes.forEach((key, value) -> applications.put(key, value.isSelected()));
		return applications;
	}
}