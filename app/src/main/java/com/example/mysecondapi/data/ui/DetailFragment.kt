package com.example.mysecondapi.data.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.mysecondapi.R
import com.example.mysecondapi.data.remote.ApiDetails
import com.example.mysecondapi.databinding.FragmentDetailBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class DetailFragment : Fragment() {

    lateinit var binding : FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentDetailBinding.inflate(inflater, container, false)
        loadData()

        binding.detailBtn.setOnClickListener {
//            binding.textDetail.text = "Testing"
            loadData()
        }
        return binding.root
//        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    private fun loadData() {
        CoroutineScope(Dispatchers.Main).launch {
            val result = ApiDetails.disneyClient.getRandomDisney()
            val selectedEl = result.data?.size?.let { Random.nextInt(it) }

            binding.textDetail.text = selectedEl?.let { result.data?.get(it)?.name }
            val image = selectedEl?.let { result.data?.get(it)?.imageUrl }

            Glide
                .with(requireContext())
                .load(image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivDetail)

        }
    }

}