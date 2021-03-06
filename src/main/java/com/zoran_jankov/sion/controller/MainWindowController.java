package com.zoran_jankov.sion.controller;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import com.zoran_jankov.sion.app.InstallerManager;
import com.zoran_jankov.sion.gui.AppSelectionPanel;

import net.miginfocom.swing.MigLayout;

public class MainWindowController {
	private static final int NUMBER_OF_COLUMNS = 4;
	private InstallerManager installerManager = new InstallerManager();
	private JFrame window = new JFrame(
			"SION - Software Installer Over Network");
	private Dimension windowSize;

	public MainWindowController() {
		window.setLayout(new MigLayout("insets 20", "[center]",
				"[][10px][200px][10px][fill,grow,25px][10px][]"));
		window.setVisible(true);
		window.setResizable(false);
		initializeComponents();
		window.setSize(windowSize);
		window.pack();
	}

	private void initializeComponents() {
		AppSelectionPanel appSelectionPanel = new AppSelectionPanel(
				NUMBER_OF_COLUMNS);
		window.add(appSelectionPanel, "cell 0 0");
		windowSize = appSelectionPanel.getSize();
		JTextArea infoBox = new JTextArea();
		infoBox.setEditable(false);
		window.add(infoBox, "cell 0 2, grow");
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(Color.GREEN);
		progressBar.setValue(50);
		progressBar.setStringPainted(true);
		progressBar.setString("Installing . . . ");
		window.add(progressBar, "cell 0 4, grow");
		JButton installButton = new JButton("Install");
		window.add(installButton, "cell 0 6");
	}
}