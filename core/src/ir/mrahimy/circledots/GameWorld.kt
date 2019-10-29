package ir.mrahimy.circledots

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.MathUtils.*
import ir.mrahimy.circledots.config.Constants
import ir.mrahimy.circledots.gameobjects.CircleSprite
import ir.mrahimy.circledots.gameobjects.LineSprite
import ir.mrahimy.circledots.gameobjects.PointSprite
import ir.mrahimy.circledots.screen.GameRenderer

class GameWorld {

    private val angles = (0..(PI * 2 * 100).toInt()).map {
        return@map it / 100.0f
    }

    var inputHandler: InputHandler? = null
    var gameRenderer: GameRenderer? = null

    var circleSprite = CircleSprite(Circle(
            Constants.WORLD_WIDTH / 2f,
            Constants.WORLD_HEIGHT / 2f,
            90f), color = Color.GOLD)
    var points = listOf(
            PointSprite(Circle(circleSprite.bounds.radius * cos(angles[20]) + circleSprite.bounds.x,
                    circleSprite.bounds.radius * sin(angles[20]) + circleSprite.bounds.y, 2.5f)),
            PointSprite(Circle(circleSprite.bounds.radius * cos(angles[50]) + circleSprite.bounds.x,
                    circleSprite.bounds.radius * sin(angles[50]) + circleSprite.bounds.y, 2.5f)),
            PointSprite(Circle(circleSprite.bounds.radius * cos(angles[100]) + circleSprite.bounds.x,
                    circleSprite.bounds.radius * sin(angles[100]) + circleSprite.bounds.y, 2.5f)))
    var centerPoint = PointSprite(Circle(circleSprite.bounds.x, circleSprite.bounds.y, 2.5f), color = Color.CYAN)

    val lineSprite = LineSprite(Circle())

    var i = 10f
    var j = 30f
    var linePoints = listOf(
            Circle(i++, j++, i++),
            Circle(i++, j++, i++),
            Circle(i++, j++, i++),
            Circle(i++, j++, i++),
            Circle(i++, j++, i++),
            Circle(i++, j++, i++)
    )

    var state = WorldState.PLACING_CIRCLE

    enum class WorldState {
        PLACING_CIRCLE, WAITING_FOR_INPUT, CALCULATING_SCORE, BACK_FROM_RESULTS
    }

    fun update(delta: Float) {
        when (state) {
            WorldState.PLACING_CIRCLE -> {
                //TODO: place and expand circleSprite
                //TODO: place and put dots on circleSprite
                return
            }

            WorldState.WAITING_FOR_INPUT -> {
                //TODO: show bottom table from hud


                return
            }
        }
    }

    //TODO: have functions for checking if the centre is inside the triangle
}