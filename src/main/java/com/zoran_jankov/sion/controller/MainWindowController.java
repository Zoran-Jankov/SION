package com.zoran_jankov.sion.controller;

import javax.swing.JFrame;

import com.zoran_jankov.sion.app.InstallerManager;
import com.zoran_jankov.sion.gui.AppSelectionPanel;

public class MainWindowController {
	private InstallerManager installerManager = new InstallerManager();
	private JFrame window = new JFrame();

	public MainWindowController() {
		AppSelectionPanel appSelectionPanel = new AppSelectionPanel(4);
		window.add(appSelectionPanel);
		window.setSize(appSelectionPanel.getSize());
		window.pack();
		window.setVisible(true);
	}
}