package com.bekirfarukarabaci.instagram_clone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bekirfarukarabaci.instagram_clone.databinding.ActivityFeedBinding
import com.bekirfarukarabaci.instagram_clone.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize Firebase Auth
        auth = Firebase.auth


    }

    fun signinClick(view : View) {

    }

    fun signupClick(view :View){
        val email = binding.emailText.text.toString()
        val password = binding.PasswordText.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()){
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                //success
                val intent = Intent(this@MainActivity,FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this@MainActivity,it.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }
    }
}