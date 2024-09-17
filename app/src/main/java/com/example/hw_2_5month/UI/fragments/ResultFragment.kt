package com.example.hw_2_5month.UI.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.hw_2_5month.R
import com.example.hw_2_5month.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val args = navArgs<ResultFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillData()
    }

    private fun fillData() = with(binding) {
        val firstName = arguments?.getString("firstName")
        val secondName = arguments?.getString("secondName")
        val percentage = arguments?.getString("percentage")

        tvYouResult.text = args.value.result.firstName
        tvMeResult.text = args.value.result.secondName
        tvProcent.text = "${args.value.result.percentage}%"

        btnTryAgain.setOnClickListener {
           findNavController().navigateUp()
        }
    }
}