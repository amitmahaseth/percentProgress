package com.example.rv

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar

import android.widget.TextView

import android.view.View
import android.widget.Button
import android.widget.EditText


class ProgressActivity : AppCompatActivity() {
    private var txtProgress: TextView? = null
    private var editText: EditText? = null
    private lateinit var btn:Button
    private var progressBar: ProgressBar? = null
    private var pStatus = 0
    private val handler: Handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        txtProgress = findViewById(R.id.tv_percent)
        progressBar = findViewById(R.id.progress_barr)
        editText=findViewById(R.id.tv_percent_write)
        btn=findViewById(R.id.btn_click)

        Thread {
            while (pStatus <= 100) {
                handler.post {
                    with(progressBar) { if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        this?.setProgress(pStatus,true)
                    } else {

                    }
                    }
                    with(txtProgress) { this?.text = "$pStatus %" }
                }
                try {
                    Thread.sleep(100)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                btn.setOnClickListener {


                    pStatus++
                }


            }
        }.start()

    }
}