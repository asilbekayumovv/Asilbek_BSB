package asilbek.bsb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import asilbek.bsb.databinding.ActivityExtendedAllFoodsBinding

class Extended_all_foods : AppCompatActivity() {
    private lateinit var binding: ActivityExtendedAllFoodsBinding
    private var list = mutableListOf<Foods>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExtendedAllFoodsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tag = intent.getIntExtra("tag", 1)
        if (tag == 1) {
            Burgers()
        }
        if (tag == 2) {
            loadDrinks()
        }
        if (tag == 3) {
            loadPastas()
        }
        if (tag == 4) {
            loadLaptops()
        }


        var adapter = FoodAdapter(this, list)
        binding.main.adapter = adapter


        binding.main.setOnItemClickListener { _, _, i, _ ->
            val food = list.get(i)

            val intent = Intent(this, More_Info::class.java)
            intent.putExtra("food", food)
            startActivity(intent)
        }
        binding.search.addTextChangedListener {
            val filter = mutableListOf<Foods>()
            if (it != null) {
                var fav = list
                for (c in fav) {
                    if (c.name.lowercase().contains(it.toString().lowercase())) {
                        filter.add(c)
                    }
                }
                adapter = FoodAdapter(this, filter)
                binding.main.adapter = adapter
            }

        }
    }



    private fun Burgers() {
        list.add(
            Foods(
                R.drawable.burger1,
                "Spring Burger",
                250,
                510,
                "KFC",
                3.6,
                80
            )
        )
        list.add(
            Foods(
                R.drawable.burger1,
                "Greek burger",
                410,
                610,
                "Tashkent",
                2.0,
                90
            )
        )
        list.add(
            Foods(
                R.drawable.burger1,
                "House Salad",
                420,
                720,
                "Tashkent",
                1.8,
                55
            )
        )
        list.add(
            Foods(
                R.drawable.burger3,
                "Big Italian",
                510,
                820,
                "Tashkent",
                0.3,
                120
            )
        )
        list.add(
            Foods(
                R.drawable.burger3,
                "Mega Burger",
                420,
                610,
                "Tashkenth",
                5.6,
                100
            )
        )
        list.add(
            Foods(
                R.drawable.burger1,
                "Chopped Salad",
                310,
                620,
                "Taskent, Yunusobod",
                3.6,
                75
            )
        )
        list.add(
            Foods(
                R.drawable.burger6,
                "Just Burger",
                720,
                910,
                "Tashkent, Yunusobod",
                4.6,
                150
            )
        )
        list.add(
            Foods(
                R.drawable.burger7,
                "Lettuce Salad",
                450,
                320,
                "Tashkent, Yunusobod",
                3.2,
                99
            )
        )
    }

    private fun loadDrinks() {
        list.add(
            Foods(
                R.drawable.red,
                "Red Cherry Soda",
                500,
                120,
                "Tashkent, Yunusobod",
                3.6,
                60
            )
        )
        list.add(
            Foods(
                R.drawable.lemon,
                "Lemon Ice Tea",
                500,
                100,
                "Tashkent, Yunusobod",
                3.6,
                70
            )
        )
        list.add(
            Foods(
                R.drawable.orange,
                "Orange Soda",
                500,
                120,
                "Tashkent, Yunusobod",
                1.2,
                100
            )
        )
        list.add(
            Foods(
                R.drawable.grinch,
                "Grinch Cocktail",
                500,
                90,
                "Tashkent, Yunusobod",
                2.6,
                120
            )
        )
        list.add(
            Foods(
                R.drawable.coke,
                "Coke",
                500,
                250,
                "Tashkent",
                5.6,
                60
            )
        )
        list.add(
            Foods(
                R.drawable.sprite,
                "Spite",
                500,
                150,
                "Tashkent ",
                2.9,
                90

            )
        )
    }

    private fun loadPastas() {
        list.add(
            Foods(
                R.drawable.salat1,
                "Simple Tahini Pasta",
                330,
                485,
                "Tashkent",
                3.6,
                110
            )
        )

        list.add(
            Foods(
                R.drawable.salat2,
                "Mackerel Pantry Pasta",
                330,
                495,
                "Tashkent",
                3.6,
                120
            )
        )
        list.add(
            Foods(
                R.drawable.salat3,
                "Penne pasta",
                290,
                510,
                "Tashkent, Yunusobod",
                3.8,
                100
            )
        )
        list.add(
            Foods(
                R.drawable.salat4,
                "Pasta con ",
                310,
                510,
                "Tashkent",
                3.8,
                150
            )
        )
        list.add(
            Foods(
                R.drawable.salat5,
                "Creamy Vegan",
                320,
                600,
                "Tashkent",
                4.8,
                150
            )
        )
        list.add(
            Foods(
                R.drawable.salat6,
                "Tomato Spaghetti",
                450,
                710,
                "Tashkent",
                1.2,
                200
            )
        )
    }

    private fun loadLaptops() {
        list.add(
            Foods(
                R.drawable.salat1,
                "Simple Tahini Pasta",
                330,
                485,
                "Tashkent",
                3.6,
                110
            )
        )

        list.add(
            Foods(
                R.drawable.salat2,
                "Mackerel Pantry Pasta",
                330,
                495,
                "Tashkent",
                3.6,
                120
            )
        )
        list.add(
            Foods(
                R.drawable.salat3,
                "Penne pasta",
                290,
                510,
                "Tashkent, Yunusobod",
                3.8,
                100
            )
        )
        list.add(
            Foods(
                R.drawable.salat4,
                "Pasta con ",
                310,
                510,
                "Tashkent",
                3.8,
                150
            )
        )
        list.add(
            Foods(
                R.drawable.salat5,
                "Creamy Vegan",
                320,
                600,
                "Tashkent",
                4.8,
                150
            )
        )
        list.add(
            Foods(
                R.drawable.salat6,
                "Tomato Spaghetti",
                450,
                710,
                "Tashkent",
                1.2,
                200
            )
        )
    }

}