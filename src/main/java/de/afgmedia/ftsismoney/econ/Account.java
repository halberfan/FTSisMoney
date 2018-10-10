package de.afgmedia.ftsismoney.econ;

import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class Account {

    public abstract String getName();

    public abstract double getBalance();

    public abstract void setBalance(double balance);

    public EconomyResponse withdraw(double v) {
        if (getBalance() >= v) {
            setBalance(getBalance() - v);
            if (this instanceof PlayerAccount)
                updateInventory(Bukkit.getPlayer(getName()).getInventory());
            return new EconomyResponse(v, getBalance(), EconomyResponse.ResponseType.SUCCESS, "Done");
        } else
            return new EconomyResponse(v, getBalance(), EconomyResponse.ResponseType.FAILURE, "Not enough money");
    }

    public EconomyResponse deposit(double v) {
        setBalance(getBalance() + v);
        if (this instanceof PlayerAccount)
            updateInventory(Bukkit.getPlayer(getName()).getInventory());
        return new EconomyResponse(v, getBalance(), EconomyResponse.ResponseType.SUCCESS, "Done");
    }

    public boolean has(double v) {
        return getBalance() >= v;
    }

    long getInvBalance(Inventory inv) {

        ItemStack[] content = inv.getContents();

        long b = 0;

        for (ItemStack all : content) {
            if (all == null)
                continue;
            if (all.getType() == Material.AIR)
                continue;
            if (all.getType() == Material.GOLD_NUGGET) {
                b += all.getAmount();
            } else if (all.getType() == Material.GOLD_INGOT) {
                b += all.getAmount() * 9;
            } else if (all.getType() == Material.GOLD_BLOCK) {
                b += all.getAmount() * 9 * 9;
            }
        }

        return b;

    }

    public void updateInventory(Inventory inv) {

        double invb = getInvBalance(inv);
        //Clear Current Gold
        for (ItemStack all : inv.getContents()) {
            if (all == null)
                continue;
            if (all.getType() == Material.AIR)
                continue;
            if (all.getType() == Material.GOLD_BLOCK)
                all.setAmount(0);
            if (all.getType() == Material.GOLD_INGOT)
                all.setAmount(0);
            if (all.getType() == Material.GOLD_NUGGET)
                all.setAmount(0);
        }

        double diff = getBalance();
        int goldblock = 0;
        int goldingot = 0;
        int goldnugget = 0;
        //Get Count
        while (diff >= 81) {
            diff -= 81;
            goldblock++;
        }
        while (diff >= 9) {
            diff -= 9;
            goldingot++;
        }
        while (diff >= 1) {
            diff--;
            goldnugget++;
        }

        //Get ItemStacks

        while (goldblock >= 64) {
            goldblock -= 64;
            ItemStack gb = new ItemStack(Material.GOLD_BLOCK, 64);
            inv.addItem(gb);
        }
        while (goldingot >= 64) {
            goldingot -= 64;
            ItemStack gi = new ItemStack(Material.GOLD_INGOT, 64);
            inv.addItem(gi);
        }
        while (goldnugget >= 64) {
            goldnugget -= 64;
            ItemStack gn = new ItemStack(Material.GOLD_NUGGET, 64);
            inv.addItem(gn);
        }
        ItemStack gb = new ItemStack(Material.GOLD_BLOCK, goldblock);
        inv.addItem(gb);
        ItemStack gi = new ItemStack(Material.GOLD_INGOT, goldingot);
        inv.addItem(gi);
        ItemStack gn = new ItemStack(Material.GOLD_NUGGET, goldnugget);
        inv.addItem(gn);


    }

}
