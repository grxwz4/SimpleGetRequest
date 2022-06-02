package com.example.simplegetrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.simplegetrequest.databinding.ActivityMainBinding
import org.json.JSONObject
import java.time.temporal.TemporalAmount

class MainActivity : AppCompatActivity() {
    private lateinit var queue: RequestQueue
    private lateinit var binding: ActivityMainBinding
    var num: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        queue = Volley.newRequestQueue(this)
        binding.btnUpdatePokemon.setOnClickListener {
            num = binding.etPokemonAmount.text.toString().toInt()
            getPokemonList(num)
        }
        //getPokemonList(num)
    }

    fun getPokemonList(listAmount: Int){
        val url = "https://pokeapi.co/api/v2/pokemon/?limit=${listAmount}"

        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{ response ->
            Log.i("JSONRESPONSE", response.getJSONArray("results").toString())
        },
        Response.ErrorListener { error ->
            //error.msg
            Log.w("JSONRESPONSE", error.message as String)
        })

        queue.add(jsonRequest)
    }

    override fun onStop(){
        super.onStop()
        queue.cancelAll("Stopped")
    }
}