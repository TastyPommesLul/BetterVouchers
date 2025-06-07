package net.tastypommeslul.betterVouchers.state

import net.tastypommeslul.betterVouchers.items.vouchers.BingVoucher
import net.tastypommeslul.betterVouchers.items.vouchers.TestVoucher
import org.bukkit.inventory.ItemStack

object State {
  var itemList: List<ItemStack> = listOf(
    TestVoucher.register(),
    BingVoucher.register()
  )
}