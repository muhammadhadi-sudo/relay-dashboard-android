package com.example.smartrelaycontrol

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smartrelaycontrol.databinding.ItemRelayBinding

class RelayAdapter : RecyclerView.Adapter<RelayAdapter.RelayViewHolder>() {
    private val relays = listOf(
        "Relay 1", "Relay 2", "Relay 3", "Relay 4",
        "Relay 5", "Relay 6", "Relay 7", "Relay 8"
    )

    inner class RelayViewHolder(val binding: ItemRelayBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelayViewHolder {
        val binding = ItemRelayBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RelayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RelayViewHolder, position: Int) {
        val name = relays[position]
        holder.binding.tvRelayName.text = name

        holder.binding.switchRelay.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                holder.binding.tvStatus.text = "ON"
                holder.binding.tvStatus.setTextColor(holder.itemView.context.getColor(R.color.accent_green))
            } else {
                holder.binding.tvStatus.text = "OFF"
                holder.binding.tvStatus.setTextColor(holder.itemView.context.getColor(R.color.accent_red))
            }
        }
    }

    override fun getItemCount() = relays.size
}