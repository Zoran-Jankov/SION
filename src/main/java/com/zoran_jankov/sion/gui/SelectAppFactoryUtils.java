package com.zoran_jankov.sion.gui;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import com.zoran_jankov.sion.app.InstallerSettings;

public class SelectAppFactoryUtils
{
	public static InstallerSettings settings = InstallerSettings.getInstance();
	
	public static JCheckBox getInstance(String application)
	{
		JCheckBox selectApp = new JCheckBox(application);
		URL iconURL = SelectAppFactoryUtils.class.getClass().getResource(settings.getIconPath(application));
		//ImageIcon icon = new ImageIcon(iconURL);
		//selectApp.setIcon(icon);
		 
		return selectApp;
	}
}