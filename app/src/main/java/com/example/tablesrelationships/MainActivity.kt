package com.example.tablesrelationships

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tablesrelationships.db.SchoolDB

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = SchoolDB.getInstance(context = applicationContext).schoolDao
    }
}