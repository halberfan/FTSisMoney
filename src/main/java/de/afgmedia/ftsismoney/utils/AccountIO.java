package de.afgmedia.ftsismoney.utils;

import de.afgmedia.ftsismoney.econ.Account;
import de.afgmedia.ftsismoney.econ.BankAccount;
import de.afgmedia.ftsismoney.main.FTS;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class AccountIO {

    private File folder;
    private FTS plugin;

    public AccountIO(FTS plugin) {
        this.plugin = plugin;
        this.folder = new File(plugin.getDataFolder() + "//bankAccounts");
    }

    public void load() {
        try {
            for (File file : Objects.requireNonNull(folder.listFiles())) {
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                String name = cfg.getString("name");
                double bal = cfg.getDouble("balance");
                BankAccount acc = plugin.addBankAccount(name);
                acc.setBalance(bal);

            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    public void safe() {
        for(Account acc : plugin.getAccounts().values()) {
            if (acc instanceof BankAccount) {

                BankAccount a = (BankAccount) acc;

                File file = new File(folder+"//"+a.getName()+".yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                cfg.set("name", a.getName());
                cfg.set("balance", a.getBalance());

                try {
                    cfg.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
