package com.example.jewelry

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jewelry.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity() {
    lateinit var binding:ActivityRegisterBinding
    var IsAdmin:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.apply {
            registerBtn.setOnClickListener {
                var Username = Username
                var Password = Password
                if(radioAdmin.isChecked) IsAdmin =true
                var request: ApiInterface = Api().registerApi().create(ApiInterface::class.java)

                request.regCall(Username.text.toString(), Password.text.toString(), IsAdmin)
                    .enqueue(object : Callback<DBResponse> {
                        override fun onResponse(call: Call<DBResponse>, response: Response<DBResponse>) {
                            val data = response.body()!!
                            if(data.IsSuccess == true)
                                Toast.makeText(this@Register, "ثبت نام با موفقیت انجام شد", Toast.LENGTH_LONG).show()
                        }
                        override fun onFailure(call: Call<DBResponse>, t: Throwable) {
                            Toast.makeText(this@Register, t.message, Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }
    }
}
