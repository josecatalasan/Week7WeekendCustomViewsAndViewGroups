package com.example.week7weekendcustomviewsandviewgroups

import android.content.Context
import android.media.MediaPlayer
import android.os.Handler
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.SeekBar
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.layout_media_player.view.*

class MediaPlayerView : ConstraintLayout {

    private var player: MediaPlayer? = null
    var media: Int? = null

    private lateinit var runnable: Runnable
    private var seekBarHandler = Handler()

    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init(){
        LinearLayout.inflate(context, R.layout.layout_media_player, this)
        setupButtonListeners()

        sbProgress.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, boolean: Boolean) {
                if(boolean && player != null){
                    player!!.seekTo(progress)
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    private fun initSeekBar(){
        sbProgress.max = player!!.duration

        runnable = Runnable{
            sbProgress.progress = player!!.currentPosition
            seekBarHandler.postDelayed(runnable, 1000)
        }
        seekBarHandler.postDelayed(runnable, 1000)

    }

    private fun setupButtonListeners(){
        //setup Play Button listener
        btnPlay.setOnClickListener {
            if (player == null && media != null) {
                player = MediaPlayer.create(context, media!!)
                player!!.setOnCompletionListener { stopPlayer() }
                player!!.start()

                initSeekBar()

            } else {
                player?.start()
            }
        }

        //setup Pause Button listener
        btnPause.setOnClickListener {
            if (player != null) {
                player!!.pause()
            }
        }

        //setup Stop Button listener
        btnStop.setOnClickListener {
            stopPlayer()
        }
    }

    private fun stopPlayer() {
        if (player != null) {
            player!!.release()
            player = null
            sbProgress.progress = 0
            seekBarHandler.removeCallbacks(runnable)
        }
    }

}