package ir.mrahimy.coloreat.system

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ir.mrahimy.coloreat.screen.FitScreenImpl

class GameRenderer(game: CircleDots, private val world: GameWorld) : FitScreenImpl(game, Color(1.0f, 1.0f, 1.0f, 1f)) {

    private val batch = SpriteBatch()

    init {
        batch.projectionMatrix = camera.combined
    }

    fun doRender(delta: Float) {
        super.render(0f)
        renderPoints(delta)
        renderLines(delta)
        renderPlayer(delta)
    }

    private fun renderPoints(delta: Float) {
        world.dots.forEach {
            it.render(batch, delta)
        }
    }

    private fun renderPlayer(delta: Float) {
        world.player.render(batch, delta)
    }

    private fun renderLines(delta: Float) {
//        world.linePoints.forEach {
//            world.lineSprite.update(it.first, it.second)
//            world.lineSprite.render(batch, delta)
//        }
    }

}
