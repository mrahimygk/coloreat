package ir.mrahimy.circledots.screen

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ir.mrahimy.circledots.GameWorld
import ir.mrahimy.circledots.Xircle

class GameRenderer(private val game: Xircle, private val world: GameWorld) : FitScreenImpl(game, Color(.0f, .0f, .0f, 1f)) {

    private val batch = SpriteBatch()

    init {
        batch.projectionMatrix = camera.combined
    }

    fun doRender(delta: Float) {
        super.render(0f)
        renderCircle(delta)
    }


    var i = 0
    var z = 1

    private fun renderCircle(delta: Float) {
        //rad is 90
        world.circleSprite.render(batch, delta)
        world.points.forEach {
            it.render(batch, delta)
        }
        world.centerPoint.render(batch, delta)
        world.linePoints.forEach {
            world.lineSprite.bounds.set(it)
            world.lineSprite.render(batch, delta)
        }
    }

}
