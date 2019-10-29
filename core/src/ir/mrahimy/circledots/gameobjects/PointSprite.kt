package ir.mrahimy.circledots.gameobjects

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Circle
import ir.mrahimy.circledots.manage.Assets

class PointSprite(private val bounds: Circle, private val color: Color = Color.RED) {
    private val pointSprite = Sprite(Assets().pointTexture())

    init {
        pointSprite.setOriginCenter()
        pointSprite.setPosition(
                bounds.x - pointSprite.texture.width / 2,
                bounds.y - pointSprite.texture.height / 2)

        pointSprite.color = Color.WHITE.cpy().lerp(color, .5f)
    }

    fun render(batch: SpriteBatch, deltaTime: Float) {
        val s = 1f / ((pointSprite.texture.width / 2) / bounds.radius)
        pointSprite.setScale(s)
        pointSprite.setScale(s)
        pointSprite.setScale(s)

        batch.begin()
        pointSprite.draw(batch)
        batch.end()
    }
}