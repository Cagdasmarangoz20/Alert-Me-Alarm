package com.cagdasmarangoz.alertme

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cagdasmarangoz.alertme.fragments.ClockFragment
import com.cagdasmarangoz.alertme.fragments.StopwatchFragment
import com.cagdasmarangoz.alertme.fragments.TimerFragment
import com.cagdasmarangoz.alertme.fragments.alarm.AlarmClockFragment
import com.cagdasmarangoz.alertme.fragments.alarm.AlarmViewModel
import com.cagdasmarangoz.alertme.modul.Alarm
import com.cagdasmarangoz.alertme.modul.Days
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<AlarmViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.idToolbar)
        setSupportActionBar(toolbar)

        replaceFragment(AlarmClockFragment())
        val tobar = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        tobar.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.idAlarm -> {
                    replaceFragment(AlarmClockFragment())
                }

                R.id.idClock -> {
                    replaceFragment(ClockFragment())
                }

                R.id.idTimer -> {
                    replaceFragment(TimerFragment())
                }

                R.id.idStopwatch -> {
                    replaceFragment(StopwatchFragment())
                }

                R.id.idPlus -> {
                }

            }
            true

        }

        findViewById<ImageView>(R.id.addFabBtn).setOnClickListener {
            showTimePicker()

        }
    }

    private fun showTimePicker() {
        val picker = MaterialTimePicker.Builder().setTimeFormat(TimeFormat.CLOCK_12H).setHour(12)
            .setMinute(10).setTitleText("Select Alarm Time").build()
        picker.addOnPositiveButtonClickListener {
            viewModel.updateAlarm(Alarm("aslan", picker.hour, picker.minute, true, listOf()))
//
        }
        picker.show(supportFragmentManager, null)


    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameFragment, fragment).commit()
    }

}