package fr.isen.lannurien.androiderestaurant2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.lannurien.androiderestaurant2.databinding.ActivityMealDetailBinding

class MealDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMealDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_detail)

        var mealName = intent.extras?.getString("meal")

        supportActionBar?.title = mealName
    }
}