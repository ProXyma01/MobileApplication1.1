package com.example.mobileapplication11.directmessages

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapplication11.R

class ChatsAdapter(private val chatItems: List<ChatItem>) : RecyclerView.Adapter<ChatsAdapter.ChatViewHolder>() {

    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.chat_name)
        val lastMessageTextView: TextView = itemView.findViewById(R.id.chat_last_message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chatItem = chatItems[position]
        holder.nameTextView.text = chatItem.name
        holder.lastMessageTextView.text = chatItem.lastMessage
    }

    override fun getItemCount(): Int = chatItems.size
}