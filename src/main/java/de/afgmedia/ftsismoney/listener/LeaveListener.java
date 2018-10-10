package de.afgmedia.ftsismoney.listener;

import de.afgmedia.ftsismoney.main.FTS;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {


    private FTS plugin;

    public LeaveListener(FTS plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        plugin.getAccounts().get(event.getPlayer().getName()).updateInventory(event.getPlayer().getInventory());
        plugin.getAccounts().remove(event.getPlayer().getName());

    }


}
