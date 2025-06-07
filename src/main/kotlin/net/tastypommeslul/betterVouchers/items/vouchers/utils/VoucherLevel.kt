package net.tastypommeslul.betterVouchers.items.vouchers.utils

enum class VoucherLevel(level: Int) {

  BASIC(2),
  STANDARD(5),
  ULTIMATE(10);

  private var enchantInc: Int = level

  fun getLvl(): Int = this.enchantInc
}
