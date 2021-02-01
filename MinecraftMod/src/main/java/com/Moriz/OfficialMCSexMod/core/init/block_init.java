package com.Moriz.OfficialMCSexMod.core.init;

import com.Moriz.OfficialMCSexMod.OfficialMCSexMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class block_init {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OfficialMCSexMod.MOD_ID);
	//blue
	public static final RegistryObject<Block> block_o_cum_blue = BLOCKS.register("block_o_cum_blue",
			() ->new Block(AbstractBlock.Properties.create(Material.SPONGE, MaterialColor.QUARTZ)
					.hardnessAndResistance(10f,15f)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2)
					.sound(SoundType.FUNGUS)
					.setRequiresTool()
			));
	//green
	public static final RegistryObject<Block> block_o_cum_green = BLOCKS.register("block_o_cum_green",
			() ->new Block(AbstractBlock.Properties.create(Material.SPONGE, MaterialColor.QUARTZ)
					.hardnessAndResistance(10f,15f)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2)
					.sound(SoundType.FUNGUS)
					.setRequiresTool()
			));
	//orange
	public static final RegistryObject<Block> block_o_cum_orange = BLOCKS.register("block_o_cum_orange",
			() ->new Block(AbstractBlock.Properties.create(Material.SPONGE, MaterialColor.QUARTZ)
					.hardnessAndResistance(10f,15f)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2)
					.sound(SoundType.FUNGUS)
					.setRequiresTool()
			));
	//pink
	public static final RegistryObject<Block> block_o_cum_pink = BLOCKS.register("block_o_cum_pink",
			() ->new Block(AbstractBlock.Properties.create(Material.SPONGE, MaterialColor.QUARTZ)
					.hardnessAndResistance(10f,15f)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2)
					.sound(SoundType.FUNGUS)
					.setRequiresTool()
			));
	//purple
	public static final RegistryObject<Block> block_o_cum_purple = BLOCKS.register("block_o_cum_purple",
			() ->new Block(AbstractBlock.Properties.create(Material.SPONGE, MaterialColor.QUARTZ)
					.hardnessAndResistance(10f,15f)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2)
					.sound(SoundType.FUNGUS)
					.setRequiresTool()
			));
	//red
	public static final RegistryObject<Block> block_o_cum_red = BLOCKS.register("block_o_cum_red",
			() ->new Block(AbstractBlock.Properties.create(Material.SPONGE, MaterialColor.QUARTZ)
					.hardnessAndResistance(10f,15f)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2)
					.sound(SoundType.FUNGUS)
					.setRequiresTool()
			));
	//yellow
	public static final RegistryObject<Block> block_o_cum_yellow = BLOCKS.register("block_o_cum_yellow",
			() ->new Block(AbstractBlock.Properties.create(Material.SPONGE, MaterialColor.QUARTZ)
					.hardnessAndResistance(10f,15f)
					.harvestTool(ToolType.PICKAXE).harvestLevel(2)
					.sound(SoundType.FUNGUS)
					.setRequiresTool()
			));
}
