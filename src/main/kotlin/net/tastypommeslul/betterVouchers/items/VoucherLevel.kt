package net.tastypommeslul.betterVouchers.items

enum class VoucherLevel {

  BASIC(2),
  STANDARD(5),
  ULTIMATE(10);

  private var enchantInc: Int = 0;
  constructor(level: Int) {
    this.enchantInc = level
  }

  companion object {
    fun getLvl(lvl: VoucherLevel): Int = lvl.enchantInc
  }
}
