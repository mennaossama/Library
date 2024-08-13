package com.example.navigation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigation.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        val books: List<Model> = listOf(
            Model("One Hundred Years of Solitude", "Gabriel Garcia Marquez", R.drawable.solitude, 3.5f),
            Model("Terra Nostra", "Carlos Fuentes", R.drawable.nostra, 3.0f),
            Model("Angles & Demons", "Dan Brown", R.drawable.angels, 4.0f),
            Model("The Sword Thief", "Peter Lerangis", R.drawable.sword, 2.0f),
            Model("Inferno", "Dan Brown", R.drawable.angels, 4.5f),
            Model("Bloodline", "James Rollins", R.drawable.blood, 2.0f),
            Model("The House of the Spirits", "Isabel Allende", R.drawable.spirits, 3.0f),
            Model("The Hummingbird`s Daughter", "Luis Alberto Urrea", R.drawable.humming, 3.5f)
        )
        val bookAdapter = BookAdapter(books)
        binding.rvBooks.layoutManager = LinearLayoutManager(this)
        binding.rvBooks.adapter = bookAdapter

        binding.toolbar.materialtoolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.bell -> {
                    Toast.makeText(this, R.string.Notification_clicked, Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }

        binding.toolbar.materialtoolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.reviews -> {
                    Toast.makeText(this, R.string.reviews_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                R.id.favorite -> {
                    Toast.makeText(this, R.string.favorite_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.search-> {
                    Toast.makeText(this, R.string.search_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                R.id.profile-> {
                    Toast.makeText(this, R.string.profile_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                R.id.settings-> {
                    Toast.makeText(this, R.string.settings_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }


                else -> false
            }
        }

    }
}

