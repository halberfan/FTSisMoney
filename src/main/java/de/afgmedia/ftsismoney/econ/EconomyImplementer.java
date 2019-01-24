package de.afgmedia.ftsismoney.econ;

import de.afgmedia.ftsismoney.main.FTS;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EconomyImplementer implements Economy {

    private FTS plugin;

    public EconomyImplementer(FTS plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean isEnabled() {
        return plugin.isEnabled();
    }

    @Override
    public String getName() {
        return plugin.getName();
    }

    @Override
    public boolean hasBankSupport() {
        return true;
    }

    @Override
    public int fractionalDigits() {
        return 0;
    }

    @Override
    public String format(double v) {
        return v+" Taler";
    }

    @Override
    public String currencyNamePlural() {
        return null;
    }

    @Override
    public String currencyNameSingular() {
        return null;
    }

    @Override
    public boolean hasAccount(String s) {
        return plugin.getAccounts().containsKey(s);
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer) {
        if(offlinePlayer == null) {
            Logger.getLogger("Minecraft").log(Level.WARNING, "OfflinePlayer is null (EconomyImplementer:63 #hasAccount)");
        }
        return plugin.getAccounts().containsKey(offlinePlayer.getName());
    }

    @Override
    public boolean hasAccount(String s, String s1) {
        return plugin.getAccounts().containsKey(s);
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer, String s) {
        return plugin.getAccounts().containsKey(offlinePlayer.getName());
    }

    @Override
    public double getBalance(String s) {
        return plugin.getAccounts().get(s).getBalance();
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer) {

        return plugin.getAccounts().get(offlinePlayer.getName()).getBalance();
    }

    @Override
    public double getBalance(String s, String s1) {
        return plugin.getAccounts().get(s).getBalance();
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer, String s) {
        return plugin.getAccounts().get(offlinePlayer.getName()).getBalance();
    }

    @Override
    public boolean has(String s, double v) {
        return plugin.getAccounts().get(s).has(v);
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, double v) {
        return plugin.getAccounts().get(offlinePlayer.getName()).has(v);
    }

    @Override
    public boolean has(String s, String s1, double v) {
        return plugin.getAccounts().get(s).has(v);
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, String s, double v) {
        return plugin.getAccounts().get(offlinePlayer.getName()).has(v);
    }

    @Override
    public EconomyResponse withdrawPlayer(String s, double v) {
        return plugin.getAccounts().get(s).withdraw(v);
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, double v) {
        return plugin.getAccounts().get(offlinePlayer.getName()).withdraw(v);
    }

    @Override
    public EconomyResponse withdrawPlayer(String s, String s1, double v) {
        return plugin.getAccounts().get(s).withdraw(v);
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, String s, double v) {
        return plugin.getAccounts().get(offlinePlayer.getName()).withdraw(v);
    }

    @Override
    public EconomyResponse depositPlayer(String s, double v) {
        return plugin.getAccounts().get(s).deposit(v);
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, double v) {
        return plugin.getAccounts().get(offlinePlayer.getName()).deposit(v);
    }

    @Override
    public EconomyResponse depositPlayer(String s, String s1, double v) {
        return plugin.getAccounts().get(s).deposit(v);
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, String s, double v) {
        return plugin.getAccounts().get(offlinePlayer.getName()).deposit(v);
    }

    @Override
    public EconomyResponse createBank(String s, String s1) {
        return null;
    }

    @Override
    public EconomyResponse createBank(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    @Override
    public EconomyResponse deleteBank(String s) {
        return null;
    }

    @Override
    public EconomyResponse bankBalance(String s) {
        return null;
    }

    @Override
    public EconomyResponse bankHas(String s, double v) {
        return null;
    }

    @Override
    public EconomyResponse bankWithdraw(String s, double v) {
        return null;
    }

    @Override
    public EconomyResponse bankDeposit(String s, double v) {
        return null;
    }

    @Override
    public EconomyResponse isBankOwner(String s, String s1) {
        return null;
    }

    @Override
    public EconomyResponse isBankOwner(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    @Override
    public EconomyResponse isBankMember(String s, String s1) {
        return null;
    }

    @Override
    public EconomyResponse isBankMember(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    @Override
    public List<String> getBanks() {
        return null;
    }

    @Override
    public boolean createPlayerAccount(String s) {
        plugin.addBankAccount(s);
        return true;
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer) {
        return false;
    }

    @Override
    public boolean createPlayerAccount(String s, String s1) {
        return false;
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer, String s) {
        return false;
    }
}
