package ir.mrahimy.coloreat.system

import com.badlogic.gdx.math.Circle
import ir.mrahimy.coloreat.gameobjects.CircleSprite

class GameWorld {

    var inputHandler: InputHandler? = null
    var gameRenderer: GameRenderer? = null

    var player = CircleSprite(Circle(100f,
            100f, 15f))

    fun update() {
//        movingPoint?.radius = InputHandler.TOUCH_RADIUS / 2f
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