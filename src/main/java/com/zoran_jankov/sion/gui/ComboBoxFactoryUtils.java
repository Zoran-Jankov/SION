package com.zoran_jankov.sion.gui;

import javax.swing.JCheckBox;

public class ComboBoxFactoryUtils {
	public static JCheckBox getInstance(String application) {
		JCheckBox selectApp = new JCheckBox(application);
		return selectApp;
	}
}