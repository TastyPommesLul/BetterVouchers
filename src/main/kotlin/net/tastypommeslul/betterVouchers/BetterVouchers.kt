package net.tastypommeslul.betterVouchers

import net.tastypommeslul.betterVouchers.commands.AllVouchersCommand
import net.tastypommeslul.betterVouchers.inventories.AllVouchers
import org.bukkit.plugin.java.JavaPlugin

class BetterVouchers : JavaPlugin() {

  override fun onEnable() {
    server.commandMap.register("bettervouchers", AllVouchersCommand("bettervouchers"))
    server.pluginManager.registerEvents(AllVouchers(this), this)
  }

  override fun onDisable() {

  }
}
