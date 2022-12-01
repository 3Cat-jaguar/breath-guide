package kr.co.cat_diversity.ylee.breath_guide

import android.icu.number.Scale
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import kr.co.cat_diversity.ylee.breath_guide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.guideCircle.startAnimation(getAnimationSet())

        setContentView(binding.root)
    }

    private fun getAnimationSet() : AnimationSet {
        val animationSet : AnimationSet = AnimationSet(true)
        animationSet.interpolator = AccelerateDecelerateInterpolator()

        val animationDuration = 4000L
        animationSet.addAnimation(getZoomInAnimation(0.5f, 3f, animationDuration))
        animationSet.addAnimation(getAlphaAnimation(1f, 0.3f, animationDuration))

        return animationSet
    }

    private fun getZoomInAnimation(
        fromSize : Float, toSize : Float, duration : Long,
        repeatCount : Int = Animation.INFINITE,
        repeatMode : Int = Animation.REVERSE
    ) : Animation {
        val zoomInAnimation : Animation = ScaleAnimation(
            fromSize,
            toSize,
            fromSize,
            toSize,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )

        zoomInAnimation.duration = duration
        zoomInAnimation.repeatCount = repeatCount
        zoomInAnimation.repeatMode = repeatMode

        return zoomInAnimation
    }

    private fun getAlphaAnimation(
        fromAlpha : Float, toAlpha : Float, duration : Long,
        repeatCount : Int = Animation.INFINITE,
        repeatMode : Int = Animation.REVERSE
    ) : Animation {
        val alphaAnimation : Animation = AlphaAnimation(
            fromAlpha, toAlpha
        )
        alphaAnimation.duration = duration
        alphaAnimation.repeatCount = repeatCount
        alphaAnimation.repeatMode = repeatMode

        return alphaAnimation
    }
}