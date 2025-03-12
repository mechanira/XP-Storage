package net.mechanira.xpstorage;

import net.fabricmc.api.ModInitializer;

import net.mechanira.xpstorage.entity.ModEntities;
import net.mechanira.xpstorage.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XPStorage implements ModInitializer {
	public static final String MOD_ID = "xp-storage";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}