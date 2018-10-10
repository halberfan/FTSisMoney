package de.afgmedia.ftsismoney.utils;

import de.afgmedia.ftsismoney.main.FTS;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;

public class VaultHook {

    private FTS plugin;

    public VaultHook(FTS plugin) {
        this.plugin = plugin;
    }

    private Economy provider;

    public void hook() {
        provider = plugin.getEconomyImplementer();
        Bukkit.getServicesManager().register(Economy.class, this.provider, this.plugin, ServicePriority.Normal);
        System.out.println("VaultAPI hooked into "+plugin.getName());
    }

    public void unhook() {
        Bukkit.getServicesManager().unregister(Economy.class, this.provider);
        System.out.println("VaultAPI unhooked from "+plugin.getName());
    }

}
