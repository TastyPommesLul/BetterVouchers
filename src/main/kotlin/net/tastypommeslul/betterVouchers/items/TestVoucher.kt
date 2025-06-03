package net.tastypommeslul.betterVouchers.items

import io.papermc.paper.datacomponent.DataComponentTypes
import net.kyori.adventure.text.Component.text
import net.tastypommeslul.betterVouchers.BetterVouchers
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import kotlin.jvm.java

object TestVoucher : BasicVoucher {
  override val plugin: JavaPlugin = JavaPlugin.getPlugin(BetterVouchers::class.java)
  override val item: ItemStack = ItemStack(Material.ECHO_SHARD, 1)
  override val voucherLevel: VoucherLevel = VoucherLevel.STANDARD

  override fun register(): ItemStack {
    item.lore(listOf(
      text("Test voucher"),
      text("Increases Wanted Enchant by ${VoucherLevel.getLvl(voucherLevel)}"),
    ))

    item.setData(DataComponentTypes.CUSTOM_NAME) {
      text("§6§lTest Voucher")
    }

    item.setData(DataComponentTypes.MAX_STACK_SIZE) {
      16
    }

    return item
  }
}