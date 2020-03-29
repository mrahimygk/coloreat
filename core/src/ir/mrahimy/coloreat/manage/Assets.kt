package ir.mrahimy.coloreat.manage

import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture

class Assets {

    @Synchronized
    fun getInstance(): Assets {
        if (instance == null) {
            instance = Assets()
        }
        return instance!!
    }

    private val manager = AssetManager()

    companion object {
        private var instance: Assets? = null
    }

    private var fullyLoaded = false
    private val FONTS_FOLDER = "fonts"
    private val textureFilesPath = "textures/"


    private val xircleTextureDescriptor = AssetDescriptor(
            "$textureFilesPath/circle.png", Texture::class.java)

    private val pointTextureDescriptor = AssetDescriptor(
            "$textureFilesPath/point.png", Texture::class.java)

    private val lineTextureDescriptor = AssetDescriptor(
            "$textureFilesPath/line.png", Texture::class.java)


    fun load(): Assets {
        if (!fullyLoaded) {
            manager.load(xircleTextureDescriptor)
        }
        fullyLoaded = true
        return this
    }


    fun circleTexture(): Texture {
        //if (!fullyLoaded) throw RuntimeException("Could not load assets. tip: Assets.load()")
        manager.load(xircleTextureDescriptor)
        manager.finishLoading()
        return manager.get(xircleTextureDescriptor)
    }

    fun pointTexture(): Texture {
        //if (!fullyLoaded) throw RuntimeException("Could not load assets. tip: Assets.load()")
        manager.load(pointTextureDescriptor)
        manager.finishLoading()
        return manager.get(pointTextureDescriptor)
    }

    fun lineTexture(): Texture {
        //if (!fullyLoaded) throw RuntimeException("Could not load assets. tip: Assets.load()")
        manager.load(lineTextureDescriptor)
        manager.finishLoading()
        return manager.get(lineTextureDescriptor)
    }

    fun dispose() {
        manager.dispose()
        fullyLoaded = false
    }

}