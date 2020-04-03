package ir.mrahimy.coloreat.gameobjects

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Circle
import ir.mrahimy.coloreat.ktx.scale
import ir.mrahimy.coloreat.manage.Assets

class CircleSprite(val bounds: Circle, color: Color = Color.WHITE) {
    private val circleSprite = Sprite(Assets().circleTexture().apply { setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear) })
    private val pointSprite = Sprite(Assets().pointTexture())

    init {
        update()
        circleSprite.color = Color.BLACK
    }

    var color: Color = color
        set(value) {
            field = value
            pointSprite.color = field
        }

    fun update() {
        circleSprite.setOriginCenter()
        circleSprite.setPosition(
                bounds.x - circleSprite.texture.width / 2,
                bounds.y - circleSprite.texture.height / 2)

        pointSprite.setOriginCenter()
        pointSprite.setPosition(
                bounds.x - pointSprite.texture.width / 2,
                bounds.y - pointSprite.texture.height / 2)
    }

    fun render(batch: SpriteBatch, deltaTime: Float) {
        update()
        pointSprite.scale(bounds)
        circleSprite.scale(bounds)

        batch.begin()
        pointSprite.draw(batch)
        circleSprite.draw(batch)
        batch.end()
    }
}