package ir.mrahimy.circledots.system

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.MathUtils.*
import com.badlogic.gdx.math.Vector2
import ir.mrahimy.circledots.config.Constants
import ir.mrahimy.circledots.gameobjects.CircleSprite
import ir.mrahimy.circledots.gameobjects.LineSprite
import ir.mrahimy.circledots.gameobjects.PointSprite
import ir.mrahimy.circledots.ktx.leftShift

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
            PointSprite(Circle(circleSprite.bounds.radius * cos(angles[300]) + circleSprite.bounds.x,
                    circleSprite.bounds.radius * sin(angles[300]) + circleSprite.bounds.y, 2.5f)),
            PointSprite(Circle(circleSprite.bounds.radius * cos(angles[500]) + circleSprite.bounds.x,
                    circleSprite.bounds.radius * sin(angles[500]) + circleSprite.bounds.y, 2.5f)),
            PointSprite(Circle(circleSprite.bounds.radius * cos(angles[100]) + circleSprite.bounds.x,
                    circleSprite.bounds.radius * sin(angles[100]) + circleSprite.bounds.y, 2.5f)))
    var centerPoint = PointSprite(Circle(circleSprite.bounds.x, circleSprite.bounds.y, 2.5f), color = Color.CYAN)

    val lineSprite = LineSprite(Vector2(), Vector2())

//    var linePoints = points.zip(arrayOf(centerPoint, centerPoint, centerPoint)) { point, center ->
//        return@zip Pair(Vector2(point.bounds.x, point.bounds.y), Vector2(centerPoint.bounds.x, centerPoint.bounds.y))
//    }

    var linePoints = points.zip(points.leftShift(1)) { a, b ->
        Pair(Vector2(a.bounds.x, a.bounds.y), Vector2(b.bounds.x, b.bounds.y))
    }

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