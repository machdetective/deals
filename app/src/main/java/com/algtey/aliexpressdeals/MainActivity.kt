package com.algtey.aliexpressdeals

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.net.MalformedURLException
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define the URL
        val urlString = "https://linksredirect.com/?cid=208411&source=linkkit&url=https%3A%2F%2Fcampaign.aliexpress.com%2Fwow%2Fgcp-plus%2Fae%2Ftupr%3F_immersiveMode%3Dtrue%26wx_navbar_hidden%3Dtrue%26wx_navbar_transparent%3Dtrue%26ignoreNavigationBar%3Dtrue%26wx_statusbar_hidden%3Dtrue%26wh_weex%3Dtrue%26wh_pid%3D300000444%2FA84cKxAifR"

        if (isValidUrl(urlString)) {
            // Create an intent to open the URL
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlString))
            startActivity(intent)
            finish() // Close the app after opening the URL
        } else {
            Toast.makeText(this, "Invalid URL", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidUrl(urlString: String): Boolean {
        return try {
            URL(urlString) // Check if URL is valid
            true
        } catch (e: MalformedURLException) {
            false
        }
    }
}
