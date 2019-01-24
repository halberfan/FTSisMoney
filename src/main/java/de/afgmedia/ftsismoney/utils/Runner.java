package de.afgmedia.ftsismoney.utils;

import de.afgmedia.ftsismoney.econ.Account;
import de.afgmedia.ftsismoney.econ.PlayerAccount;
import de.afgmedia.ftsismoney.main.FTS;
import org.bukkit.Bukkit;

public class Runner implements Runnable {

    private FTS plugin;

    public Runner(FTS plugin) {
        this.plugin = plugin;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, this, 20, 20);
    }

    @Override
    public void run() {
        for (Account acc : plugin.getAccounts().values()) {
            if (acc instanceof PlayerAccount) {
                if(!Bukkit.getPlayer(acc.getName()).isDead())
                    ((PlayerAccount) acc).updateBalance();
            }
        }
    }
}
