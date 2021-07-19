package com.fatihhernn.recipes.ui.fragments.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.RecyclerView
import com.fatihhernn.recipes.databinding.ActivityMainBinding
import com.fatihhernn.recipes.databinding.FragmentRecipesBinding


class RecipesFragment : Fragment() {

    private var _binding:FragmentRecipesBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipesBinding.inflate(inflater,container,false)
        _binding!!.recylerview.showShimmer()
        return binding.root


    }

}