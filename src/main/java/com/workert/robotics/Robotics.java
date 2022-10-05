package com.workert.robotics;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.workert.robotics.block.ModBlocks;
import com.workert.robotics.block.entity.ModBlockEntities;
import com.workert.robotics.item.ModItems;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Robotics.MOD_ID)
public class Robotics {

	public static final String MOD_ID = "robotics";
	private static final Logger LOGGER = LogUtils.getLogger();

	public Robotics() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModBlocks.register(eventBus);
		ModItems.register(eventBus);

		ModBlockEntities.register(eventBus);

		eventBus.addListener(this::clientSetup);

		MinecraftForge.EVENT_BUS.register(this);

	}

	private void clientSetup(final FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.SMASHER_BLOCK.get(), RenderType.translucent());
	}
}
