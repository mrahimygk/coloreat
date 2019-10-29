package ir.mrahimy.circledots

import com.badlogic.gdx.Game
import ir.mrahimy.circledots.screen.MainGameScreen

class Xircle : Game() {

    override fun create() {
        setScreen(MainGameScreen(this))
    }
}
