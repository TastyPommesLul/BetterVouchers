package net.tastypommeslul.betterVouchers.commands

import net.tastypommeslul.betterVouchers.inventories.AllVouchers
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player

class AllVouchersCommand() : TabExecutor {
  override fun onCommand(
    sender: CommandSender,
    command: Command,
    commandLabel: String,
    args: Array<out String>
  ): Boolean {
    if (sender !is Player) return false
    val player: Player = sender

    player.openInventory(AllVouchers().inventory)

    return true
  }

  override fun onTabComplete(
    sender: CommandSender,
    command: Command,
    label: String,
    args: Array<out String>
  ): List<String?>? {
    return listOf()
  }
}