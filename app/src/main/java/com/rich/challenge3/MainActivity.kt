package com.rich.challenge3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alphabetsFragment = ListAlphabetsFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, alphabetsFragment)
        fragmentTransaction.commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, ListAlphabetsFragment()).commit()
        return super.onSupportNavigateUp()
    }
}