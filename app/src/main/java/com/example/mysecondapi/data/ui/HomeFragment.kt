package com.example.mysecondapi.data.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mysecondapi.R
import com.example.mysecondapi.data.remote.ApiDetails
import com.example.mysecondapi.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        loadData()

        binding.homeReloadBtn.setOnClickListener {
            loadData()
        }



        return binding.root
//        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun loadData() {
        CoroutineScope(Dispatchers.Main).launch {
            val result = ApiDetails.apiClient.getRandomAnime()
            binding.textHome.text = result?.data?.title
            val image = result?.data?.images?.jpg?.imageUrl

            Glide
                .with(requireContext())
                .load(image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivtest)


        }
    }

}