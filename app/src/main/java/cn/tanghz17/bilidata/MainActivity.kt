package cn.tanghz17.bilidata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import cn.tanghz17.bilidata.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_main)

        val appBarConfiguration = AppBarConfiguration.Builder(navView.menu).build()
        NavigationUI.setupActionBarWithNavController(this,navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView,navController)

    }
}