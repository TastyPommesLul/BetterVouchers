package net.tastypommeslul.betterVouchers.commands

import net.tastypommeslul.betterVouchers.BetterVouchers
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import org.bukkit.util.StringUtil

class SetApplicableCommand(val plugin: BetterVouchers) : TabExecutor {

  override fun onCommand(
    sender: CommandSender,
    command: Command,
    label: String,
    args: Array<out String>
  ): Boolean {
    if (sender !is Player) return false
    val player: Player = sender


    if (args.size == 1) {
      val arg = args[0]
      when (arg) {
        "true" -> {
          val hand = player.inventory.itemInMainHand
          if (hand == ItemStack(Material.AIR)) {
            sender.sendMessage("You must be holding an item to set its applicability")
            return true
          }
          hand.itemMeta = hand.itemMeta.apply {
            persistentDataContainer.set(NamespacedKey(plugin, "is_applicable"), PersistentDataType.BOOLEAN, true)
          }
          player.inventory.setItemInMainHand(hand)
        }
        "false" -> {
          val hand = player.inventory.itemInMainHand
          if (hand == ItemStack(Material.AIR)) {
            sender.sendMessage("You must be holding an item to set its applicability")
            return true
          }
          hand.itemMeta = hand.itemMeta.apply {
            persistentDataContainer.set(NamespacedKey(plugin, "is_applicable"), PersistentDataType.BOOLEAN, false)
          }
          player.inventory.setItemInMainHand(hand)
        }
        else -> {
          sender.sendMessage("Invalid argument: $arg")
        }
      }
    }

    return args.isNotEmpty()
  }


  override fun onTabComplete(
    sender: CommandSender,
    command: Command,
    label: String,
    args: Array<out String>
  ): List<String?>? {

    val validArgs = mutableListOf<String>()
    if (args.size == 1) {
      StringUtil.copyPartialMatches(args[0], listOf("true", "false"), validArgs)
      return validArgs
    }

    return listOf()
  }

}