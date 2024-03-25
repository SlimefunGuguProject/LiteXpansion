package dev.j3fftw.litexpansion;

import dev.j3fftw.extrautils.utils.LoreBuilderDynamic;
import dev.j3fftw.litexpansion.machine.MassFabricator;
import dev.j3fftw.litexpansion.machine.Recycler;
import dev.j3fftw.litexpansion.machine.RubberSynthesizer;
import dev.j3fftw.litexpansion.machine.generators.AdvancedSolarPanel;
import dev.j3fftw.litexpansion.weapons.NanoBlade;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;

public final class Items {

    //region Category
    public static final ItemGroup LITEXPANSION = new ItemGroup(
        new NamespacedKey(LiteXpansion.getInstance(),
            "litexpansion"
        ),
        new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "3f87fc5cbb233743a82fb0fa51fe739487f29bcc01c9026621ecefad197f4fb1")),
            "&7工业(LiteXpansion)"
        )
    );

    public static final SlimefunItemStack ELECTRIC_CHESTPLATE = new SlimefunItemStack(
        "ELECTRIC_CHESTPLATE",
        Material.LEATHER_CHESTPLATE, Color.TEAL,
        "&9电动护甲",
        "",
        "&8\u21E8 &7抵消所有对自身的伤害.",
        "",
        "&c&o&8\u21E8 &e\u26A1 &70 / 8192 J"
    );
    //endregion

    //region Armor
    public static final SlimefunItemStack NANO_BLADE = new SlimefunItemStack(
        "NANO_BLADE",
        Material.DIAMOND_SWORD,
        "&2纳米剑 &c(关)",
        "",
        "&f一把高科技的光剑,",
        "&f可以轻松斩断对手.",
        "",
        "&f开关: &a右键",
        "",
        "&c&o&8\u21E8 &e\u26A1 &70 / " + NanoBlade.CAPACITY + " J"
    );
    //endregion

    //region Weapon
    // Tools
    public static final SlimefunItemStack GLASS_CUTTER = new SlimefunItemStack(
        "GLASS_CUTTER",
        Material.GHAST_TEAR,
        "&b玻璃刀",
        "",
        "&7> &e左键 &7- 快速割下玻璃",
        "&7> &e右键 &7- 慢速割下玻璃",
        "",
        "&c&o&8\u21E8 &e\u26A1 &70 / 300 J"
    );
    public static final SlimefunItemStack MINING_DRILL = new SlimefunItemStack(
        "MINING_DRILL",
        Material.IRON_SHOVEL,
        "&7采矿钻头",
        "",
        "&7快速破坏任何岩石",
        "&7右键缓慢破坏",
        "",
        "&c&o&8\u21E8 &e\u26A1 &70 / 1000 J"
    );
    public static final SlimefunItemStack DIAMOND_DRILL = new SlimefunItemStack(
        "DIAMOND_DRILL",
        Material.DIAMOND_SHOVEL,
        "&b钻石采矿钻头",
        "",
        "&7快速破坏任何岩石与黑曜石",
        "&7右键缓慢破坏",
        "",
        "&c&o&8\u21E8 &e\u26A1 &70 / 1000 J"
    );
    public static final SlimefunItemStack TREETAP = new SlimefunItemStack(
        "TREETAP",
        Material.WOODEN_HOE,
        "&7木龙头"
    );
    public static final SlimefunItemStack CARGO_CONFIGURATOR = new SlimefunItemStack(
        "CARGO_CONFIGURATOR",
        Material.COMPASS,
        "&7节点配置复制器",
        "",
        "&7> &e右键 &7- 复制节点配置",
        "&7> &e左键  &7- 黏贴节点配置",
        "&7> &eShift+右键 &7- 清除节点配置"
    );
    //endregion

    //region Items
    public static final SlimefunItemStack TIN_PLATE = new SlimefunItemStack(
        "TIN_PLATE",
        Material.WHITE_CARPET,
        "&7锡板"
    );

    public static final SlimefunItemStack TIN_ITEM_CASING = new SlimefunItemStack(
        "TIN_ITEM_CASING",
        Material.WHITE_CARPET,
        "&7锡质外壳"
    );

    public static final SlimefunItemStack UNINSULATED_TIN_CABLE = new SlimefunItemStack(
        "UNINSULATED_TIN_CABLE",
        Material.STRING,
        "&7锡质导线"
    );

    public static final SlimefunItemStack TIN_CABLE = new SlimefunItemStack(
        "TIN_CABLE",
        Material.STRING,
        "&7绝缘锡质导线"
    );

    public static final SlimefunItemStack COPPER_PLATE = new SlimefunItemStack(
        "COPPER_PLATE",
        Material.ORANGE_CARPET,
        "&7铜板"
    );

    public static final SlimefunItemStack COPPER_ITEM_CASING = new SlimefunItemStack(
        "COPPER_ITEM_CASING",
        Material.ORANGE_CARPET,
        "&7铜质外壳"
    );

    public static final SlimefunItemStack MAG_THOR = new SlimefunItemStack(
        "MAG_THOR",
        Material.IRON_INGOT,
        "&b&l镁钍合金",
        "",
        "&7&o坚如磐石的合金",
        "&7&o用于大多数高级机器中"
    );

    public static final SlimefunItemStack THORIUM = new SlimefunItemStack(
        "THORIUM",
        new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "b87403257c0eaa518cf186deccde137d476556ccff146d503fb2e73956582f37")),
            "钍"
        ),
        "&8钍",
        "",
        LoreBuilder.radioactive(Radioactivity.HIGH),
        "&8\u21E8 &4需要防化服!"
    );

    public static final SlimefunItemStack SCRAP = new SlimefunItemStack(
        "SCRAP",
        Material.DEAD_BUSH,
        "&8废料",
        "",
        "&7用于合成 &5UU 物质"
    );
    public static final SlimefunItemStack UU_MATTER = new SlimefunItemStack(
        "UU_MATTER",
        Material.PURPLE_DYE,
        "&5UU 物质",
        "",
        "&7用于合成各种物品"
    );
    public static final SlimefunItemStack IRIDIUM = new SlimefunItemStack(
        "IRIDIUM",
        Material.WHITE_DYE,
        "&f铱"
    );
    public static final SlimefunItemStack IRIDIUM_PLATE = new SlimefunItemStack(
        "IRIDIUM_PLATE",
        Material.PAPER,
        "&f铱板",
        "",
        "&7用于合成量子套"
    );
    public static final SlimefunItemStack THORIUM_DUST = new SlimefunItemStack(
        "THORIUM_DUST",
        Material.BLACK_DYE,
        "&8钍粉"
    );
    public static final SlimefunItemStack REFINED_IRON = new SlimefunItemStack(
        "REFINED_IRON",
        Material.IRON_INGOT,
        "&7精炼铁"
    );
    public static final SlimefunItemStack MACHINE_BLOCK = new SlimefunItemStack(
        "MACHINE_BLOCK",
        Material.IRON_BLOCK,
        "&7机器方块"
    );
    public static final SlimefunItemStack UNINSULATED_COPPER_CABLE = new SlimefunItemStack(
        "UNINSULATED_COPPER_CABLE",
        Material.STRING,
        "&7铜质导线"
    );
    public static final SlimefunItemStack COPPER_CABLE = new SlimefunItemStack(
        "COPPER_CABLE",
        Material.STRING,
        "&7绝缘铜质导线"
    );
    public static final SlimefunItemStack RUBBER = new SlimefunItemStack(
        "RUBBER",
        Material.INK_SAC,
        "&7橡胶"
    );
    public static final SlimefunItemStack ELECTRONIC_CIRCUIT = new SlimefunItemStack(
        "ELECTRONIC_CIRCUIT",
        Material.COBWEB,
        "&7基础电路"
    );
    public static final SlimefunItemStack ADVANCED_CIRCUIT = new SlimefunItemStack(
        "ADVANCED_CIRCUIT",
        Material.COBWEB,
        "&7高级电路"
    );
    //endregion

    //region Carbon Crap
    //////////////////////////
    // Carbon Crap
    //////////////////////////
    public static final SlimefunItemStack COAL_DUST = new SlimefunItemStack(
        "COAL_DUST",
        Material.BLACK_DYE,
        "&7碳粉"
    );
    public static final SlimefunItemStack RAW_CARBON_FIBRE = new SlimefunItemStack(
        "RAW_CARBON_FIBRE",
        Material.BLACK_DYE,
        "&7粗制碳网"
    );
    public static final SlimefunItemStack RAW_CARBON_MESH = new SlimefunItemStack(
        "RAW_CARBON_MESH",
        Material.BLACK_DYE,
        "&7粗制碳板"
    );
    public static final SlimefunItemStack CARBON_PLATE = new SlimefunItemStack(
        "CARBON_PLATE",
        Material.BLACK_CARPET,
        "&7碳板"
    );
    public static final SlimefunItemStack ADVANCED_ALLOY = new SlimefunItemStack(
        "ADVANCED_ALLOY",
        Material.PAPER,
        "&7高级合金"
    );
    //endregion

    public static final SlimefunItemStack ADVANCED_MACHINE_BLOCK = new SlimefunItemStack(
        "ADVANCED_MACHINE_BLOCK",
        Material.DIAMOND_BLOCK,
        "&7高级机器方块"
    );

    public static final SlimefunItemStack LAPOTRON_CRYSTAL = new SlimefunItemStack(
        "LAPOTRON_CRYSTAL",
        Material.DIAMOND,
        "&7兰波顿水晶"
    );
    public static final SlimefunItemStack REINFORCED_STONE = new SlimefunItemStack(
        "REINFORCED_STONE",
        Material.STONE,
        "&7强化圆石"
    );
    public static final SlimefunItemStack REINFORCED_DOOR = new SlimefunItemStack(
        "REINFORCED_DOOR",
        Material.IRON_DOOR,
        "&7强化门"
    );
    public static final SlimefunItemStack REINFORCED_GLASS = new SlimefunItemStack(
        "REINFORCED_GLASS",
        Material.GRAY_STAINED_GLASS,
        "&7强化玻璃"
    );
    public static final SlimefunItemStack MIXED_METAL_INGOT = new SlimefunItemStack(
        "MIXED_METAL_INGOT",
        Material.IRON_INGOT,
        "&7合金锭"
    );
    // Machines
    public static final SlimefunItemStack RECYCLER = new SlimefunItemStack(
        "SCRAP_MACHINE",
        Material.BLACK_CONCRETE,
        "&8回收机",
        "",
        "&f回收任何物品来获得 &8废料",
        "",
        LoreBuilderDynamic.powerBuffer(Recycler.CAPACITY),
        LoreBuilderDynamic.powerPerTick(Recycler.ENERGY_CONSUMPTION)
    );
    public static final SlimefunItemStack MASS_FABRICATOR_MACHINE = new SlimefunItemStack(
        "MASS_FABRICATOR_MACHINE",
        Material.PURPLE_CONCRETE,
        "&5物质生成机",
        "",
        "&f将 &8废料 &f转换成 &5UU 物质",
        "&7&o&m\"只需要亿点点电\"",
        "",
        LoreBuilderDynamic.powerBuffer(MassFabricator.CAPACITY),
        LoreBuilderDynamic.powerPerTick(MassFabricator.ENERGY_CONSUMPTION)
    );
    public static final SlimefunItemStack RUBBER_SYNTHESIZER_MACHINE = new SlimefunItemStack(
        "RUBBER_SYNTHESIZER",
        Material.ORANGE_CONCRETE,
        "&6橡胶合成机",
        "",
        "&f将原油转化为 &7橡胶",
        "",
        LoreBuilderDynamic.powerBuffer(RubberSynthesizer.CAPACITY),
        LoreBuilderDynamic.powerPerTick(RubberSynthesizer.ENERGY_CONSUMPTION)
    );
    public static final SlimefunItemStack MACERATOR = new SlimefunItemStack(
        "MACERATOR",
        Material.IRON_BLOCK,
        "&7粉碎机",
        "",
        "&7可以粉碎很多东西",
        ""
    );
    //// Solar panels
    public static final SlimefunItemStack ADVANCED_SOLAR_PANEL = new SlimefunItemStack(
        "ADVANCED_SOLAR_PANEL",
        Material.BLACK_GLAZED_TERRACOTTA,
        "&7&l高级太阳能板",
        "&9可在夜间工作",
        "",
        LoreBuilderDynamic.powerBuffer(AdvancedSolarPanel.ADVANCED_STORAGE),
        LoreBuilderDynamic.powerPerTick(AdvancedSolarPanel.ADVANCED_DAY_RATE) + " (日间)",
        LoreBuilderDynamic.powerPerTick(AdvancedSolarPanel.ADVANCED_NIGHT_RATE) + " (夜间)"
    );
    public static final SlimefunItemStack HYBRID_SOLAR_PANEL = new SlimefunItemStack(
        "HYBRID_SOLAR_PANEL",
        Material.GRAY_GLAZED_TERRACOTTA,
        "&b&l混合太阳能板",
        "&9可以在夜间及其他世界工作",
        "",
        LoreBuilderDynamic.powerBuffer(AdvancedSolarPanel.HYBRID_STORAGE),
        LoreBuilderDynamic.powerPerTick(AdvancedSolarPanel.HYBRID_DAY_RATE) + " (日间 + 下界)",
        LoreBuilderDynamic.powerPerTick(AdvancedSolarPanel.HYBRID_NIGHT_RATE) + " (夜间 + 末地)"
    );
    public static final SlimefunItemStack ULTIMATE_SOLAR_PANEL = new SlimefunItemStack(
        "ULTIMATE_SOLAR_PANEL",
        Material.PURPLE_GLAZED_TERRACOTTA,
        "&5&l终极太阳能板",
        "&9可以在夜间工作",
        "",
        LoreBuilderDynamic.powerBuffer(AdvancedSolarPanel.ULTIMATE_STORAGE),
        LoreBuilderDynamic.powerPerTick(AdvancedSolarPanel.ULTIMATE_DAY_RATE) + " (日间)",
        LoreBuilderDynamic.powerPerTick(AdvancedSolarPanel.ULTIMATE_NIGHT_RATE) + " (夜间)"
    );
    public static final SlimefunItemStack MULTI_FUNCTIONAL_ELECTRIC_STORAGE_UNIT = new SlimefunItemStack(
        "MULTI_FUNCTIONAL_ELECTRIC_STORAGE_UNIT",
        Material.IRON_BLOCK,
        "&7多功能电子储存单元(MFE)"
    );
    public static final SlimefunItemStack MULTI_FUNCTIONAL_STORAGE_UNIT = new SlimefunItemStack(
        "MULTI_FUNCTIONAL_STORAGE_UNIT",
        Material.DIAMOND_BLOCK,
        "&7多功能储存单元(MFSU)"
    );
    public static final SlimefunItemStack GOLD_PLATE = new SlimefunItemStack(
        "GOLD_PLATE",
        Material.YELLOW_CARPET,
        "&7金板"
    );
    public static final SlimefunItemStack GOLD_ITEM_CASING = new SlimefunItemStack(
        "GOLD_ITEM_CASING",
        Material.YELLOW_CARPET,
        "&7金制外壳"
    );
    public static final SlimefunItemStack UNINSULATED_GOLD_CABLE = new SlimefunItemStack(
        "UNINSULATED_GOLD_CABLE",
        Material.STRING,
        "&7金质导线"
    );
    public static final SlimefunItemStack GOLD_CABLE = new SlimefunItemStack(
        "GOLD_CABLE",
        Material.STRING,
        "&7绝缘金质导线"
    );
    //Basic Machines
    public static final SlimefunItemStack REFINED_SMELTERY = new SlimefunItemStack(
        "REFINED_SMELTERY",
        Material.BLAST_FURNACE,
        "&7精炼炉"
    );

    public static final SlimefunItemStack METAL_FORGE = new SlimefunItemStack(
        "METAL_FORGE",
        Material.DISPENSER,
        "&7金属冶炼炉"
    );

    public static final SlimefunItemStack MANUAL_MILL = new SlimefunItemStack(
        "MANUAL_MILL",
        Material.DISPENSER,
        "&7手摇式磨具"
    );

    public static final SlimefunItemStack GENERATOR = new SlimefunItemStack(
        "GENERATOR",
        Material.IRON_BLOCK,
        "&7发电机"
    );

    public static final SlimefunItemStack RE_BATTERY = new SlimefunItemStack(
        "RE_BATTERY",
        Material.GLASS_BOTTLE,
        "&7可充电电池"
    );

    public static final SlimefunItemStack ADVANCED_SOLAR_HELMET = new SlimefunItemStack(
        "ADVANCED_SOLAR_HELMET",
        Material.IRON_HELMET,
        "&7高级太阳能头盔"
    );

    public static final SlimefunItemStack CARBONADO_SOLAR_HELMET = new SlimefunItemStack(
        "CARBONADO_SOLAR_HELMET",
        Material.GOLDEN_HELMET,
        "&7黑金刚石太阳能头盔"
    );

    public static final SlimefunItemStack ENERGIZED_SOLAR_HELMET = new SlimefunItemStack(
        "ENERGIZED_SOLAR_HELMET",
        Material.GOLDEN_HELMET,
        "&7充能太阳能头盔"
    );

    public static final SlimefunItemStack ADVANCEDLX_SOLAR_HELMET = new SlimefunItemStack(
        "ADVANCEDLX_SOLAR_HELMET",
        Material.DIAMOND_HELMET,
        "&7超级太阳能头盔"
    );

    public static final SlimefunItemStack HYBRID_SOLAR_HELMET = new SlimefunItemStack(
        "HYBRID_SOLAR_HELMET",
        Material.DIAMOND_HELMET,
        "&7混合太阳能头盔"
    );

    public static final SlimefunItemStack ULTIMATE_SOLAR_HELMET = new SlimefunItemStack(
        "ULTIMATE_SOLAR_HELMET",
        Material.DIAMOND_HELMET,
        "&7终极太阳能头盔"
    );

    public static final SlimefunItemStack FOOD_SYNTHESIZER = new SlimefunItemStack(
        "FOOD_SYNTHESIZER",
        new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "a967efe969d264f635f2c201c34381ef59c72e16ec50af7692033121e22fba9c")),
            "食物合成器"),
        "&d食物合成器",
        "",
        "&f用合成的食物填饱你的肚子.",
        "&f还有多种口味!",
        "",
        "&c&o&8\u21E8 &e\u26A1 &70 / 100 J"
    );

    //////////////////////////
    // Plating
    //////////////////////////
    public static final SlimefunItemStack IRON_PLATE = new SlimefunItemStack(
        "IRON_PLATE",
        Material.WHITE_CARPET,
        "&7铁板"
    );

    public static final SlimefunItemStack DIAMOND_PLATE = new SlimefunItemStack(
        "DIAMOND_PLATE",
        Material.CYAN_CARPET,
        "&7钻石板"
    );
    public static final SlimefunItemStack THORIUM_PLATE = new SlimefunItemStack(
        "THORIUM_PLATE",
        Material.GRAY_CARPET,
        "&7钍板"
    );

    public static final SlimefunItemStack POWER_UNIT = new SlimefunItemStack(
        "POWER_UNIT",
        Material.GOLDEN_HOE,
        "&7能量单元"
    );

    public static final SlimefunItemStack IRON_ITEM_CASING = new SlimefunItemStack(
        "IRON_ITEM_CASING",
        Material.GRAY_CARPET,
        "&7铁质外壳"
    );

    //////////////////////////
    // Dust
    //////////////////////////
    public static final SlimefunItemStack LAPIS_DUST = new SlimefunItemStack(
        "LAPIS_DUST",
        Material.PURPLE_DYE,
        "&7青金石粉"
    );

    public static final SlimefunItemStack REDSTONE_DUST = new SlimefunItemStack(
        "REDSTONE_DUST",
        Material.RED_DYE,
        "&7红石粉"
    );

    public static final SlimefunItemStack DIAMOND_DUST = new SlimefunItemStack(
        "DIAMOND_DUST",
        Material.CYAN_DYE,
        "&7钻石粉"
    );
    public static final SlimefunItemStack EMERALD_DUST = new SlimefunItemStack(
        "EMERALD_DUST",
        Material.LIME_DYE,
        "&7绿宝石粉"
    );
    public static final SlimefunItemStack QUARTZ_DUST = new SlimefunItemStack(
        "QUARTZ_DUST",
        Material.WHITE_DYE,
        "&7石英粉"
    );
    public static final SlimefunItemStack ANCIENT_DEBRIS_DUST = new SlimefunItemStack(
        "ANCIENT_DEBRIS_DUST",
        Material.BROWN_DYE,
        "&7远古残骸粉"
    );

    public static final SlimefunItemStack UU_CRAFTER = new SlimefunItemStack(
        "UU_CRAFTER",
        Material.CRAFTING_TABLE,
        "&7UU合成机"
    );

    public static final SlimefunItemStack CONVERTER = new SlimefunItemStack(
        "CONVER",
        Material.COAL_BLOCK,
        "&7转换机"
    );


    static {
        ADVANCED_SOLAR_HELMET.addEnchantment(Enchantment.DURABILITY, 1);
        CARBONADO_SOLAR_HELMET.addEnchantment(Enchantment.DURABILITY, 2);
        ENERGIZED_SOLAR_HELMET.addEnchantment(Enchantment.DURABILITY, 3);
        ADVANCEDLX_SOLAR_HELMET.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
        HYBRID_SOLAR_HELMET.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        ULTIMATE_SOLAR_HELMET.addUnsafeEnchantment(Enchantment.DURABILITY, 6);

    }

    private Items() {}
}
