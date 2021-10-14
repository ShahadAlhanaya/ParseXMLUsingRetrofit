package com.example.parsexmlusingretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var fetchButton: Button
    lateinit var titleTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleTextView = findViewById(R.id.tv_title)
        fetchButton = findViewById(R.id.btn_fetch)

        titleTextView.text = ""

        val call = FeedAPIClient().getClient()?.create(FeedAPI::class.java)?.feed
        fetchButton.setOnClickListener {
            call!!.clone().enqueue(object : Callback<Feed?> {
                override fun onResponse(call: Call<Feed?>, response: Response<Feed?>) {
                    val entries = response.body()!!.entrys
                    for (entry in entries!!) {
                        var text = titleTextView.text.toString()
                        titleTextView.text = "$text\n\n\n${entry.title}"
                    }
                }

                override fun onFailure(call: Call<Feed?>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            })
        }

    }

}