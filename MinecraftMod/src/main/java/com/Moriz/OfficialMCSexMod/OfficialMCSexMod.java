package com.Moriz.OfficialMCSexMod;

import com.Moriz.OfficialMCSexMod.core.init.block_init;
import com.Moriz.OfficialMCSexMod.core.init.item_init;
import com.Moriz.OfficialMCSexMod.world.OreGeneration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.tools.jar.Main;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OfficialMCSexMod.MOD_ID)
public class OfficialMCSexMod
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "officialmcsexmod";
    public static final ItemGroup SEXMOD_TAB = new SexModItemGroup(MOD_ID);

    public OfficialMCSexMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        item_init.ITEMS.register(bus);
        block_init.BLOCKS.register(bus);

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }
    public static class SexModItemGroup extends ItemGroup{
        public SexModItemGroup(final String name){
            super(name);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(item_init.dildo_item_purple.get());
        }
    }
}
