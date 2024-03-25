package dev.j3fftw.litexpansion;

import dev.j3fftw.litexpansion.resources.ThoriumResource;
import dev.j3fftw.litexpansion.service.MetricsService;
import dev.j3fftw.litexpansion.ticker.PassiveElectricRemovalTicker;
import dev.j3fftw.litexpansion.utils.Constants;
import dev.j3fftw.litexpansion.utils.Reflections;
import dev.j3fftw.litexpansion.uumatter.UUMatter;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import net.guizhanss.guizhanlibplugin.updater.GuizhanUpdater;
import org.bstats.MetricsBase;
import org.bstats.bukkit.Metrics;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.logging.Level;

public class LiteXpansion extends JavaPlugin implements SlimefunAddon {

    private static LiteXpansion instance;

    private final MetricsService metricsService = new MetricsService();

    @Override
    public void onEnable() {
        setInstance(this);

        if (!getServer().getPluginManager().isPluginEnabled("GuizhanLibPlugin")) {
            getLogger().log(Level.SEVERE, "本插件需要 鬼斩前置库插件(GuizhanLibPlugin) 才能运行!");
            getLogger().log(Level.SEVERE, "从此处下载: https://50l.cc/gzlib");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        if (!new File(getDataFolder(), "config.yml").exists()) {
            saveDefaultConfig();
        }

        final Metrics metrics = new Metrics(this, 7111);
        metricsService.setup(metrics);

        if (getConfig().getBoolean("options.auto-update") && getDescription().getVersion().startsWith("Build")) {
            GuizhanUpdater.start(this, getFile(), "SlimefunGuguProject", "LiteXpansion", "master");
        }


        if (getConfig().getBoolean("options.nerf-other-addons", true)) {
            getServer().getScheduler().runTask(this, this::nerfCrap);
        }

        ItemSetup.INSTANCE.init();

        getServer().getPluginManager().registerEvents(new Events(), this);

        UUMatter.INSTANCE.register();

        setupResearches();
        new ThoriumResource().register();

        final PassiveElectricRemovalTicker perTicker = new PassiveElectricRemovalTicker();
        getServer().getScheduler().runTaskTimerAsynchronously(this, perTicker, 20, 20);
    }

    @Override
    public void onDisable() {
        setInstance(null);
    }


    private void nerfCrap() {
        getLogger().log(Level.WARNING, "###########################################");
        getLogger().log(Level.WARNING, " LiteXpansion 已开启削弱其他附属的发电机效率 ");
        getLogger().log(Level.WARNING, " 你可以在 LiteXpansion 附属的配置文件中关闭削弱 ");
        getLogger().log(Level.WARNING, " 设置 options.nerf-other-addons 为 false ");
        getLogger().log(Level.WARNING, "###########################################");

        // Vanilla SF
        final SlimefunItem energizedPanel = SlimefunItem.getById("SOLAR_GENERATOR_4");
        if (energizedPanel != null) {
            Reflections.setField(energizedPanel, "dayEnergy", 128);
            Reflections.setField(energizedPanel, "nightEnergy", 64);
        }

        // InfinityExpansion - Halved all values and made infinite panel + infinity reactor much less
        Reflections.setField(SlimefunItem.getById("ADVANCED_PANEL"), "generation", 120);
        Reflections.setField(SlimefunItem.getById("CELESTIAL_PANEL"), "generation", 560);
        Reflections.setField(SlimefunItem.getById("VOID_PANEL"), "generation", 2_250);
        Reflections.setField(SlimefunItem.getById("INFINITE_PANEL"), "generation", 45_000);
        Reflections.setField(SlimefunItem.getById("INFINITY_REACTOR"), "gen", 90_000);

        // SlimefunWarfare - Halved all values
        Reflections.setField(SlimefunItem.getById("ELEMENTAL_REACTOR"), "energyProducedPerTick", 8_192);

        // Galactifun
        Reflections.setField(SlimefunItem.getById("FUSION_REACTOR"), "energyProducedPerTick", 16_384);

        // SupremeExpansion - just no...
        Reflections.setField(SlimefunItem.getById("SUPREME_SUPREME_GENERATOR"), "energy", 20_000);
        Reflections.setField(SlimefunItem.getById("SUPREME_THORNIUM_GENERATOR"), "energy", 10_000);
        Reflections.setField(SlimefunItem.getById("SUPREME_LUMIUM_GENERATOR"), "energy", 5_000);
        Reflections.setField(SlimefunItem.getById("SUPREME_BASIC_LUMIUM_GENERATOR"), "energy", 500);
        Reflections.setField(SlimefunItem.getById("SUPREME_LUX_GENERATOR"), "energy", 2_500);
        Reflections.setField(SlimefunItem.getById("SUPREME_BASIC_LUX_GENERATOR"), "energy", 250);
        Reflections.setField(SlimefunItem.getById("SUPREME_AQUA_GENERATOR"), "energy", 2_500);
        Reflections.setField(SlimefunItem.getById("SUPREME_BASIC_AQUA_GENERATOR"), "energy", 250);
        Reflections.setField(SlimefunItem.getById("SUPREME_VENUS_GENERATOR"), "energy", 2_500);
        Reflections.setField(SlimefunItem.getById("SUPREME_BASIC_VENUS_GENERATOR"), "energy", 250);
        Reflections.setField(SlimefunItem.getById("SUPREME_IGNIS_GENERATOR"), "energy", 2_500);
        Reflections.setField(SlimefunItem.getById("SUPREME_BASIC_IGNIS_GENERATOR"), "energy", 250);
    }

    private void setupResearches() {
        new Research(new NamespacedKey(this, "sanitizing_foots"),
            696969, "合成食物", 45)
            .addItems(Items.FOOD_SYNTHESIZER)
            .register();

        new Research(new NamespacedKey(this, "superalloys"),
            696970, "超级合金", 35)
            .addItems(Items.THORIUM, Items.MAG_THOR, Items.IRIDIUM, Items.ADVANCED_ALLOY, Items.MIXED_METAL_INGOT,
                Items.REFINED_IRON)
            .register();

        new Research(new NamespacedKey(this, "super_hot_fire"),
            696971, "热火朝天", 31)
            .addItems(Items.NANO_BLADE, Items.ELECTRIC_CHESTPLATE)
            .register();

        new Research(new NamespacedKey(this, "machinereee"),
            696972, "机器~~~~~~", 30)
            .addItems(Items.METAL_FORGE, Items.REFINED_SMELTERY, Items.RUBBER_SYNTHESIZER_MACHINE, Items.MANUAL_MILL,
                Items.GENERATOR)
            .register();

        new Research(new NamespacedKey(this, "the_better_panel"),
            696973, "更好的太阳能板", 45)
            .addItems(Items.ADVANCED_SOLAR_PANEL, Items.ULTIMATE_SOLAR_PANEL, Items.HYBRID_SOLAR_PANEL)
            .register();

        new Research(new NamespacedKey(this, "does_this_even_matter"),
            696974, "这物质真的重要吗", 150)
            .addItems(Items.UU_MATTER, Items.SCRAP, Items.MASS_FABRICATOR_MACHINE, Items.RECYCLER)
            .register();

        new Research(new NamespacedKey(this, "what_a_configuration"),
            696975, "配置器", 39)
            .addItems(Items.CARGO_CONFIGURATOR)
            .register();

        new Research(new NamespacedKey(this, "platings"),
            696976, "板", 40)
            .addItems(Items.IRIDIUM_PLATE, Items.COPPER_PLATE, Items.TIN_PLATE, Items.DIAMOND_PLATE, Items.IRON_PLATE,
                Items.GOLD_PLATE, Items.THORIUM_PLATE)
            .register();

        new Research(new NamespacedKey(this, "rubber"),
            696977, "橡胶", 25)
            .addItems(Items.RUBBER)
            .register();

        new Research(new NamespacedKey(this, "circuits"),
            696978, "电路", 25)
            .addItems(Items.ELECTRONIC_CIRCUIT, Items.ADVANCED_CIRCUIT)
            .register();

        new Research(new NamespacedKey(this, "reinforcement_is_coming"),
            696979, "强化降临", 15)
            .addItems(Items.REINFORCED_DOOR, Items.REINFORCED_GLASS, Items.REINFORCED_STONE)
            .register();

        new Research(new NamespacedKey(this, "only_glass"),
            696980, "只有玻璃", 40)
            .addItems(Items.GLASS_CUTTER)
            .register();

        new Research(new NamespacedKey(this, "machine_blocks"),
            696981, "机器方块", 35)
            .addItems(Items.MACHINE_BLOCK, Items.ADVANCED_MACHINE_BLOCK)
            .register();

        new Research(new NamespacedKey(this, "coal_mesh"),
            696982, "碳网", 30)
            .addItems(Items.COAL_DUST, Items.RAW_CARBON_MESH, Items.RAW_CARBON_FIBRE, Items.CARBON_PLATE)
            .register();

        new Research(new NamespacedKey(this, "what_are_these_cables"),
            696983, "这些是什么导线?", 25)
            .addItems(Items.UNINSULATED_COPPER_CABLE, Items.COPPER_CABLE,
                    Items.UNINSULATED_TIN_CABLE, Items.TIN_CABLE,
                    Items.UNINSULATED_GOLD_CABLE, Items.GOLD_CABLE)
            .register();

        new Research(new NamespacedKey(this, "triple_a"),
            696984, "3A", 20)
            .addItems(Items.RE_BATTERY)
            .register();

        new Research(new NamespacedKey(this, "casing"),
            696985, "S 340", 20)
            .addItems(Items.TIN_ITEM_CASING, Items.COPPER_ITEM_CASING)
            .register();

        new Research(new NamespacedKey(this, "solar_helmets"),
            696986, "更多的太阳能头盔", 30)
            .addItems(Items.HYBRID_SOLAR_HELMET, Items.ADVANCED_SOLAR_HELMET, Items.ADVANCEDLX_SOLAR_HELMET,
                Items.CARBONADO_SOLAR_HELMET, Items.ENERGIZED_SOLAR_HELMET, Items.ULTIMATE_SOLAR_HELMET)
            .register();
    }

    private void forceMetricsPush(@Nonnull Metrics metrics) {
        MetricsBase base = (MetricsBase) Reflections.getField(Metrics.class, metrics, "metricsBase");
        Reflections.invoke(MetricsBase.class, base, "submitData");
    }

    @Nonnull
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    public String getBugTrackerURL() {
        return "https://github.com/SlimefunGuguProject/LiteXpansion/issues";
    }

    public static LiteXpansion getInstance() {
        return instance;
    }

    private static void setInstance(LiteXpansion ins) {
        instance = ins;
    }
}
