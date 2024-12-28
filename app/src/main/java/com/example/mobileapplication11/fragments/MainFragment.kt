package com.example.mobileapplication11.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.mobileapplication11.R
import com.example.mobileapplication11.adapters.ViewPagerAdapter
import com.example.mobileapplication11.databinding.FragmentMainBinding
import com.example.mobileapplication11.home.HomeFragment
import com.example.mobileapplication11.profile.ProfileFragment
import com.example.mobileapplication11.directmessages.DirectMessagesFragment
import com.example.mobileapplication11.camera.CameraFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = binding.viewPager
        tabLayout = binding.tabLayout

        tabLayout.setPadding(0, 0, 0, 16)

        val fragments = listOf(
            CameraFragment.newInstance(),
            HomeFragment.newInstance(),
            DirectMessagesFragment.newInstance(),
            ProfileFragment.newInstance()
        )
        val adapter = ViewPagerAdapter(requireActivity(), fragments)
        viewPager.adapter = adapter

        // Set the default item to Home (index 1)
        viewPager.currentItem = 1

        // Attach the TabLayout with the ViewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Camera"
                1 -> tab.text = "Home"
                2 -> tab.text = "Direct Messages"
                3 -> tab.text = "Profile"
            }
        }.attach()

        // Hide the TabLayout
        tabLayout.visibility = View.GONE

        bottomNavigationListener()
    }

    private fun bottomNavigationListener() = with(binding) {
        bottomNavigationMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    viewPager.currentItem = 1
                    true
                }
                R.id.search -> {
                    true
                }
                R.id.add -> {
                    viewPager.currentItem = 0
                    true
                }
                R.id.notifications -> {
                    true
                }
                R.id.profile -> {
                    viewPager.currentItem = 3
                    true
                }
                else -> false
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}