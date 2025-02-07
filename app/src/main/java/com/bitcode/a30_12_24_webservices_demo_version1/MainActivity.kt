package com.bitcode.a30_12_24_webservices_demo_version1

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.StrictMode
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewForUsers: RecyclerView
    private var users = ArrayList<User>()
    private lateinit var usersAdapter : UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
    }

    inner class MessageHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            users = msg.obj as ArrayList<User>
        }
    }
}