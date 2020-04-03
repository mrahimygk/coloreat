package ir.mrahimy.coloreat.system

import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.Vector2
import ir.mrahimy.coloreat.ktx.findAngle
import ir.mrahimy.coloreat.ktx.moveToAngle

class InputHandler(private val gameRenderer: GameRenderer, private val gameWorld: GameWorld) : InputProcessor {

    private val touchPos: Vector2 = Vector2()
    private var movingPoint: Circle? = null
    private var pointOriginalInfo: Circle? = null

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        touchPos.set(screenX.toFloat(), screenY.toFloat())
        gameRenderer.viewport.unproject(touchPos)
        val touch = Circle(touchPos.x, touchPos.y, TOUCH_RADIUS)
        movingPoint = if (gameWorld.player.bounds.contains(touch)) gameWorld.player.bounds else return false
        pointOriginalInfo = movingPoint
        return false
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        touchPos.set(screenX.toFloat(), screenY.toFloat())
        gameRenderer.viewport.unproject(touchPos)
        movingPoint?.let { circle ->
            circle.set(touchPos.x, touchPos.y + circle.radius * (3f / 2f), circle.radius)
        }
        return false
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        movingPoint?.let {
            gameWorld.update()
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
        public const val TOUCH_RADIUS = .01f
    }
}