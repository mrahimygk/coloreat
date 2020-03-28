package ir.mrahimy.circledots.system

import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import ir.mrahimy.circledots.gameobjects.PointSprite

class InputHandler(private val gameRenderer: GameRenderer, private val gameWorld: GameWorld) : InputProcessor {

    private val touchPos: Vector2 = Vector2()
    private var movingPoint: PointSprite? = null
    private val center = gameWorld.circleSprite.bounds

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        touchPos.set(screenX.toFloat(), screenY.toFloat())
        gameRenderer.viewport.unproject(touchPos)
        println(touchPos)

        movingPoint = gameWorld.points.firstOrNull { Circle(touchPos.x, touchPos.y, 15f).contains(it.bounds) }
                ?: return false
        movingPoint?.let { point ->
            movePointToAngle(point.bounds, findAngle(Vector2(point.bounds.x, point.bounds.y)))
        }
        return false
    }

    private fun movePointToAngle(point: Circle, angle: Float) {
        point.set(Circle(center.radius * MathUtils.cos(angle) + center.x,
                center.radius * MathUtils.sin(angle) + center.y, point.radius))
        gameWorld.updateLines()
    }

    private fun findAngle(touchPos: Vector2): Float {
        val diffX = touchPos.x - center.x
        val diffY = touchPos.y - center.y
        return MathUtils.atan2(diffY, diffX)
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        touchPos.set(screenX.toFloat(), screenY.toFloat())
        gameRenderer.viewport.unproject(touchPos)
        movingPoint?.let { point ->
            movePointToAngle(point.bounds, findAngle(touchPos))
        }
        return false
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        return false
    }

    override fun scrolled(amount: Int): Boolean {
        return false
    }

    override fun keyDown(keycode: Int): Boolean {
        return false
    }

    override fun keyUp(keycode: Int): Boolean {
        return false
    }

    override fun keyTyped(character: Char): Boolean {
        return false
    }

}