package com.example.shaikhnoorish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class Logginpg : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var btn2: Button
    lateinit var editTextemail: EditText
    lateinit var editTextpassward: EditText
    lateinit var textViewforgot: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logginpg)
        textViewforgot=findViewById(R.id.forgot)
        btn=findViewById(R.id.btn)

        editTextemail=findViewById(R.id.emailEt)
        editTextpassward=findViewById(R.id.passwordEt)
        btn2=findViewById(R.id.btn2)
        btn2.setOnClickListener {
            intent= Intent(this,Signup::class.java)
            startActivity(intent)
        }

        val auth= FirebaseAuth.getInstance()
        btn.setOnClickListener {
        if (editTextemail.text.toString().isEmpty() && editTextpassward.length()==0) {
            editTextemail.setError("please enter email")
            editTextpassward.setError("please enter password")
        }
        else{
            auth.signInWithEmailAndPassword(editTextemail.text.toString(),editTextpassward.text.toString())
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        Log.e("sucessfull","suseccesfull")
                        val result= task.result
                        intent= Intent(this,splashscreen::class.java)
                        startActivity(intent)
                        Log.e("result>>>>",result.toString())
                    }else{
                        Log.e("faile","faile")
                    }

                }
        }
        }




    }
}