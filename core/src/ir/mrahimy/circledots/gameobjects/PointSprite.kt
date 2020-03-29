package ir.mrahimy.circledots.gameobjects

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.Intersector
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import ir.mrahimy.circledots.manage.Assets

class PointSprite(val bounds: Circle, color: Color = Color.RED, private val isCenter: Boolean = false) {
    private val pointSprite = Sprite(Assets().pointTexture())
    private val inactiveColor = color

    init {
        update()
        pointSprite.color = inactiveColor
    }

    var color: Color = color
        set(value) {
            field = value
            pointSprite.color = field
        }

    fun render(batch: SpriteBatch, deltaTime: Float) {
        update()
        val s = 1f / ((pointSprite.texture.width / 2) / bounds.radius)
        pointSprite.setScale(s)
        pointSprite.setScale(s)
        pointSprite.setScale(s)

        batch.begin()
        pointSprite.draw(batch)
        batch.end()
    }

    private fun update() {
        pointSprite.setOriginCenter()
        pointSprite.setPosition(
                bounds.x - pointSprite.texture.width / 2,
                bounds.y - pointSprite.texture.height / 2)

    }

    fun updateStatus(points: List<Vector2>) {
        if (!isCenter) return
        if (Intersector.isPointInTriangle(Vector2(bounds.x, bounds.y),
                        points[0], points[1], points[2])) {
            color = Color.GREEN//.cpy().lerp(color, .5f)
        } else {
            color = inactiveColor
        }
    }
}