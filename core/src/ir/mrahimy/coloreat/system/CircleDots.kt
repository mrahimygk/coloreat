package ir.mrahimy.coloreat.system

import com.badlogic.gdx.Game
import ir.mrahimy.coloreat.screen.MainGameScreen

class CircleDots : Game() {

    override fun create() {
        setScreen(MainGameScreen(this))
    }
}
