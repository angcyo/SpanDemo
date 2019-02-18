package com.angcyo.spandemo

import android.app.Application
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        var uiApp: Application? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        uiApp = application
        setContentView(R.layout.activity_main)


        text_view.text = SpanUtils.get()
            .appendImage(R.drawable.ic_icon_temp)
            .append("50°C")
            .setForegroundColor(Color.RED)
            .appendSpace(10)
            .appendImage(
                RUtils.tintDrawable(
                    ContextCompat.getDrawable(application, R.drawable.ic_icon_temp2)!!,
                    Color.RED
                ),
                SpanUtils.ALIGN_CENTER
            )
            .append("10%")
            .appendSpace(20, Color.BLACK)
            .appendImage(
                RUtils.colorFilter(
                    ContextCompat.getDrawable(application, R.drawable.ic_icon_temp)!!,
                    Color.YELLOW
                ),
                SpanUtils.ALIGN_TOP
            )
            .append("100%")
            .create()
    }
}
