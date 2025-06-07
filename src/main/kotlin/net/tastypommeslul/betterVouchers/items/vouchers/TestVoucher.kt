package net.tastypommeslul.betterVouchers.items.vouchers

import io.papermc.paper.datacomponent.DataComponentTypes
import io.papermc.paper.datacomponent.item.ItemEnchantments
import net.kyori.adventure.text.Component.*
import net.tastypommeslul.betterVouchers.items.vouchers.utils.Voucher
import net.tastypommeslul.betterVouchers.items.vouchers.utils.VoucherLevel
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object TestVoucher : Voucher() {
  override val item: ItemStack = ItemStack(Material.ECHO_SHARD, 1)
  override val voucherLevel: VoucherLevel = VoucherLevel.STANDARD

  override fun register(): ItemStack {
    item.lore(listOf(
      text("Test voucher"),
      text("Increases Wanted Enchant by ${voucherLevel.getLvl()}"),
    ))

    item.setData(DataComponentTypes.CUSTOM_NAME) {
      text("§6§lTest Voucher")
    }

    item.setData(DataComponentTypes.MAX_STACK_SIZE) {
      16
    }
    item.setData(DataComponentTypes.ENCHANTMENTS) {
      ItemEnchantments.itemEnchantments().add(Enchantment.KNOCKBACK, 2).add(Enchantment.EFFICIENCY, 5).build()
    }

    return item
  }
}