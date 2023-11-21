package com.workert.robotics.base.registries;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.content.contraptions.itemAssembly.SequencedAssemblyItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.workert.robotics.Robotics;
import com.workert.robotics.content.computers.punchcard.PunchCardItem;
import com.workert.robotics.content.robotics.BaseRobotItem;
import com.workert.robotics.content.utility.extendoboots.ExtendOBootsItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemRegistry {
	public static void register() {
	}

	static {
		Robotics.REGISTRATE.startSection(AllSections.MATERIALS);
	}

	public static final CreativeModeTab ROBOTICS_TAB = new CreativeModeTab(Robotics.MOD_ID) {
		@Override
		public ItemStack makeIcon() {
			return ItemRegistry.BRONZE_INGOT.get().getDefaultInstance();
		}
	};

	public static final ItemEntry<Item> TIN_INGOT = Robotics.REGISTRATE
			.item("tin_ingot", Item::new)
			.lang("Tin ingot")
			.tag(Tags.Items.INGOTS)
			.tag(AllTags.forgeItemTag("ingots/tin"))
			.register();
	public static final ItemEntry<Item> TIN_NUGGET = Robotics.REGISTRATE
			.item("tin_nugget", Item::new)
			.lang("Tin nugget")
			.tag(Tags.Items.NUGGETS)
			.tag(AllTags.forgeItemTag("nuggets/tin"))
			.register();
	public static final ItemEntry<Item> RAW_TIN = Robotics.REGISTRATE
			.item("raw_tin", Item::new)
			.lang("Raw tin")
			.tag(Tags.Items.RAW_MATERIALS)
			.register();

	public static final ItemEntry<Item> BRONZE_INGOT = Robotics.REGISTRATE
			.item("bronze_ingot", Item::new)
			.lang("Bronze ingot")
			.tag(Tags.Items.INGOTS)
			.tag(AllTags.forgeItemTag("ingots/bronze"))
			.register();
	public static final ItemEntry<Item> BRONZE_NUGGET = Robotics.REGISTRATE
			.item("bronze_nugget", Item::new)
			.lang("Bronze nugget")
			.tag(Tags.Items.NUGGETS)
			.tag(AllTags.forgeItemTag("nuggets/bronze"))
			.register();

	public static final ItemEntry<Item> PROGRAM = Robotics.REGISTRATE
			.item("program", Item::new)
			.lang("Program")
			.properties(properties -> properties
					.stacksTo(1)
					.rarity(Rarity.UNCOMMON))
			.register();

	public static final ItemEntry<BaseRobotItem> CLOCKCOPTER = Robotics.REGISTRATE
			.item("clockcopter", BaseRobotItem::new)
			.lang("Clockcopter")
			.onRegister(item -> item.setEntity(EntityRegistry.FLYING_TOOLBOX))
			.register();


	/*public static final ItemEntry<BaseRobotItem> MINER = Robotics.REGISTRATE
			.item("miner", BaseRobotItem::new)
			.onRegister(item -> item.setEntity(() -> EntityList.MINER.get()))
			.register();*/

	public static final ItemEntry<BaseRobotItem> CODE_DRONE = Robotics.REGISTRATE
			.item("code_drone", BaseRobotItem::new)
			.lang("Juan")
			.onRegister(item -> item.setEntity(EntityRegistry.CODE_DRONE))
			.register();

	public static final ItemEntry<ExtendOBootsItem> EXTEND_O_BOOTS = Robotics.REGISTRATE
			.item("extend_o_boots",
					ExtendOBootsItem::new)
			.lang("Extend-O-Boots")
			.register();

	public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_CLOCKCOPTER = Robotics.REGISTRATE.item(
			"incomplete_clockcopter", SequencedAssemblyItem::new).register();

	public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_CODE_DRONE = Robotics.REGISTRATE.item(
			"incomplete_code_drone", SequencedAssemblyItem::new).register();

	public static final ItemEntry<PunchCardItem> PUNCH_CARD = Robotics.REGISTRATE
			.item("punch_card", PunchCardItem::new)
			.lang("Punch Card")
			.register();
}
