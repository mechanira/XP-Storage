package net.mechanira.xpstorage.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mechanira.xpstorage.XPStorage;
import net.mechanira.xpstorage.item.custom.OmegaXPBottleItem;
import net.mechanira.xpstorage.item.custom.SuperXPBottleItem;
import net.mechanira.xpstorage.item.custom.SupremeXPBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {
    public static final Item SUPER_XP_BOTTLE = registerItem("super_xp_bottle", new SuperXPBottleItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(XPStorage.MOD_ID, "super_xp_bottle")))
            .rarity(Rarity.RARE)));
    public static final Item SUPREME_XP_BOTTLE = registerItem("supreme_xp_bottle", new SupremeXPBottleItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(XPStorage.MOD_ID, "supreme_xp_bottle")))
            .rarity(Rarity.EPIC)));
    public static final Item OMEGA_XP_BOTTLE = registerItem("omega_xp_bottle", new OmegaXPBottleItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(XPStorage.MOD_ID, "omega_xp_bottle")))
            .rarity(Rarity.EPIC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(XPStorage.MOD_ID, name), item);
    }

    public static void registerModItems() {
        XPStorage.LOGGER.info("Registering Mod Items for" + XPStorage.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SUPER_XP_BOTTLE);
            entries.add(SUPREME_XP_BOTTLE);
            entries.add(OMEGA_XP_BOTTLE);
        });
    }
}
