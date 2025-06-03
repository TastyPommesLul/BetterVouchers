package net.tastypommeslul.betterVouchers.commands

import net.tastypommeslul.betterVouchers.BetterVouchers
import net.tastypommeslul.betterVouchers.inventories.AllVouchers
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class AllVouchersCommand(name: String) : Command(name) {
  override fun execute(
    sender: CommandSender,
    commandLabel: String,
    args: Array<out String>
  ): Boolean {
    if (sender !is Player) return false
    val player: Player = sender

    player.openInventory(AllVouchers(JavaPlugin.getPlugin(BetterVouchers::class.java)).inventory)


    return true
  }
}