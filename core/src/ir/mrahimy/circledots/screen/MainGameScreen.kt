package ir.mrahimy.circledots.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import ir.mrahimy.circledots.system.GameRenderer
import ir.mrahimy.circledots.system.GameWorld
import ir.mrahimy.circledots.system.InputHandler
import ir.mrahimy.circledots.system.Xircle

class MainGameScreen(game: Xircle) : FitScreenImpl(game, Color(.1f, .12f, .16f, 1f)) {

    private val world: GameWorld = GameWorld()
    private val gameRenderer: GameRenderer
    //    private var hudRenderer: HudRenderer
    private var inputHandler: InputHandler
    private var inputMultiplexer: InputMultiplexer

    init {
        gameRenderer = GameRenderer(game, world)
        world.gameRenderer = gameRenderer
        inputHandler = InputHandler(gameRenderer, world)
        world.inputHandler = inputHandler
        inputMultiplexer = InputMultiplexer(inputHandler)
//        hudRenderer = HudRenderer(holdGame, inputMultiplexer, world)
//        world.setHudRenderer(hudRenderer)
        Gdx.input.inputProcessor = inputMultiplexer
    }

    override fun render(delta: Float) {

        gameRenderer.doRender(delta)
//        hudRenderer.render(delta)
        world.update(delta)
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        gameRenderer.resize(width, height)
    }

    fun takeInputHandle() {
//        hudRenderer.setInputMultiplexer(inputMultiplexer)
        Gdx.input.inputProcessor = inputMultiplexer
    }

    override fun hide() {
        super.hide()
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }
}
