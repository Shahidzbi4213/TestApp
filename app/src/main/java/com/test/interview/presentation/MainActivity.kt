package com.test.interview.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.interview.R
import com.test.interview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}