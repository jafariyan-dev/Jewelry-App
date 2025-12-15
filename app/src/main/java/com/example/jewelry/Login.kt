package com.example.jewelry

import android.graphics.ColorSpace.Model
import android.os.Build
import android.os.Bundle
import android.view.WindowInsetsAnimation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
                var request: ApiInterface = Api().loginAPI().create(ApiInterface::class.java)

                request.loginCall(Username.text.toString(), Password.text.toString())
                    .enqueue(object : Callback<DBResponse> {
                        override fun onResponse(call: Call<DBResponse>, response: Response<DBResponse>) {
                            val data = response.body()!!
                            if(data.IsSuccess == true)
                                Toast.makeText(this@Login, data.Message, Toast.LENGTH_LONG).show()
                        }
                        override fun onFailure(call: Call<DBResponse>, t: Throwable) {
                            Toast.makeText(this@Login, t.message, Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }
    }
}
