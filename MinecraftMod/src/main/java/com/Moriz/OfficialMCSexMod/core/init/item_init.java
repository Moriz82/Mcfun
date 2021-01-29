package com.Moriz.OfficialMCSexMod.core.init;

import com.Moriz.OfficialMCSexMod.OfficialMCSexMod;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class item_init {
	public static final ItemGroup SexModTab = OfficialMCSexMod.SEXMOD_TAB;
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OfficialMCSexMod.MOD_ID);
	//create example item
	public static final RegistryObject<Item> dildo_item = ITEMS.register("dildo_item",
			() -> new Item(new Item.Properties().group(SexModTab)));


	//blocks as items
	public static RegistryObject<BlockItem> sexMachine_block = ITEMS.register("sexmachine_block",
			() -> new BlockItem(block_init.sexMachine_block.get(), new Item.Properties().group(SexModTab)));

}
