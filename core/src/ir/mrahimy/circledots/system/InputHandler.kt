package ir.mrahimy.circledots.system

import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.Vector3
import ir.mrahimy.circledots.gameobjects.PointSprite

class InputHandler(private val gameRenderer: GameRenderer, private val gameWorld: GameWorld) : InputProcessor {

    private val touchPos: Vector3 = Vector3()
    private var movingPoint: PointSprite? = null
    private var movingPointInitBounds: Circle? = null
    private val center = Vector2(gameWorld.circleSprite.bounds.x, gameWorld.circleSprite.bounds.y)

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        touchPos.set(screenX.toFloat(), screenY.toFloat(), 0f)
        gameRenderer.viewport.unproject(touchPos)
        println(touchPos)

        movingPoint = gameWorld.points.firstOrNull { Circle(touchPos.x, touchPos.y, 15f).contains(it.bounds) }
                ?: return false
        movingPoint?.let { point ->
            //creating a copy of the first position
            movingPointInitBounds = Circle(point.bounds)

            point.bounds.set(Circle(point.bounds.radius * MathUtils.cos(2.0f) + point.bounds.x,
            point.bounds.radius * MathUtils.sin(2.0f) + point.bounds.y, 2.5f))
        }
        return false
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        touchPos.set(screenX.toFloat(), screenY.toFloat(), 0f)
        gameRenderer.viewport.unproject(touchPos)
        println(touchPos)
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