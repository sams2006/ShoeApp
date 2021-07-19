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
import com.example.shoeapp.databinding.FragmentInstructionBinding
import com.example.shoeapp.databinding.FragmentLoginBinding
import com.example.shoeapp.databinding.FragmentShoeListBinding
import com.example.shoeapp.databinding.ListShoeBinding


class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(inflater , R.layout.fragment_shoe_list , container , false)

        binding.viewModel = viewModel

        viewModel.eventFabButton.observe(viewLifecycleOwner , Observer {
            if (it){
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
                viewModel.fabButtonComplete()
            }
        })

        viewModel.shoes.observe(viewLifecycleOwner , Observer {
                displayShoes(it)
        })


        return binding.root
    }

    private fun displayShoe(shoe: Shoe){
        val itemInflater:ListShoeBinding = DataBindingUtil.inflate(layoutInflater , R.layout.list_shoe , null , false)
          itemInflater.name.text = getString(R.string.shoe_value , shoe.name)
          itemInflater.size.text = getString(R.string.size_value , shoe.size.toString())
          itemInflater.company.text = getString(R.string.company_value , shoe.company)
          itemInflater.description.text = getString(R.string.description_value ,shoe.description)

        binding.linearLayout.addView(itemInflater.root)
    }

    private fun displayShoes(shoes:List<Shoe>){
        for ( i in shoes) {
            displayShoe(i)
        }
    }


}