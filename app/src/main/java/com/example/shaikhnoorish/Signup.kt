package com.example.shaikhnoorish

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.VolleyLog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Signup : AppCompatActivity() {
    lateinit var btn20: Button
    lateinit var btn21: Button
    lateinit var Name: EditText
    lateinit var Emailid: EditText
    lateinit var Password: EditText
    lateinit var address: EditText
    lateinit var phone: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences("user", Context.MODE_PRIVATE)
        val editor1: SharedPreferences.Editor = sharedPreferences.edit()

        btn20 = findViewById(R.id.btn20)
        btn21 = findViewById(R.id.btn21)
        Name = findViewById(R.id.Name)
        Emailid = findViewById(R.id.Emailid)
        Password = findViewById(R.id.Password)
        address = findViewById(R.id.address)
        phone = findViewById(R.id.phone)
        btn21.setOnClickListener {
            val intent=Intent(this,Logginpg::class.java)
            startActivity(intent)
            Toast.makeText(this,"sucessful",Toast.LENGTH_LONG).show()
        }
        val auth = FirebaseAuth.getInstance()
        Password.setOnClickListener {
            Toast.makeText(this,"password must be more than 6 character",Toast.LENGTH_LONG).show()
        }
        btn20.setOnClickListener {
            if (Emailid.text.toString().isEmpty() && Password.length() == 0) {
                Emailid.setError("please enter email")
                Password.setError("please enter password")
            } else {
                auth.createUserWithEmailAndPassword(
                    Emailid.text.toString(),
                    Password.text.toString()

                )
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            storedata()
                            editor1.putString("username",Emailid.text.toString())
                            editor1.putString("password",Password.text.toString())
                            editor1.apply()
                            editor1.apply()

                            Toast.makeText(this,"Successful",Toast.LENGTH_LONG).show()
                            Log.e("Successful", "Successful")
                            val result = task.result
                            Log.e("result>>>>", result.toString())
                        } else {
                            Log.e("faile", "faile")
                            Toast.makeText(this,"fail",Toast.LENGTH_LONG).show()
                        }

                    }
            }
        }
    }

    private fun storedata() {
        val modal=DataModal()
        modal.name=Name.text.toString()
        modal.email=Emailid.text.toString()
        modal.password=Password.text.toString()
        modal.phone=phone.text.toString()
        modal.address=address.text.toString()
        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences("user", Context.MODE_PRIVATE)
        val editor1: SharedPreferences.Editor = sharedPreferences.edit()




        val dp = FirebaseFirestore.getInstance()
        dp.collection("user").document(Emailid.text.toString()).set(modal).addOnSuccessListener {
            editor1.putString("username",Emailid.text.toString())
            editor1.putString("password",Password.text.toString())
            editor1.apply()
            editor1.apply()
          Toast.makeText(this,"sucessful",Toast.LENGTH_LONG).show()
        }.addOnFailureListener {
            Log.w(ContentValues.TAG,"Error adding document",it)
            Toast.makeText(this,"error",Toast.LENGTH_LONG).show()
        }
    }
}
