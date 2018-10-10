package de.afgmedia.ftsismoney.econ;

import de.afgmedia.ftsismoney.main.FTS;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerAccount extends Account {

    private Player player;
    private String name;
    private FTS plugin;

    public PlayerAccount(Player player, FTS plugin) {
        this.player = player;
        this.name = player.getName();
        this.plugin = plugin;
    }

    private double balance = 0;

    public void updateBalance() {
        balance = getInvBalance(player.getInventory());
    }

    @Override
    public EconomyResponse deposit(double v) {
        return super.deposit(v);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public EconomyResponse withdraw(double v) {
        return super.withdraw(v);
    }

    @Override
    public boolean has(double v) {
        return super.has(v);
    }

}
