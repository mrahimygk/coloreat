package ir.mrahimy.circledots.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.viewport.FitViewport
import ir.mrahimy.circledots.Xircle
import ir.mrahimy.circledots.config.Constants

open class FitScreenImpl(private val game: Xircle,
                         private val clearColor: Color) : Screen {
    val camera: OrthographicCamera = OrthographicCamera()
    val viewport: FitViewport

    companion object {
        val TAG = FitScreenImpl::class.java.simpleName
    }

    init {
        camera.setToOrtho(false, Constants.WORLD_WIDTH.toFloat(), Constants.WORLD_HEIGHT.toFloat())
        viewport = FitViewport(Constants.WORLD_WIDTH.toFloat(), Constants.WORLD_HEIGHT.toFloat(), camera)
        viewport.apply()

        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f)
        camera.update()
    }

    override fun hide() {
        Gdx.app.log(TAG, "Hide ${javaClass.simpleName}")
        Gdx.gl.glClearColor(clearColor.r, clearColor.g, clearColor.b, clearColor.a)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    override fun show() {
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(clearColor.r, clearColor.g, clearColor.b, clearColor.a)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f)
        camera.update()
    }

    override fun dispose() {
    }

}