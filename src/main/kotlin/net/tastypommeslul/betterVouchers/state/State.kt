package net.tastypommeslul.betterVouchers.state

import net.tastypommeslul.betterVouchers.items.BingVoucher
import net.tastypommeslul.betterVouchers.items.TestVoucher
import org.bukkit.inventory.ItemStack

object State {
  var itemList: List<ItemStack> = listOf(
    TestVoucher.register(),
    BingVoucher.register()
  )
}