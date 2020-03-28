package ir.mrahimy.circledots.system

import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import ir.mrahimy.circledots.gameobjects.PointSprite
import kotlin.math.acos
import kotlin.math.pow

class InputHandler(private val gameRenderer: GameRenderer, private val gameWorld: GameWorld) : InputProcessor {

    private val touchPos: Vector2 = Vector2()
    private var movingPoint: PointSprite? = null
    private val center = gameWorld.circleSprite.bounds
    private val centerVector = Vector2(gameWorld.circleSprite.bounds.x, gameWorld.circleSprite.bounds.y)
    private val horizontalAxis =
            Vector2(gameWorld.circleSprite.bounds.x + gameWorld.circleSprite.bounds.radius,
                    gameWorld.circleSprite.bounds.y)

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
    }

    private fun findAngle(touchPos: Vector2): Float {
        return findAngle(horizontalAxis, centerVector, touchPos)
    }

    private fun findAngle(p0: Vector2, p1: Vector2, p2: Vector2): Float {
        val a = (p1.x.toDouble() - p0.x.toDouble()).pow(2.0) + Math.pow(p1.y.toDouble() - p0.y, 2.0)
        val b = (p1.x - p2.x).pow(2) + Math.pow(p1.y.toDouble() - p2.y, 2.0)
        val c = (p2.x - p0.x).pow(2) + Math.pow(p2.y.toDouble() - p0.y, 2.0)
        val d = (a + b - c) / Math.sqrt(4.0 * a * b)
        return acos(d).toFloat()
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