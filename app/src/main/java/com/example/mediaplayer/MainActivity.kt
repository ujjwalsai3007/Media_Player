package com.example.mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Process
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    var totalminutes:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        mediaPlayer=MediaPlayer.create(this,R.raw.starboy)
        mediaPlayer.setVolume(1f,1f)
        totalminutes=mediaPlayer.duration

        val btnplay=findViewById<ImageView>(R.id.play)
        val btnpause=findViewById<ImageView>(R.id.pause)
        val btnnext=findViewById<ImageView>(R.id.next)
        val seek=findViewById<SeekBar>(R.id.seekBar)


        btnplay.setOnClickListener {
            mediaPlayer.start()
        }


        btnpause.setOnClickListener {
            mediaPlayer.pause()
        }

        ///when user changes the time stamp of music,reflect that change

        seek.max=totalminutes
        seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2){
                    mediaPlayer.seekTo(p1)
                }

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}


        }  )

        


    }
}