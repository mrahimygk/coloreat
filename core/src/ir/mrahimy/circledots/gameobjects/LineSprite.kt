package ir.mrahimy.circledots.gameobjects

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion
import com.badlogic.gdx.math.Vector2
import ir.mrahimy.circledots.ktx.drawLine
import ir.mrahimy.circledots.manage.Assets

class LineSprite(val start: Vector2, val end: Vector2, private val color: Color = Color.BLUE) {
    private val texture = Assets().lineTexture().apply { setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear) }

    fun update(inStart: Vector2, inEnd: Vector2){
        start.set(inStart.x, inStart.y)
        end.set(inEnd.x, inEnd.y)
    }

    fun render(batch: SpriteBatch, deltaTime: Float) {
        batch.begin()
        batch.drawLine(start.x, start.y, end.x, end.y, 1f, AtlasRegion(texture, 0, 0, texture.width, texture.height))
        batch.end()
    }
}