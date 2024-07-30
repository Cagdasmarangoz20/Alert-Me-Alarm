package com.cagdasmarangoz.alertme.fragments

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import com.cagdasmarangoz.alertme.AlarmReceiver
import com.cagdasmarangoz.alertme.R
import java.util.Calendar

class AlarmAddedFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alarm_added, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val broadcastIntent = Intent(context, AlarmReceiver::class.java)

        // The Pending Intent to pass in AlarmManager
        val pIntent = PendingIntent.getBroadcast(
            context,
            0,
            broadcastIntent,
            PendingIntent.FLAG_IMMUTABLE
        )

        // Setting up AlarmManager
        val alarmMgr = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager




            alarmMgr.set(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 5000,
                pIntent)

            // show a message that the alarm was set
            Toast.makeText(
                context,
                "Alarm was set, please wait.",
                Toast.LENGTH_LONG
            ).show()

    }

    /**
     * Setup the date to trigger the alarm.
     * @return the date in milliseconds to trigger the alarm
     */
    private fun dateForAlarm(): Long{
        val calendar = Calendar.getInstance()
        //calendar.timeInMillis = System.currentTimeMillis()
        //calendar.set(Calendar.HOUR_OF_DAY, 21)
        //calendar.set(Calendar.MINUTE, 13)
        calendar.set(Calendar.SECOND, 30)

        return calendar.timeInMillis
    }


}