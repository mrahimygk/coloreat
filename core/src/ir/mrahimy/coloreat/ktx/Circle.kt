package ir.mrahimy.coloreat.ktx

import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2

fun Circle.findAngle(pos: Vector2) = MathUtils.atan2(pos.y - y, pos.x - x)

fun Circle.moveToAngle(angle: Float, center: Circle) {
    set(Circle(center.radius * MathUtils.cos(angle) + center.x,
            center.radius * MathUtils.sin(angle) + center.y, radius))
}