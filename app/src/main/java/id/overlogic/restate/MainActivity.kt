package id.overlogic.restate

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import id.overlogic.restate.views.fragments.ArchiveFragment
import id.overlogic.restate.views.fragments.DashboardFragment
import id.overlogic.restate.views.fragments.HomeFragment
import id.overlogic.restate.views.fragments.ProfileFragment

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var bottomNavigation: BottomNavigationView;
    private lateinit var fragment: Fragment;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.selectedItemId = R.id.nav_home
        bottomNavigation.setOnItemSelectedListener(this)

        fragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val itemId: Int = item.itemId

        when (itemId) {
            R.id.nav_home -> {
                fragment = HomeFragment()
            }
            R.id.nav_dashboard -> {
                fragment = DashboardFragment()
            }
            R.id.nav_archive -> {
                fragment = ArchiveFragment()
            }
            R.id.nav_profile -> {
                fragment = ProfileFragment()
            }
            else -> return false
        }
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        return true
    }
}