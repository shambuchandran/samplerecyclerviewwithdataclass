package com.example.practice5

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //    val fruits= listOf<String>("Mango","apple","banana","lemon","pear","guava","orange") //passing data to adaptor
    val fruitslist = listOf<Fruits>(
        Fruits("mango", "A"),
        Fruits("orange", "B"),
        Fruits("pineapple", "C"),
        Fruits("apple", "D"),
        Fruits("grape", "A"),
        Fruits("guava", "C"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rv = findViewById<RecyclerView>(R.id.myrv)
        rv.setBackgroundColor(Color.YELLOW)
        rv.layoutManager = LinearLayoutManager(this)
//        rv.adapter = Adaptorrv(fruits) //for list of fruits
        rv.adapter = Adaptorrv(fruitslist) { selectedItem: Fruits ->
            listclicked(selectedItem)
        }
    }

    private fun listclicked(fruits: Fruits) {
        Toast.makeText(
            this@MainActivity,
            "the ${fruits.name} and ${fruits.supplier}",
            Toast.LENGTH_LONG
        ).show()
    }
}