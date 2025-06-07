package net.tastypommeslul.betterVouchers.items.vouchers.utils

import net.tastypommeslul.betterVouchers.BetterVouchers
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

abstract class Voucher {
  val plugin: JavaPlugin = JavaPlugin.getPlugin(BetterVouchers::class.java)
  abstract val item: ItemStack
  abstract val voucherLevel: VoucherLevel

  abstract fun register(): ItemStack
}