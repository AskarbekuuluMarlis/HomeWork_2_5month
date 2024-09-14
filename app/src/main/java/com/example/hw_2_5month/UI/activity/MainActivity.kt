package com.example.hw_2_5month.UI.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.hw_2_5month.R
import com.example.hw_2_5month.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment()).commit()
        }
    }
}