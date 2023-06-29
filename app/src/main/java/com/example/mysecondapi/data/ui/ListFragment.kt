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
import com.example.mysecondapi.databinding.FragmentListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class ListFragment : Fragment() {

    lateinit var binding : FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentListBinding.inflate(inflater, container, false)

        loadData()

        binding.listLoadBtn.setOnClickListener {
            loadData()

        }


        return binding.root

//        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    private fun loadData() {
        CoroutineScope(Dispatchers.Main).launch {
            val result = ApiDetails.beerClient.getRandomBeer()
            val selectedElement = Random.nextInt(result.size)
            binding.txList.text = result[selectedElement].name
            val image = result[selectedElement].imageUrl

            Glide
                .with(requireContext())
                .load(image)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.ivList)

        }
    }

}