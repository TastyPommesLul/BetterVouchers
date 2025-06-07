package net.tastypommeslul.betterVouchers.inventories

import net.kyori.adventure.text.Component.text
import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

class EnchantSelect(size: Int = 54) : InventoryHolder {
  private val inventory: Inventory

  init {
    this.inventory = Bukkit.createInventory(this, size, text("Select an Enchantment"))
  }

  override fun getInventory(): Inventory {
    return inventory
  }
}