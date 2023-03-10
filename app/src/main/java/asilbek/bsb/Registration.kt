package asilbek.bsb

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import asilbek.bsb.databinding.ActivityRegistrationBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Registration : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var userList: MutableList<User>
    private lateinit var getPreferences: SharedPreferences
    private lateinit var edit: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        emailfocusListener()
        passwordFocusListener()
        binding.signIn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        val type = object : TypeToken<List<User>>() {}.type
        val gson = Gson()

        getPreferences = getSharedPreferences("login", MODE_PRIVATE)
        edit = getPreferences.edit()

        binding.signUp.setOnClickListener {
            if (binding.name.text!!.isEmpty() || binding.email.text!!.isEmpty() || binding.password.text!!.isEmpty() || binding.phone.text!!.isEmpty()) {
                Toast.makeText(applicationContext, "Fill all strokes", Toast.LENGTH_LONG).show()
            } else {
                val userName = binding.name.text.toString()
                val userEmail = binding.email.text.toString()
                val userPhone = binding.phone.text.toString()
                val userPassword = binding.password.text.toString()
                val str = getPreferences.getString("Users", "")

                if (str == "") {
                    userList = mutableListOf()
                } else {
                    userList = gson.fromJson(str, type)
                }
                userList.add(User(userEmail, userName, userPassword, userPhone))
                val intent = Intent(this, PinCod::class.java)
                startActivity(intent)
                finish()
                val s = gson.toJson(userList)
                edit.putString("Users", s).apply()
            }
        }
    }

    private fun passwordFocusListener() {
        binding.password.setOnFocusChangeListener{_, focused ->
            if (!focused){
                binding.passwordContainer.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val passwordText = binding.password.text.toString()
        if (passwordText.length < 8){
            return "Minimum 8 character Password"
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())){
            return "Must Contain 1 Upeer-case Character"
        }
        return null
    }

    private fun emailfocusListener() {
        binding.email.setOnFocusChangeListener{_, focused ->
            if (!focused){
                binding.EmailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail() : String?{
        val emailtext = binding.email.text.toString()
        if (Patterns.EMAIL_ADDRESS.matcher(emailtext).matches()){
            return "Invalid Email Addres"
        }
        return null

    }

    override fun onBackPressed() {
        finish()
    }
}