package com.zoran_jankov.sion.app;

import com.zoran_jankov.sion.controller.MainWindowController;

public class Sion
{
	private static final String INSTALLER_SETTINGS_PATH = "/Installers-Settings.ini";
	
	public static void main(String[] args)
	{	
		InstallerSettings.getInstance().loadSettings(INSTALLER_SETTINGS_PATH);
		new MainWindowController();
	}
}