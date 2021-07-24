package com.fatihhernn.recipes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fatihhernn.recipes.data.database.entities.FavoritesEntity
import com.fatihhernn.recipes.databinding.FavoriteRecipesRowLayoutBinding
import com.fatihhernn.recipes.util.RecipesDiffUtil

class FavoriteRecipesAdapter : RecyclerView.Adapter<FavoriteRecipesAdapter.MyViewHolder>() {

    private var favoriteRecipes= emptyList<FavoritesEntity>()

    class MyViewHolder(private val binding: FavoriteRecipesRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(favoritesEntity: FavoritesEntity){
                binding.favoritesEntity=favoritesEntity
                binding.executePendingBindings()
            }

        companion object{
            fun from(parent: ViewGroup):MyViewHolder{
                val layoutInflater=LayoutInflater.from(parent.context)
                val binding=FavoriteRecipesRowLayoutBinding.inflate(layoutInflater,parent,false)
                return MyViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder = MyViewHolder.from(parent)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val selectedRecipe=favoriteRecipes[position]
        holder.bind(selectedRecipe)
    }

    override fun getItemCount(): Int =favoriteRecipes.size

    fun setData(newFavoriteRecipes:List<FavoritesEntity>){
        val favoriteRecipesDiffUtil=RecipesDiffUtil(favoriteRecipes,newFavoriteRecipes)
        val diffUtilResult=DiffUtil.calculateDiff(favoriteRecipesDiffUtil)
        favoriteRecipes=newFavoriteRecipes
        diffUtilResult.dispatchUpdatesTo(this)
    }
}