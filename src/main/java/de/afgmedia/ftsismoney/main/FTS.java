package de.afgmedia.ftsismoney.main;

import de.afgmedia.ftsismoney.econ.Account;
import de.afgmedia.ftsismoney.econ.BankAccount;
import de.afgmedia.ftsismoney.econ.EconomyImplementer;
import de.afgmedia.ftsismoney.econ.PlayerAccount;
import de.afgmedia.ftsismoney.listener.JoinListener;
import de.afgmedia.ftsismoney.listener.LeaveListener;
import de.afgmedia.ftsismoney.utils.AccountIO;
import de.afgmedia.ftsismoney.utils.Runner;
import de.afgmedia.ftsismoney.utils.VaultHook;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class FTS extends JavaPlugin {

    private EconomyImplementer economyImplementer;
    private VaultHook vaultHook;

    private HashMap<String, Account> accounts;
    private Economy eco;

    private AccountIO accountIO;

    @Override
    public void onEnable() {
        super.onEnable();
        init();
    }

    private void init() {

        accounts = new HashMap<>();

        economyImplementer = new EconomyImplementer(this);
        vaultHook = new VaultHook(this);

        vaultHook.hook();

        new JoinListener(this);
        new LeaveListener(this);

        new Runner(this);

        getCommand("money").setExecutor(this);

        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        eco = rsp.getProvider();

        this.accountIO = new AccountIO(this);
        accountIO.load();

    }


    @Override
    public void onDisable() {
        accountIO.safe();
        vaultHook.unhook();
    }

    public EconomyImplementer getEconomyImplementer() {
        return economyImplementer;
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public void addPlayerAccount(Player p) {
        PlayerAccount acc = new PlayerAccount(p, this);
        accounts.put(p.getName(), acc);
    }

    public BankAccount addBankAccount(String name) {
        BankAccount acc = new BankAccount(name, this);
        accounts.put(name, acc);
        return acc;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("money")) {
            sender.sendMessage(eco.getBalance((Player) sender)+" Geld");
        }

        return false;

    }
}
