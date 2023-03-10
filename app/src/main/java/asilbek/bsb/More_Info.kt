package asilbek.bsb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import asilbek.bsb.databinding.ActivityMoreInfoBinding
import coil.load

class More_Info : AppCompatActivity() {
    private lateinit var binding: ActivityMoreInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoreInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foods = intent.getSerializableExtra("food") as Foods

        binding.img.load(foods.img) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
        }
        binding.name.text = foods.name

        binding.location.text = foods.location

        binding.price.text = foods.price.toString()


        binding.addToCart.setOnClickListener {
            val intent = Intent(this, Orders::class.java)
            intent.putExtra("food", foods)

            startActivity(intent)
        }

        binding.back.setOnClickListener {
            finish()
        }
    }

}