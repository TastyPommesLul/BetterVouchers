package net.tastypommeslul.betterVouchers.items

import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

interface BasicVoucher {
  val plugin: JavaPlugin
  val item: ItemStack
  val voucherLevel: VoucherLevel

  fun register(): ItemStack
}