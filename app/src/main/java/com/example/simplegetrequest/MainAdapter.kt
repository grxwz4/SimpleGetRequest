package com.example.simplegetrequest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.JsonObjectRequest
import com.example.simplegetrequest.databinding.ActivityMainBinding
import com.example.simplegetrequest.databinding.ItemListBinding
import org.json.JSONArray
import org.json.JSONObject

class MainAdapter(private val pokemon: JSONArray): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(pokemon.getJSONObject(position))
    }

    override fun getItemCount(): Int = pokemon.length()

    class MainHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun render(pokemon: JSONObject){
            binding.name.setText(pokemon.getString("name"))
        }
    }
}