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
        enableButtons(true)

        sbProgress.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, boolean: Boolean) {
                if(boolean && player != null){
                    player!!.seekTo(progress)
                    updateTimes()
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    private fun seekbarUpdater(){
        runnable = Runnable{
            sbProgress.progress = player!!.currentPosition
            updateTimes()
            seekBarHandler.postDelayed(runnable, 250)
        }
        seekBarHandler.postDelayed(runnable, 250)

    }

    private fun setupButtonListeners(){
        //Play
        btnPlay.setOnClickListener {
            if (player == null && media != null) {
                player = MediaPlayer.create(context, media!!)
                player!!.setOnCompletionListener { stopPlayer() }
                player!!.start()
                sbProgress.max = player!!.duration
                updateTimes()

            } else {
                player!!.start()
            }
            seekbarUpdater()
            enableButtons(false)
        }

        //Pause
        btnPause.setOnClickListener {
            if (player != null) {
                player!!.pause()
                seekBarHandler.removeCallbacks(runnable)
            }
            btnPlay.isEnabled = true
            btnPause.isEnabled = false
        }

        //Stop
        btnStop.setOnClickListener {
            stopPlayer()
        }
    }

    private fun stopPlayer() {
        if (player != null) {
            player!!.release()
            player = null
            sbProgress.progress = 0
            tvTimeLeft.text = ""
            tvCurrentTime.text = ""
            seekBarHandler.removeCallbacks(runnable)
        }
        enableButtons(true)
    }

    private fun enableButtons(startEnabled : Boolean){
        btnPlay.isEnabled = startEnabled
        btnPause.isEnabled = !startEnabled
        btnStop.isEnabled = !startEnabled
        sbProgress.isEnabled = !startEnabled
    }

    private fun updateTimes(){
        val currentTime = "${player!!.currentSeconds/60}m ${player!!.currentSeconds%60}s"
        val diff = player!!.seconds-player!!.currentSeconds
        val timeLeft = "${diff/60}m ${diff%60}s"
        tvCurrentTime.text = currentTime
        tvTimeLeft.text = timeLeft
    }

    // Extension property to get media player duration in seconds
    val MediaPlayer.seconds:Int
        get() {
            return this.duration / 1000
        }


    // Extension property to get media player current position in seconds
    val MediaPlayer.currentSeconds:Int
        get() {
            return this.currentPosition/1000
        }
}