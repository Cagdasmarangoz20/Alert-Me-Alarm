package com.cagdasmarangoz.alertme

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.cagdasmarangoz.alertme.fragments.AlarmClockFragment
import com.cagdasmarangoz.alertme.fragments.ClockFragment
import com.cagdasmarangoz.alertme.fragments.StopwatchFragment
import com.cagdasmarangoz.alertme.fragments.TimerFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.idToolbar)
        setSupportActionBar(toolbar)

        replaceFragment(AlarmClockFragment())
        val tobar = findViewById<BottomNavigationView>(R.id.bottomNavigation)
tobar.setOnNavigationItemSelectedListener { menuItem->
    when(menuItem.itemId){
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

    }
    true

}
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameFragment,fragment)
            .commit()
    }

}