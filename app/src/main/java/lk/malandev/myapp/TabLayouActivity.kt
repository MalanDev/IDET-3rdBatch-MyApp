
package lk.malandev.myapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabLayoutMediator
import lk.malandev.myapp.bottom_bar.FreindsFragment
import lk.malandev.myapp.bottom_bar.HomeFragment
import lk.malandev.myapp.bottom_bar.SettingsFragment
import lk.malandev.myapp.databinding.ActivityTabLayouBinding

class TabLayouActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabLayouBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabLayouBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fragmentList = listOf(
            HomeFragment(),
            FreindsFragment(),
            SettingsFragment()
        )

        val fragmentAdapter = FragmentAdapter(supportFragmentManager,lifecycle)

        fragmentAdapter.setFragments(fragmentList)

        binding.pager.adapter = fragmentAdapter

        TabLayoutMediator(binding.tabLayout,binding.pager){tab,position ->
            tab.text = when(position){
                0 -> "Home"
                1 -> "Friends"
                2 -> "Settings"
                else -> ""
            }
        }.attach()
    }
}