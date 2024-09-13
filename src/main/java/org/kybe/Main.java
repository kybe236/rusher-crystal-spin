package org.kybe;

import org.rusherhack.client.api.RusherHackAPI;
import org.rusherhack.client.api.plugin.Plugin;

/**
 * @author kybe236
 */
public class Main extends Plugin {
	
	@Override
	public void onLoad() {
		final CrystalSpin crystalSpin = new CrystalSpin();
		RusherHackAPI.getModuleManager().registerFeature(crystalSpin);
	}
	
	@Override
	public void onUnload() {
	}
	
}