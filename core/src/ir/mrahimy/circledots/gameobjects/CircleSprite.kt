package ir.mrahimy.circledots.gameobjects

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Circle
import ir.mrahimy.circledots.manage.Assets

class CircleSprite(val bounds: Circle, private val color: Color = Color.BLUE) {
    private val circleSprite = Sprite(Assets().circleTexture())

    init {
        circleSprite.setOriginCenter()
        circleSprite.setPosition(
                bounds.x - circleSprite.texture.width / 2,
                bounds.y - circleSprite.texture.height / 2)

        circleSprite.color = Color.WHITE.cpy().lerp(color, .5f)
    }

    fun render(batch: SpriteBatch, deltaTime: Float) {
        val s = 1f / ((circleSprite.texture.width / 2) / bounds.radius)
        circleSprite.setScale(s)
        circleSprite.setScale(s)
        circleSprite.setScale(s)

        batch.begin()
        circleSprite.draw(batch)
        batch.end()
    }
}