package ir.mrahimy.coloreat.ktx

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas

fun SpriteBatch.drawLine(x1: Float, y1: Float, x2: Float, y2: Float, lineWidth: Float, lineTexture: TextureAtlas.AtlasRegion) {
    var xdif = x2 - x1
    var ydif = y2 - y1
    val l2 = xdif * xdif + ydif * ydif
    val invl = (1 / Math.sqrt(l2.toDouble())).toFloat()

    xdif *= invl * lineWidth
    ydif *= invl * lineWidth

    val floatBits = color.toFloatBits()

    val verts = floatArrayOf(x1 + ydif, y1 - xdif, floatBits, lineTexture.u, lineTexture.v, x1 - ydif, y1 + xdif, floatBits, lineTexture.u2, lineTexture.v, x2 - ydif, y2 + xdif, floatBits, lineTexture.u2, lineTexture.v2, x2 + ydif, y2 - xdif, floatBits, lineTexture.u, lineTexture.v2)
    draw(lineTexture.texture, verts, 0, 20)
}