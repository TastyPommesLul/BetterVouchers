package net.tastypommeslul.betterVouchers.items.vouchers

import io.papermc.paper.datacomponent.DataComponentTypes
import net.kyori.adventure.text.Component.*
import net.tastypommeslul.betterVouchers.items.vouchers.utils.Voucher
import net.tastypommeslul.betterVouchers.items.vouchers.utils.VoucherLevel
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object BingVoucher : Voucher() {
  override val item: ItemStack = ItemStack(Material.AMETHYST_SHARD, 1)
  override val voucherLevel: VoucherLevel = VoucherLevel.ULTIMATE

  override fun register(): ItemStack {
    item.lore(listOf(
      text("Bing voucher"),
      text("Increases Wanted Enchant by ${voucherLevel.getLvl()}"),
    ))

    item.setData(DataComponentTypes.CUSTOM_NAME) {
      text("§6§lBing Voucher")
    }

    item.setData(DataComponentTypes.MAX_STACK_SIZE) {
      16
    }

    return item
  }
}