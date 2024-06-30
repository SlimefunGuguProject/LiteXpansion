package dev.j3fftw.litexpansion.service;

import dev.j3fftw.litexpansion.LiteXpansion;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.AdvancedPie;
import org.bstats.charts.SimplePie;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class MetricsService {
    public void setup(@Nonnull Metrics metrics) {
        // Setup charts
        setupCharts(metrics);
    }

    private void setupCharts(@Nonnull Metrics metrics) {
        metrics.addCustomChart(new AdvancedPie("blocks_placed", () -> {
            final Map<String, Integer> data = new HashMap<>();
            for (World world : Bukkit.getWorlds()) {
                final Map<Location, Config> rawStorage = getStorageForWorld(world);
                if (rawStorage == null) {
                    continue;
                }

                for (Map.Entry<Location, Config> entry : rawStorage.entrySet()) {
                    final SlimefunItem item = SlimefunItem.getById(entry.getValue().getString("id"));
                    if (item == null || !(item.getAddon() instanceof LiteXpansion)) {
                        continue;
                    }

                    data.merge(item.getId(), 1, Integer::sum);
                }
            }
            return data;
        }));

        metrics.addCustomChart(new SimplePie("nerf_addons", () ->
            LiteXpansion.getInstance().getConfig().getBoolean("options.nerf-other-addons", true) ? "true" : "false"));
    }

    @Nullable
    private Map<Location, Config> getStorageForWorld(@Nonnull World world) {
        return null;
    }
}
