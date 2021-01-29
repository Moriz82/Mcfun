package com.Moriz.OfficialMCSexMod.core.init;

import com.Moriz.OfficialMCSexMod.OfficialMCSexMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class block_init {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OfficialMCSexMod.MOD_ID);

	public static final RegistryObject<Block> sexMachine_block = BLOCKS.register("sexmachine_block",
			() ->new Block(AbstractBlock.Properties.create(Material.SPONGE, MaterialColor.QUARTZ)
					.hardnessAndResistance(0f,0.05f)
					.harvestLevel(-1)
					.sound(SoundType.FUNGUS)
			));
}
