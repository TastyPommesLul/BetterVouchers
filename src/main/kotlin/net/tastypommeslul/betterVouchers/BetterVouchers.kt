package net.tastypommeslul.betterVouchers

import net.tastypommeslul.betterVouchers.commands.AllVouchersCommand
import net.tastypommeslul.betterVouchers.commands.SetApplicableCommand
import net.tastypommeslul.betterVouchers.listeners.InventoryListener
import org.bukkit.plugin.java.JavaPlugin

class BetterVouchers : JavaPlugin() {

  override fun onEnable() {
    getCommand("vouchers")?.setExecutor(AllVouchersCommand())
    getCommand("setapplicable")?.setExecutor(SetApplicableCommand(this))
    server.pluginManager.registerEvents(InventoryListener(), this)
  }

  override fun onDisable() {

  }
}
