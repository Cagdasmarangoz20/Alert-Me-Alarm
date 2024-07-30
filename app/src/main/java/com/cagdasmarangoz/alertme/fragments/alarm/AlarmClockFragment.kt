package com.cagdasmarangoz.alertme.fragments.alarm

import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.cagdasmarangoz.alertme.databinding.FragmentAlarmClockBinding
import com.cagdasmarangoz.alertme.modul.Alarm
import com.cagdasmarangoz.alertme.modul.RecyclerViewAlramAdapter
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AlarmClockFragment : Fragment() {
    private lateinit var binding: FragmentAlarmClockBinding
    private val recyclerViewMovieAdapter: RecyclerViewAlramAdapter by lazy {
        RecyclerViewAlramAdapter(
            onItemClick = { alarm ->
                showTimePicker(alarm)
            }
        )
    }

    private val viewModel by viewModels<AlarmViewModel>()


    private lateinit var picker: MaterialTimePicker


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlarmClockBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.idRecyclerAlarm.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = recyclerViewMovieAdapter
        }
        createNotificationChannel()

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.alarmList.collect { list ->
                    recyclerViewMovieAdapter.submitList(list.map { it.toAlarm() })
                }
            }
        }
    }


    private fun showTimePicker(alarm: Alarm) {
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(10)
            .setTitleText("Select Alarm Time")
            .build()
        picker.addOnPositiveButtonClickListener {
            viewModel.updateAlarm(alarm)
//
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