package com.cagdasmarangoz.alertme.modul

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cagdasmarangoz.alertme.R

class RecyclerViewAlramAdapter(
    private val onItemClick: (Alarm) -> Unit
) : ListAdapter<Alarm, RecyclerViewAlramAdapter.MyViewHolder>(object :
    DiffUtil.ItemCallback<Alarm>() {
    override fun areItemsTheSame(oldItem: Alarm, newItem: Alarm): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Alarm, newItem: Alarm): Boolean {
        return oldItem == newItem
    }

}) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_alarm_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val alarm = getItem(position)
        holder.bind(alarm = alarm)

        holder.cardView.setOnClickListener {
            onItemClick.invoke(alarm)
        }
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvTime: TextView = itemView.findViewById(R.id.tvTime)
        val tvPm: TextView = itemView.findViewById(R.id.tvPm)
        val tvMonday: TextView = itemView.findViewById(R.id.idMonday)
        val tvTuesday: TextView = itemView.findViewById(R.id.idTuesday)
        val tvWednesday: TextView = itemView.findViewById(R.id.idWednesday)
        val tvThursday: TextView = itemView.findViewById(R.id.idThursday)
        val tvFriday: TextView = itemView.findViewById(R.id.idFriday)
        val tvSaturday: TextView = itemView.findViewById(R.id.idSaturday)
        val tvSunday: TextView = itemView.findViewById(R.id.idSunday)

        val cardView: CardView = itemView.findViewById(R.id.cardView)

        fun bind(alarm: Alarm) {
            tvTitle.text = alarm.title
            tvTime.text = alarm.time
//            tvPm.text = alarm.pm
//            tvMonday.text = alarm.monday
//            tvTuesday.text = alarm.tuesday
//            tvWednesday.text = alarm.wednesday
//            tvThursday.text = alarm.thursday
//            tvFriday.text = alarm.friday
//            tvSaturday.text = alarm.saturday
//            tvSunday.text = alarm.sunday

        }
    }


}

