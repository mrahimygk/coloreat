package ir.mrahimy.coloreat.system

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Circle
import ir.mrahimy.coloreat.config.Constants
import ir.mrahimy.coloreat.gameobjects.CircleSprite
import ir.mrahimy.coloreat.gameobjects.PointSprite
import kotlin.random.Random

class GameWorld {

    var inputHandler: InputHandler? = null
    var gameRenderer: GameRenderer? = null

    var player = CircleSprite(Circle(100f,
            100f, 15f))

    val dots = mutableListOf<PointSprite>()

    fun update() {
        val dotsIterator = dots.iterator()
        while (dotsIterator.hasNext()) {
            val dot = dotsIterator.next()
            if (player.bounds.contains(dot.bounds)) {
                dotsIterator.remove()
            }
        }
    }

    var state = WorldState.PLACING_CIRCLE

    enum class WorldState {
        PLACING_CIRCLE, WAITING_FOR_INPUT, CALCULATING_SCORE, BACK_FROM_RESULTS
    }

    var current = 0f
    fun update(delta: Float) {
        when (state) {
            WorldState.PLACING_CIRCLE -> {
                current += delta
                if (current > THRESHOLD) {
                    current = 0f
                    if (Random.nextInt(100) > 75) {
                        val x = Random.nextInt(Constants.WORLD_WIDTH).toFloat()
                        val y = Random.nextInt(Constants.WORLD_HEIGHT).toFloat()
                        val point = PointSprite(Circle(x, y, (Random.nextInt(10) + 1).toFloat()), randomColors.random())
                        dots.add(point)
                    }
                }
                return
            }

            WorldState.WAITING_FOR_INPUT -> {
                return
            }
        }
    }

    companion object {
        const val THRESHOLD = 1.0f

        val randomColors = listOf<Color>(
                Color.BLUE,
                Color.BROWN,
                Color.YELLOW,
                Color.GREEN,
                Color.ORANGE,
                Color.CYAN
        )

    }
}