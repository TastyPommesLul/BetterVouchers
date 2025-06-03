package net.tastypommeslul.betterVouchers.inventories

import net.tastypommeslul.betterVouchers.state.State
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.plugin.java.JavaPlugin

class AllVouchers : InventoryHolder, Listener {
  private val inventory: Inventory

  constructor(plugin: JavaPlugin, size: Int = 54) {
    this.inventory = Bukkit.createInventory(this, size, "§l§5All Vouchers")
    for (i in 0..State.itemList.size - 1) {
      inventory.setItem(i, State.itemList[i])
    }
  }

  override fun getInventory(): Inventory {
    return inventory
  }

  @EventHandler
  fun onInventoryClick(event: InventoryClickEvent) {
    val player: Player = event.whoClicked as Player
    if (event.clickedInventory != inventory) {
      event.isCancelled = false
    }
    if (event.clickedInventory?.holder !is AllVouchers) {
      event.isCancelled = false
      return
    }
    event.isCancelled = true
    player.inventory.addItem(event.currentItem!!)
  }
}