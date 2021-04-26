package com.zoran_jankov.sion.controller;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

import com.zoran_jankov.sion.app.InstallerManager;
import com.zoran_jankov.sion.app.InstallerSettings;
import com.zoran_jankov.sion.gui.SelectAppFactoryUtils;

import net.miginfocom.swing.MigLayout;

public class MainWindowController
{
    private InstallerManager installerManager = new InstallerManager();
    private JFrame mainFrame = new JFrame();
    private InstallerSettings settings = InstallerSettings.getInstance();
    
    public MainWindowController()
    {
    	mainFrame.setLayout(new MigLayout());
    	for (String Application : settings.getAppNames()) {
    	    JCheckBox app = SelectAppFactoryUtils.getInstance(Application);
    	    mainFrame.add(app);
    	    mainFrame.setVisible(true);
    	}
    	
    }
}