package asilbek.bsb

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.VideoView
import asilbek.bsb.databinding.ActivitySplashScreenBinding
import java.util.*

class SplashScreen : AppCompatActivity() {
    private lateinit var video_view: VideoView
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var getSharedPreferences: SharedPreferences
    private lateinit var getSharedPreferences2: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSharedPreferences = getSharedPreferences("state", MODE_PRIVATE)
        getSharedPreferences.getBoolean("State", false)
        getSharedPreferences2 = getSharedPreferences("lang", MODE_PRIVATE)
        val lang = getSharedPreferences2.getString("lang", "En")



        var languageToLoad: String? = null

        if (lang == "En") {
            languageToLoad = "en"
        } else if (lang == "Ru") {
            languageToLoad = "ru"
        } else if (lang == "Uz") {
            languageToLoad = "uz"
        }

        if (languageToLoad != null) {
            val locale = Locale(languageToLoad) // Locale -> identify language
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            baseContext.resources.updateConfiguration(
                config,
                baseContext.resources.displayMetrics
            )
        }





        video_view = findViewById(R.id.videoView)

        val videoPath = "android.resource://$packageName/raw/fatmore"
        video_view.setVideoPath(videoPath)
        video_view.setOnCompletionListener {
            val r = Runnable {
                startActivity(Intent(this, OfferingPermission::class.java))
                finish()
            }
            Handler().postDelayed(r, 80)
        }
        video_view.start()
    }


}