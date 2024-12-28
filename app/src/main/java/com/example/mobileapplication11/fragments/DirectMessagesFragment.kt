package com.example.mobileapplication11.directmessages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapplication11.R

class DirectMessagesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_direct_messages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chatItems = listOf(
            ChatItem("John Doe 1", "Hello!"),
            ChatItem("John Doe 2", "How are you?"),
            ChatItem("Person 3", "Let's meet up."),
            ChatItem("John Doe 1", "Hello!"),
            ChatItem("John Doe 2", "How are you?"),
            ChatItem("Person 3", "Let's meet up."),
            ChatItem("John Doe 1", "Hello!"),
            ChatItem("John Doe 2", "How are you?"),
            ChatItem("John Doe 2", "How are you?"),
            ChatItem("Person 3", "Let's meet up."),
            ChatItem("John Doe 1", "Hello!")
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_chats)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ChatsAdapter(chatItems)
    }

    companion object {
        @JvmStatic
        fun newInstance() = DirectMessagesFragment()
    }
}