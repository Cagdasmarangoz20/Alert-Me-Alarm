package com.cagdasmarangoz.alertme.fragments

import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cagdasmarangoz.alertme.R
import com.cagdasmarangoz.alertme.databinding.FragmentAlarmClockBinding
import com.cagdasmarangoz.alertme.modul.Alarm
import com.cagdasmarangoz.alertme.modul.Days
import com.cagdasmarangoz.alertme.modul.RecyclerViewAlramAdapter
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat


class AlarmClockFragment : Fragment() {
    private lateinit var binding: FragmentAlarmClockBinding
    private var recyclerView: RecyclerView? = null
    private val recyclerViewMovieAdapter: RecyclerViewAlramAdapter by lazy {
        RecyclerViewAlramAdapter(
            onItemClick = { alarm ->
                showTimePicker(alarm)
            }
        )
    }
    private var alarmList = mutableListOf<Alarm>(
        Alarm(
            title = "Deneme",
            hour = 1,
            minute = 1,
            isActive = true,
            dayList = listOf(Days.FRIDAY)
        ),
        Alarm(
            title = "12343567",
            hour = 1,
            minute = 1,
            isActive = true,
            dayList = listOf(Days.FRIDAY)
        ),
        Alarm(
            title = "fasfas",
            hour = 1,
            minute = 1,
            isActive = true,
            dayList = listOf(Days.FRIDAY)
        ),
    )
    private lateinit var picker: MaterialTimePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentAlarmClockBinding.inflate(layoutInflater)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alarm_clock, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<View>(R.id.idRecyclerAlarm) as RecyclerView
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(context, 2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewMovieAdapter
        recyclerViewMovieAdapter.submitList(alarmList)
        createNotificationChannel()

    }

    private fun showTimePicker(alarm: Alarm) {
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(10)
            .setTitleText("Select Alarm Time")
            .build()
        picker.addOnPositiveButtonClickListener {
            if (picker.hour > 12) {
                val newList = alarmList.map {
                    if (it == alarm) {
                        it.copy(
                            hour = picker.hour,
                            minute = picker.minute
                        )
                    } else {
                        it
                    }
                }
                recyclerViewMovieAdapter.submitList(newList)
            }
        }
        picker.show(childFragmentManager, null)

    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "Alert Me Reminder Channel"
            val description = "Channel for Alarm Manager"
            val importance = android.app.NotificationManager.IMPORTANCE_HIGH
            val channel = android.app.NotificationChannel("alertMe", name, importance)
            channel.description = description
            val notificationManager = context?.getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
    }


}