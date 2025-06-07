package net.tastypommeslul.betterVouchers.listeners

import io.papermc.paper.datacomponent.DataComponentTypes
import io.papermc.paper.datacomponent.item.ItemEnchantments
import net.tastypommeslul.betterVouchers.BetterVouchers
import net.tastypommeslul.betterVouchers.inventories.AllVouchers
import net.tastypommeslul.betterVouchers.items.vouchers.TestVoucher
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import org.bukkit.plugin.java.JavaPlugin

class InventoryListener : Listener {

  @EventHandler
  fun onInventoryClick(event: InventoryClickEvent) {
    val player: Player = event.whoClicked as Player

//    println(event.currentItem?.enchantments?.keys.toString())

    if (event.clickedInventory?.holder is AllVouchers || event.clickedInventory == AllVouchers().inventory) {
      player.inventory.addItem(event.currentItem ?: ItemStack(Material.AIR))
      event.isCancelled = true
      if (event.currentItem?.enchantments!!.isEmpty()) return
      val item = ItemStack(Material.ENCHANTED_BOOK)
      val enchMap: MutableMap<Enchantment, Int> = mutableMapOf()

      event.currentItem?.enchantments?.forEach { (enchantment, level) ->
        enchMap.put(enchantment, level + TestVoucher.voucherLevel.getLvl())
      }

      item.setData(DataComponentTypes.STORED_ENCHANTMENTS) {
        ItemEnchantments.itemEnchantments().addAll(enchMap).build()
      }
      item.itemMeta = item.itemMeta.apply {
        persistentDataContainer.set(NamespacedKey(JavaPlugin.getPlugin(BetterVouchers::class.java), "is_applicable"),
          PersistentDataType.BOOLEAN, true)
      }
      println(item.itemMeta.persistentDataContainer.get(NamespacedKey(JavaPlugin.getPlugin(BetterVouchers::class.java), "is_applicable"),
        PersistentDataType.BOOLEAN))
      player.inventory.addItem(item)
      return
    }
  }

  fun applyEnchant(event: InventoryClickEvent, item: ItemStack): ItemStack {



    return item
  }
}

// x = Enchant
// V = Vanilla
// C = CrazyEnchants
// I = Item
/*
 [ ] [ ] [ ] [ ] [I] [ ] [ ] [ ] [ ]
 [V] [x] [x] [x] [x] [x] [x] [x] [x]
 [x] [x] [x] [x] [x] [x] [x] [x] [x]
 [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
 [C] [x] [x] [x] [x] [x] [x] [x] [x]
 [x] [x] [x] [x] [x] [x] [x] [x] [x]
*/