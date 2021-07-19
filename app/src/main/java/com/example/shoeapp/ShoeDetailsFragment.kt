package com.example.shoeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.shoeapp.databinding.FragmentLoginBinding
import com.example.shoeapp.databinding.FragmentShoeDetailsBinding


class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_shoe_details , container , false)

        binding.viewModel = viewModel
        viewModel.newShoe()

        viewModel.eventBackToShoeList.observe(viewLifecycleOwner , Observer {
           if (it) {
               findNavController().navigateUp()
               viewModel.backToShoeListComplete()
           }
        })


        return binding.root
    }


}