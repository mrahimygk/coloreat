package ir.mrahimy.circledots.gameobjects

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Circle
import ir.mrahimy.circledots.manage.Assets

class LineSprite(val bounds: Circle, private val color:Color=Color.BLUE) {
    private val lineSprite = Sprite(Assets().lineTexture())

    init {
        lineSprite.setOriginCenter()
        lineSprite.setPosition(
                bounds.x - lineSprite.texture.width / 2,
                bounds.y - lineSprite.texture.height / 2)

        lineSprite.color = Color.WHITE.cpy().lerp(color, .5f)
    }

    fun render(batch: SpriteBatch, deltaTime: Float) {
        val s = 1f / ((lineSprite.texture.width / 2) / bounds.radius)
        lineSprite.setScale(s)
        lineSprite.setScale(s)
        lineSprite.setScale(s)

        batch.begin()
        lineSprite.draw(batch)
        batch.end()
    }
}