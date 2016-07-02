package com.herocc.bukkit.syntaxblocker;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SyntaxBlocker extends JavaPlugin implements Listener {

  public void onEnable() { getServer().getPluginManager().registerEvents(this, this); }

  @EventHandler
  public void onCommand(PlayerCommandPreprocessEvent e) {
    if (e.getMessage().split(" ")[0].contains(":") && !(e.getPlayer().hasPermission("syntaxblocker.bypass"))) {
      e.setCancelled(true);
      e.getPlayer().sendMessage(ChatColor.RED + "Sorry, you don't have permission to use syntax from other plugins");
    }
  }
}
