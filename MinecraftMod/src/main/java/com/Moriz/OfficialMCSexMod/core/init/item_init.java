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
	//blue
	public static final RegistryObject<Item> dildo_item_blue = ITEMS.register("dildo_item_blue",
			() -> new Item(new Item.Properties().group(SexModTab)));
	//green
	public static final RegistryObject<Item> dildo_item_green = ITEMS.register("dildo_item_green",
			() -> new Item(new Item.Properties().group(SexModTab)));
	//orange
	public static final RegistryObject<Item> dildo_item_orange = ITEMS.register("dildo_item_orange",
			() -> new Item(new Item.Properties().group(SexModTab)));
	//pink
	public static final RegistryObject<Item> dildo_item_pink = ITEMS.register("dildo_item_pink",
			() -> new Item(new Item.Properties().group(SexModTab)));
	//purple
	public static final RegistryObject<Item> dildo_item_purple = ITEMS.register("dildo_item_purple",
			() -> new Item(new Item.Properties().group(SexModTab)));
	//red
	public static final RegistryObject<Item> dildo_item_red = ITEMS.register("dildo_item_red",
			() -> new Item(new Item.Properties().group(SexModTab)));
	//yellow
	public static final RegistryObject<Item> dildo_item_yellow = ITEMS.register("dildo_item_yellow",
			() -> new Item(new Item.Properties().group(SexModTab)));


	//blocks as items

	//blue
	public static RegistryObject<BlockItem> block_o_cum_blue = ITEMS.register("block_o_cum_blue",
			() -> new BlockItem(block_init.block_o_cum_blue.get(), new Item.Properties().group(SexModTab)));
	//green
	public static RegistryObject<BlockItem> block_o_cum_green = ITEMS.register("block_o_cum_green",
			() -> new BlockItem(block_init.block_o_cum_green.get(), new Item.Properties().group(SexModTab)));
	//orange
	public static RegistryObject<BlockItem> block_o_cum_orange = ITEMS.register("block_o_cum_orange",
			() -> new BlockItem(block_init.block_o_cum_orange.get(), new Item.Properties().group(SexModTab)));
	//pink
	public static RegistryObject<BlockItem> block_o_cum_pink = ITEMS.register("block_o_cum_pink",
			() -> new BlockItem(block_init.block_o_cum_pink.get(), new Item.Properties().group(SexModTab)));
	//purple
	public static RegistryObject<BlockItem> block_o_cum_purple = ITEMS.register("block_o_cum_purple",
			() -> new BlockItem(block_init.block_o_cum_purple.get(), new Item.Properties().group(SexModTab)));
	//red
	public static RegistryObject<BlockItem> block_o_cum_red = ITEMS.register("block_o_cum_red",
			() -> new BlockItem(block_init.block_o_cum_red.get(), new Item.Properties().group(SexModTab)));
	//yellow
	public static RegistryObject<BlockItem> block_o_cum_yellow = ITEMS.register("block_o_cum_yellow",
			() -> new BlockItem(block_init.block_o_cum_yellow.get(), new Item.Properties().group(SexModTab)));
}
