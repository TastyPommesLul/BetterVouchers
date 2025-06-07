package net.tastypommeslul.betterVouchers.inventories

import net.kyori.adventure.text.Component.*
import net.tastypommeslul.betterVouchers.state.State
import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

class AllVouchers(size: Int = 54) : InventoryHolder {
  private val inventory: Inventory

  init {
    this.inventory = Bukkit.createInventory(this, size, text("§l§5All Vouchers"))
    for (i in 0..State.itemList.size - 1) {
      inventory.setItem(i, State.itemList[i])
    }
  }

  override fun getInventory(): Inventory {
    return inventory
  }
}