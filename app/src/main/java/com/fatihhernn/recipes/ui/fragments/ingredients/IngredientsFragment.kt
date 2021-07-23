package com.fatihhernn.recipes.ui.fragments.ingredients

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fatihhernn.recipes.R
import com.fatihhernn.recipes.adapters.IngredientsAdapter
import com.fatihhernn.recipes.models.Result
import com.fatihhernn.recipes.util.Constants.Companion.RECIPE_RESULT_KEY


class IngredientsFragment : Fragment() {

    private val mAdapter:IngredientsAdapter by lazy { IngredientsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_ingredients, container, false)

        val args=arguments
        val myBundle: Result? =args?.getParcelable(RECIPE_RESULT_KEY)


        myBundle?.extendedIngredients?.let {
            mAdapter.setData(it)
        }

        setUpRecyclerView(view)

        return view
    }
    private fun setUpRecyclerView(view:View){
        view.findViewById<RecyclerView>(R.id.ingredients_recyclerView).adapter=mAdapter
        view.findViewById<RecyclerView>(R.id.ingredients_recyclerView).layoutManager=LinearLayoutManager(requireContext())

    }
}