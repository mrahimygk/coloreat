package ir.mrahimy.circledots.system

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ir.mrahimy.circledots.screen.FitScreenImpl

class GameRenderer(private val game: Xircle, private val world: GameWorld) : FitScreenImpl(game, Color(.0f, .0f, .0f, 1f)) {

    private val batch = SpriteBatch()

    init {
        batch.projectionMatrix = camera.combined
    }

    fun doRender(delta: Float) {
        super.render(0f)
        renderCircle(delta)
        renderLines(delta)
        renderPoints(delta)
    }

    private fun renderCircle(delta: Float) {
        world.circleSprite.render(batch, delta)
        world.centerPoint.render(batch, delta)
    }

    private fun renderPoints(delta: Float) {
        world.points.forEach {
            it.render(batch, delta)
        }
    }

    private fun renderLines(delta: Float) {
        world.linePoints.forEach {
            world.lineSprite.start.set(it.first.x, it.first.y)
            world.lineSprite.end.set(it.second.x, it.second.y)
            world.lineSprite.render(batch, delta)
        }
    }

}
