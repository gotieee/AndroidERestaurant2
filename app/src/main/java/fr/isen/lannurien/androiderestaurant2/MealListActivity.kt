
package fr.isen.lannurien.androiderestaurant2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
//import com.android.volley.Response
//import com.android.volley.toolbox.StringRequest
//import com.android.volley.toolbox.Volley
import fr.isen.lannurien.androiderestaurant2.databinding.ActivityMealListBinding
import java.nio.charset.Charset


class MealListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMealListBinding
    private var itemsList = ArrayList<String>()
    private lateinit var myCategoryAdapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val extras = intent.extras
        var menuName = extras?.getString("menu")
        var menuList = intent.getStringArrayListExtra("meal_list")

        if (menuName != null && menuList != null) {
            supportActionBar?.title = menuName

            myCategoryAdapter = CategoryAdapter(menuList) {
                    mealName -> myOnClickItem(mealName)
            }
            val layoutManager = LinearLayoutManager(applicationContext)
            binding.recycleView.layoutManager = layoutManager
            binding.recycleView.adapter = myCategoryAdapter
        }

        val stringReq : StringRequest =
            object : StringRequest(
                Method.POST, "http://test.api.catering.bluecodegames.com/menu",
                Response.Listener { response ->
                    val gson = GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()
                    //????
                },
                Response.ErrorListener { error ->
                    Log.d("API", "error => $error")
                }
            ){
                override fun getBody(): ByteArray {
                    return "{\"id_shop\": 1 }".toByteArray(Charset.defaultCharset())
                }
            }
        Volley.newRequestQueue(this).add(stringReq)

        binding.buttonBack.setOnClickListener {
            val myIntent = Intent(this@MealListActivity, HomeActivity::class.java)
            startActivity(myIntent)
        }

    }
    private fun myOnClickItem(mealName: String){
        //Log.d("tag", "msg")
        val myIntent = Intent(this@MealListActivity, MealDetailActivity::class.java)
        myIntent.putExtra("meal", mealName)
        startActivity(myIntent)
    }
}