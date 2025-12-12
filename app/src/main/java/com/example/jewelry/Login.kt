package com.example.jewelry

import android.graphics.ColorSpace.Model
import android.os.Build
import android.os.Bundle
import android.view.WindowInsetsAnimation
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.set
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jewelry.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            LoginBtn.setOnClickListener {
                var Username = Username
                var Password = Password
                var request: ApiInterface = Api().getAPI().create(ApiInterface::class.java)

                request.loginCall(Username.text.toString(), Password.text.toString())
                    .enqueue(object : Callback<User> {
                        override fun onResponse(call: Call<User>, response: Response<User>) {
                            val data = response.body()!!
                            Username.setText(data.Username)
                            Password.setText(data.Password)
                        }

                        override fun onFailure(call: Call<User>, t: Throwable) {
                            Toast.makeText(this@Login, t.message, Toast.LENGTH_LONG).show()
                        }

                    })
            }
        }

    }
}
