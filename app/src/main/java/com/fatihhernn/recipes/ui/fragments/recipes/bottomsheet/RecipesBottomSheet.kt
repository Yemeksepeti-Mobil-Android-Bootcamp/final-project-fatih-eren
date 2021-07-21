package com.fatihhernn.recipes.ui.fragments.recipes.bottomsheet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.fatihhernn.recipes.R
import com.fatihhernn.recipes.databinding.FragmentRecipesBinding
import com.fatihhernn.recipes.databinding.RecipesBottomSheetBinding
import com.fatihhernn.recipes.util.Constants.Companion.DEFAULT_DIET_TYPE
import com.fatihhernn.recipes.util.Constants.Companion.DEFAULT_MEAL_TYPE
import com.fatihhernn.recipes.viewmodels.RecipesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import java.util.*


class RecipesBottomSheet : BottomSheetDialogFragment() {

    private var _binding: RecipesBottomSheetBinding? = null
    private val binding get() = _binding!!

    private lateinit var recipesViewModel: RecipesViewModel

    private var mealTypeChip = DEFAULT_MEAL_TYPE
    private var mealTypeChipId = 0
    private var dietTypeChip = DEFAULT_DIET_TYPE
    private var dietTypeChipId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RecipesBottomSheetBinding.inflate(inflater, container, false)

        recipesViewModel.readMealAndDietType.asLiveData().observe(viewLifecycleOwner,{value ->
            mealTypeChip=value.selectedMealType
            dietTypeChip=value.selectedDietType
            updateChip(value.selectedMealTypeId,binding.mealTypeChipGroup)
            updateChip(value.selectedDietTypeId,binding.dietTypeChipGroup)
        })


        /** Saves the chips selected in the bottom sheet fragment to the datastore */
        binding.mealTypeChipGroup.setOnCheckedChangeListener{ group,selectedChipId ->
            val chip=group.findViewById<Chip>(selectedChipId)
            val selectedMealType= chip.text.toString().lowercase(Locale.ROOT)
            mealTypeChip=selectedMealType
            mealTypeChipId=selectedChipId
        }
        binding.dietTypeChipGroup.setOnCheckedChangeListener{ group,checkId ->
            val chip=group.findViewById<Chip>(checkId)
            val selectedDietType=chip.text.toString().toLowerCase(Locale.ROOT)
            dietTypeChip=selectedDietType
            dietTypeChipId=checkId
        }


        /** When the apply button is pressed, it writes the selected values to the datastore. */
        binding.applyButton.setOnClickListener {
            recipesViewModel.saveMealAndDietType(
                mealTypeChip,
                mealTypeChipId,
                dietTypeChip,
                dietTypeChipId
            )
        }

        return binding.root
    }

    private fun updateChip(chipId: Int, chipGroup: ChipGroup) {
        if (chipId!=0){
            try {
                chipGroup.findViewById<Chip>(chipId).isChecked=true
            }
            catch (e:Exception){
                Log.d("Recipes bottom sheet",e.message.toString())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipesViewModel = ViewModelProvider(requireActivity()).get(RecipesViewModel::class.java)
    }


}