package ir.mrahimy.coloreat.gameobjects

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Circle
import ir.mrahimy.coloreat.manage.Assets

class CircleSprite(val bounds: Circle, color: Color = Color.BLACK) {
    private val circleSprite = Sprite(Assets().circleTexture().apply { setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear) })

    init {
        update()
    }

    var color: Color = color
        set(value) {
            field = value
            circleSprite.color = field
        }

    fun update(){
        circleSprite.setOriginCenter()
        circleSprite.setPosition(
                bounds.x - circleSprite.texture.width / 2,
                bounds.y - circleSprite.texture.height / 2)
    }

    fun render(batch: SpriteBatch, deltaTime: Float) {
        update()
        val s = 1f / ((circleSprite.texture.width / 2) / bounds.radius)
        circleSprite.setScale(s)
        circleSprite.setScale(s)
        circleSprite.setScale(s)

        batch.begin()
        circleSprite.draw(batch)
        batch.end()
    }
}