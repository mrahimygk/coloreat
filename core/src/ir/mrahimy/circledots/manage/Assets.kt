package ir.mrahimy.circledots.manage

import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture

class Assets {

    @Synchronized
    public fun getInstance(): Assets {
        if (instance == null) {
            instance = Assets()
        }
        return instance!!
    }

    val manager = AssetManager()

    companion object {
        private var instance: Assets? = null
    }

    var fullyLoaded = false
    private val FONTS_FOLDER = "fonts"
    private val textureFilesPath = "textures/"


    private val xircleTextureDescriptor = AssetDescriptor(
            "$textureFilesPath/circle.png", Texture::class.java)


    fun load(): Assets {
        if (!fullyLoaded) {
            manager.load(xircleTextureDescriptor)
        }
        fullyLoaded = true
        return this
    }


    fun xircleTexture(): Texture {
        //if (!fullyLoaded) throw RuntimeException("Could not load assets. tip: Assets.load()")
        manager.load(xircleTextureDescriptor)
        manager.finishLoading()
        return manager.get(xircleTextureDescriptor)
    }


    fun dispose() {
        manager.dispose()
        fullyLoaded = false
    }

}