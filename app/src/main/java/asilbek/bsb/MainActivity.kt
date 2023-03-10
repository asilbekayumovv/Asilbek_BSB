package asilbek.bsb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import asilbek.bsb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var types = mutableListOf<Category>()
    private var listRec = mutableListOf<Foods>()

    private val type = "type"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadRec()
        loadData()

        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = TypeRecycler(types) {
            if (it.name == "Burgers") {
                val intent = Intent(this, Extended_all_foods::class.java)
                intent.putExtra("tag", 1)
                startActivity(intent)
            }
            if (it.name == "Drinks") {
                val intent = Intent(this, Extended_all_foods::class.java)
                intent.putExtra("tag", 2)
                startActivity(intent)
            }
            if (it.name == "Pastas") {
                val intent = Intent(this, Extended_all_foods::class.java)
                intent.putExtra("tag", 3)
                startActivity(intent)
            }
            if (it.name == "Laptops") {
                val intent = Intent(this, Extended_all_foods::class.java)
                intent.putExtra("tag", 4)
                startActivity(intent)
            }
        }
        binding.rv.layoutManager = manager
        binding.rv.adapter = adapter

        var adapter2 = FoodAdapter(this, listRec)
        binding.main.adapter = adapter2

        binding.main.setOnItemClickListener { _, _, i, _ ->
            val food = listRec.get(i)

            val intent = Intent(this, More_Info::class.java)
            intent.putExtra("food", food)

            startActivity(intent)
        }

        binding.search.addTextChangedListener {
            val filter = mutableListOf<Foods>()
            if (it != null) {
                var fav = listRec
                for (c in fav) {
                    if (c.name.lowercase().contains(it.toString().lowercase())) {
                        filter.add(c)
                    }
                }
                adapter2 = FoodAdapter(this, filter)
                binding.main.adapter = adapter2
            }
        }

        binding.cart.setOnClickListener {
            val intent = Intent(this, Orders::class.java)
            startActivity(intent)
        }

    }

    private fun loadData() {
        val choose = mutableListOf<Category>()
        choose.add(Category(R.drawable.burger1, 1, "Burgers"))
        choose.add(Category(R.drawable.drinks, 2, "Drinks"))
        choose.add(Category(R.drawable.pasta, 3, "Pastas"))
        choose.add(Category(R.drawable.laptop1, 4, "Laptops"))



        types.addAll(choose)
    }

    private fun loadRec() {
        listRec.add(
            Foods(
                R.drawable.burger1,
                "Burger 1",
                330,
                485,
                "Taskent, Yunusobod",
                3.6,
                110
            )
        )

        listRec.add(
            Foods(
                R.drawable.burger3,
                "Burger 2",
                310,
                510,
                "Tashkent, Yunusobod",
                3.6,
                80
            )
        )
        listRec.add(
            Foods(
                R.drawable.burger1,
                "Red Cherry Soda",
                500,
                120,
                "Tasskent",
                3.6,
                60
            )
        )
        listRec.add(
            Foods(
                R.drawable.red,
                "Lemon Ice Tea",
                500,
                100,
                "Tashkent",
                3.6,
                70
            )
        )
        listRec.add(
            Foods(
                R.drawable.salat6,
                "Mackerel Pantry Pasta",
                330,
                495,
                "Tashkent, Yunusobod",
                3.6,
                120
            )
        )
    }

}