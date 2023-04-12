package com.powersoft.curriculumvitae

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.powersoft.curriculumvitae.adapters.ViewPagerAdapter
import com.powersoft.curriculumvitae.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0.0f

        binding.viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Home"
                    tab.setIcon(R.drawable.ic_home)
                }
                1 -> {
                    tab.text = "About Me"
                    tab.setIcon(R.drawable.ic_about)
                }
                2 -> {
                    tab.text = "Experience"
                    tab.setIcon(R.drawable.ic_experience)
                }
                3 -> {
                    tab.text = "Contact"
                    tab.setIcon(R.drawable.ic_contact)
                }

            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_social, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemLinkedIn -> showToast("LinkedIn Clicked!!")
            R.id.itemGitHub -> showToast("Github Clicked!!")
        }
        return true
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}