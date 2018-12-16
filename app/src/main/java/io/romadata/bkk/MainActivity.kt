package io.romadata.bkk

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

import io.romadata.bkk.fragment.MainFragment
import io.romadata.bkk.fragment.ListFragment
import io.romadata.bkk.fragment.SettingsFragment

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                //message.setText(R.string.title_home)
                replaceFragment(MainFragment(), R.id.container)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_view_list -> {
                //message.setText(R.string.title_view_list)
                replaceFragment(ListFragment(), R.id.container)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                Snackbar.make(container, "Not implemented!", Snackbar.LENGTH_LONG)
                    .setAction(R.string.title_dashboard, null).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                //message.setText(R.string.title_settings)
                replaceFragment(SettingsFragment(), R.id.container)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(MainFragment(), R.id.container)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }

    fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int){
        supportFragmentManager.inTransaction { add(frameId, fragment) }
    }

    fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction{replace(frameId, fragment)}
    }
}
