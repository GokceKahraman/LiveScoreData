package com.example.livescoredata.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.livescoredata.R
import com.example.livescoredata.data.service.ServiceApi
import com.example.livescoredata.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}