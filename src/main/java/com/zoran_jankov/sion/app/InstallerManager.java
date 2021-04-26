package com.zoran_jankov.sion.app;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

public class InstallerManager
{
	private InstallerSettings settings = InstallerSettings.getInstance();

	private void install(String application)
	{
		String installerPath = settings.getPath(application);
		String arguments = settings.getArguments(application);

		try
		{
			Process installer = new ProcessBuilder(installerPath, arguments).start();
			installer.waitFor();
		}
		catch (IOException | InterruptedException e)
		{
			 e.printStackTrace();
		}
	}

	public void startInstallation(Map<String, Boolean> softwareToInstall)
	{
		for (Entry<String, Boolean> application : softwareToInstall.entrySet())
		{
			if(application.getValue())
			{
				install(application.getKey());
			}
		}
	}
}