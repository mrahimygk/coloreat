package ir.mrahimy.coloreat.gameobjects

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.Intersector
import com.badlogic.gdx.math.Vector2
import ir.mrahimy.coloreat.ktx.scale
import ir.mrahimy.coloreat.manage.Assets

class PointSprite(val bounds: Circle, color: Color = Color.RED) {
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
        pointSprite.scale(bounds)

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
        color = if (Intersector.isPointInTriangle(Vector2(bounds.x, bounds.y),
                        points[0], points[1], points[2])) {
            Color.GREEN//.cpy().lerp(color, .5f)
        } else {
            inactiveColor
        }
    }
}