package com.zoran_jankov.sion.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.ini4j.Ini;

public class InstallerSettings {
	private static InstallerSettings instance;

	private Ini settings;

	public static synchronized InstallerSettings getInstance() {
		if (instance == null) {
			instance = new InstallerSettings();
		}
		return instance;
	}

	private InstallerSettings() {

	}

	public void loadSettings(String path) {
		InputStream inputStream = getClass().getResourceAsStream(path);

		try {
			settings = new Ini(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Set<String> getAppNames() {
		return settings.keySet();
	}

	public String getArguments(String application) {
		return settings.get(application, Option.ARGUMENTS);
	}

	public String getNetworkPath(String application) {
		return settings.get(application, Option.NETWORK_REPOSITORY);
	}

	public String getIconPath(String application) {
		return settings.get(application, Option.ICON);
	}
}