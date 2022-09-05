package com.example.miappterremotos

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miappterremotos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.eqRecycler.layoutManager = LinearLayoutManager(this)

        val eqList = mutableListOf<Terremoto>()

        eqList.add(Terremoto("1", "Medellin", 4.8, 798789, -10.454, 75.888))
        eqList.add(Terremoto("2", "Medellin", 4.8, 798789, -10.454, 75.888))
        eqList.add(Terremoto("3", "Medellin", 4.8, 798789, -10.454, 75.888))
        eqList.add(Terremoto("4", "Medellin", 4.8, 798789, -10.454, 75.888))
        eqList.add(Terremoto("5", "Medellin", 4.8, 798789, -10.454, 75.888))

        val adapter = EqAdapter()
        binding.eqRecycler.adapter = adapter
        adapter.submitList(eqList)

        adapter.onItemClickListener = {
            Toast.makeText(this, it.place, Toast.LENGTH_SHORT).show()
        }

        if (eqList.isEmpty()) {
            binding.eqEmptyView.visibility = View.VISIBLE
            binding
        } else {
            binding.eqEmptyView.visibility = View.INVISIBLE
        }
    }
}
