package fr.isen.lannurien.androiderestaurant2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import fr.isen.lannurien.androiderestaurant2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val myIntent = Intent(this@HomeActivity, MealListActivity::class.java)

        binding.buttonEntrees.setOnClickListener {
            //Toast.makeText(this@HomeActivity, "Choix des entrées", Toast.LENGTH_SHORT).show()
            myIntent.putExtra("menu", "entrees")
            val myMealList = resources.getStringArray(R.array.entrees).toList() as ArrayList<String>
            myIntent.putExtra("meal_list", myMealList)
            startActivity(myIntent)
        }
        binding.buttonPlats.setOnClickListener {
            myIntent.putExtra("menu", "plats")
            val myMealList = resources.getStringArray(R.array.plats).toList() as ArrayList<String>
            myIntent.putExtra("meal_list", myMealList)
            startActivity(myIntent)
        }
        binding.buttonDesserts.setOnClickListener {
            myIntent.putExtra("menu", "desserts")
            val myMealList = resources.getStringArray(R.array.desserts).toList() as ArrayList<String>
            myIntent.putExtra("meal_list", myMealList)
            startActivity(myIntent)
        }
       
    }
    override fun onDestroy() {
        Log.d("TAG", "Home détruite !")
        super.onDestroy()
    }
}