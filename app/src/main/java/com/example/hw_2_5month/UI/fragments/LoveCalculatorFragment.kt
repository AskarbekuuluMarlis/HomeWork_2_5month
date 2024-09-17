package com.example.hw_2_5month.UI.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.hw_2_5month.LoveContract
import com.example.hw_2_5month.LoveModel
import com.example.hw_2_5month.LovePresenter
import com.example.hw_2_5month.R
import com.example.hw_2_5month.databinding.FragmentFirstBinding


class LoveCalculatorFragment : Fragment(), LoveContract.View {

    private lateinit var binding: FragmentFirstBinding
    private val presenter = LovePresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        btnCalc.setOnClickListener {
            val firstName = etFname.text.toString()
            val secondName = etSname.text.toString()

            if (firstName.isBlank() || secondName.isBlank()) {
                Toast.makeText(requireContext(), "Enter both names", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            presenter.getPercentage(firstName, secondName)
        }
    }


    override fun showResult(result: LoveModel) {
        val percentage = result.percentage.toIntOrNull() ?: 0
        val action = LoveCalculatorFragmentDirections.actionLoveCalculatorFragmentToResultFragment(
            LoveModel(
                firstName = result.firstName,
                secondName = result.secondName,
                percentage = result.percentage,
                result = result.result
            )
        )

        findNavController().navigate(action)
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }



}