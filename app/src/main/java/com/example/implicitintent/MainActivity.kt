package com.example.implicitintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.implicitintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDial.setOnClickListener{
            val iDial = Intent(Intent.ACTION_DIAL)
            iDial.data = Uri.parse("tel: +92 3108582181")
            startActivity(iDial)
        }

        binding.btnMessage.setOnClickListener {
            val iMessage = Intent(Intent.ACTION_SENDTO)
            iMessage.data = Uri.parse("smsto: +92 3417690907")
            iMessage.putExtra("sms_body",binding.editTextMessage.text.toString())
            startActivity(iMessage)
        }


        binding.btnEmail.setOnClickListener {
            val iEmail = Intent(Intent.ACTION_SEND)
            iEmail.setType("message/rfc822")
            iEmail.putExtra(Intent.EXTRA_EMAIL, arrayOf("abuzaransari4032@gmail.com","abuzaransari1647@gmail.com"))
            iEmail.putExtra(Intent.EXTRA_SUBJECT, "Queries")
            iEmail.putExtra(Intent.EXTRA_TEXT, binding.editTextMessage.text.toString())
//            startActivity(iEmail)
            // This line of code gives the user choice to select one of the email apps to send the email from the phone.
            startActivity(Intent.createChooser(iEmail, "Send Email Via"))
        }


        binding.btnShare.setOnClickListener {
            val iShare = Intent(Intent.ACTION_SEND)
            iShare.setType("text/plain")
            iShare.putExtra(Intent.EXTRA_TEXT, "Hey I found this awesome app on Google Play Store https://play.google.com/store/apps/details?id=pk.com.telenor.phoenix")
//            startActivity(iShare)
            // This line of code gives the user choice to select one of the app to share the message.
            startActivity(Intent.createChooser(iShare, "Share Via"))
        }


    }
}