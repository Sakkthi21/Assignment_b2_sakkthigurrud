package com.example.timerapp

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMilk: Button = findViewById(R.id.btn_milk)
        val btnWaterMotor: Button = findViewById(R.id.btn_water_motor)
        val btnToast: Button = findViewById(R.id.btn_toast)
        val btnCancel: Button = findViewById(R.id.btn_cancel)
        val btnPass: Button = findViewById(R.id.btn_pass)
        val btnResume: Button = findViewById(R.id.btn_resume)

        btnMilk.setOnClickListener {
            startTimer(5, "Milk")
        }

        btnWaterMotor.setOnClickListener {
            startTimer(20, "Water Motor")
        }

        btnToast.setOnClickListener {
            startTimer(7, "Toast")
        }

        btnCancel.setOnClickListener {
            cancelTimer()
        }

        btnPass.setOnClickListener {
            skipToNextTimer()
        }

        btnResume.setOnClickListener {
            resumeTimer()
        }
    }

    private fun startTimer(minutes: Int, message: String) {
        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_LENGTH, minutes * 60)
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_SKIP_UI, false)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Timer app not available on this device", Toast.LENGTH_SHORT).show()

        }
    }

    private fun cancelTimer() {
        Toast.makeText(this, "Timer cancelled", Toast.LENGTH_SHORT).show()
    }

    private fun skipToNextTimer() {
        Toast.makeText(this, "Timer passed to next", Toast.LENGTH_SHORT).show()
    }

    private fun resumeTimer() {
        Toast.makeText(this, "Timer resumed", Toast.LENGTH_SHORT).show()
    }
}
