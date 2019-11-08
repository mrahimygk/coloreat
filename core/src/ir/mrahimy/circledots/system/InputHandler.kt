package ir.mrahimy.circledots.system

import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.math.Vector3

class InputHandler(private val gameRenderer: GameRenderer) : InputProcessor {

    private val touchPos: Vector3 = Vector3()

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        touchPos.set(screenX.toFloat(), screenY.toFloat(), 0f)
        gameRenderer.viewport.unproject(touchPos)
        println(touchPos)
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