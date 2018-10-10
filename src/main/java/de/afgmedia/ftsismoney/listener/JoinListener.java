package de.afgmedia.ftsismoney.listener;

import de.afgmedia.ftsismoney.main.FTS;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private FTS plugin;

    public JoinListener(FTS plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        plugin.addPlayerAccount(event.getPlayer());

    }

}
