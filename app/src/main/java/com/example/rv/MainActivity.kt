package com.example.rv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var countList: ArrayList<TextData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        inIt()
    }

    private fun inIt() {
        countList = ArrayList()

        countList.add(TextData("apple", 1, 10, 10))
        countList.add(TextData("orange", 1, 12, 12))
        countList.add(TextData("grapes", 1, 15, 15))
        countList.add(TextData("guava", 1, 20, 20))

        binding.rvList.layoutManager = LinearLayoutManager(this)
        val adapter = CustomAdapter(this, countList)
        binding.rvList.adapter = adapter
    }
}