package ir.mrahimy.circledots.ktx

fun <T> List<T>.leftShift(d: Int): List<T> {
    val newList = MutableList(this.size) { i -> this.elementAt(i) }
    var shift = d
    if (shift > size) shift %= size
    forEachIndexed { index, value ->
        val newIndex = (index + (size - shift)) % size
        newList[newIndex] = value
    }
    return newList
}