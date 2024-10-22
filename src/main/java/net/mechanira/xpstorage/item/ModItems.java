package net.mechanira.xpstorage.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mechanira.xpstorage.XPStorage;
import net.mechanira.xpstorage.item.custom.SuperXPBottleItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item SUPER_XP_BOTTLE = registerItem("super_xp_bottle", new SuperXPBottleItem(new Item.Settings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(SUPER_XP_BOTTLE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(XPStorage.MOD_ID, name), item);
    }

    public static void registerModItems() {
        XPStorage.LOGGER.info("Registering Mod Items for" + XPStorage.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}