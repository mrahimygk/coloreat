package ir.mrahimy.circledots.system

import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.Vector2
import ir.mrahimy.circledots.ktx.findAngle
import ir.mrahimy.circledots.ktx.moveToAngle

class InputHandler(private val gameRenderer: GameRenderer, private val gameWorld: GameWorld) : InputProcessor {

    private val touchPos: Vector2 = Vector2()
    private var movingPoint: Circle? = null
    private val center = gameWorld.circleSprite.bounds
    private var pointOriginalRadius: Float = 0f

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        touchPos.set(screenX.toFloat(), screenY.toFloat())
        gameRenderer.viewport.unproject(touchPos)
        println(touchPos)

        movingPoint = gameWorld.points.firstOrNull { Circle(touchPos.x, touchPos.y, TOUCH_RADIUS).contains(it.bounds) }?.bounds
                ?: return false
        pointOriginalRadius = movingPoint?.radius ?: 0f

        return false
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        touchPos.set(screenX.toFloat(), screenY.toFloat())
        gameRenderer.viewport.unproject(touchPos)
        movingPoint?.let { circle ->
            circle.moveToAngle(center.findAngle(touchPos), center)
            gameWorld.update(circle)
        }
        return false
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        movingPoint?.let {
            it.radius = pointOriginalRadius
            gameWorld.update(null)
        }
        movingPoint = null

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

    companion object {
        public const val TOUCH_RADIUS = 15f
    }
}