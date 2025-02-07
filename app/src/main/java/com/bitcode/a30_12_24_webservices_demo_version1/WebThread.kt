package com.bitcode.a30_12_24_webservices_demo_version1

import android.os.AsyncTask
import android.os.Handler
import android.os.Message
import android.util.Log
import org.json.JSONObject
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class WebThread(var handler: Handler) : AsyncTask<Any, Any, ArrayList<User>>() {
    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Any?): ArrayList<User> {
        return WebUtil.getAllUsers()
    }

    override fun onPostExecute(result: ArrayList<User>?) {
        super.onPostExecute(result)
        var messageObject = Message()
        messageObject.obj = result
        messageObject.what = 1
        handler.sendMessage(messageObject)
    }

    override fun onProgressUpdate(vararg values: Any?) {
        super.onProgressUpdate(*values)
    }
}