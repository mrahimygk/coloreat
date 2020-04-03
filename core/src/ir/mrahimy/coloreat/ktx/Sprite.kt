package ir.mrahimy.coloreat.ktx

import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Circle

fun Sprite.scale(bounds: Circle) {
    val s = 1f / ((texture.width / 2) / bounds.radius)
    setScale(s)
    setScale(s)
    setScale(s)
}