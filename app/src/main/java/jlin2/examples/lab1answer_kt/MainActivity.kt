package jlin2.examples.lab1answer_kt

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import jlin2.examples.lab1answer_kt.R

class MainActivity : AppCompatActivity() , SurveyDialogFragment.SendMessages{
    var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btnSurvey)
        button.setOnClickListener { showDialog() }
    }

    fun runInstructions(view: View?) {
        val intent = Intent(this, InstructionsActivity::class.java)
        startActivity(intent)
        stopMusic()
    }

    fun showDialog() {
        val newFragment: DialogFragment = SurveyDialogFragment
            .newInstance(R.string.alert_dialog_two_buttons_title)
        newFragment.show(supportFragmentManager, "dialog")
    }
    fun doPositiveClick() {
        // Do other stuff here.
        Log.i("FragmentAlertDialog", "Positive click!")

    }
    fun doNegativeClick() {
        // Do other stuff here.
        Log.i("FragmentAlertDialog", "Negative click!")
    }


override fun choiceMade(msg: String?) {
        val tvChoices = findViewById<TextView>(R.id.tvMessage)
        tvChoices.text = "My choice is: $msg"
        playMusic()
    }

    fun playMusic(){
        mediaPlayer = MediaPlayer.create(this,R.raw.beat_it)
        mediaPlayer?.start()
    }
    fun stopMusic(){
        if (mediaPlayer?.isPlaying() == true) mediaPlayer?.stop()
    }
}