package io.romadata.bkk.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import io.romadata.bkk.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SettingsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SettingsFragment : Fragment(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        navigation_view.setNavigationItemSelectedListener(this)
        return inflater.inflate(R.layout.settings_fragment, container, false)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.nav_category -> {
//                MainActivity.replaceFragment(FragmentHome(), R.id.fragment_container)
//            }
//            R.id.nav_view_list -> {
//                MainActivity.replaceFragment(FragmentItem(), R.id.fragment_container)
//            }
//            R.id.nav_chart -> {
//                replaceFragment(FragmentChart(), R.id.fragment_container)
//            }
//            R.id.nav_tool -> {
//                replaceFragment(FragmentTool(), R.id.fragment_container)
//            }
//            R.id.nav_category -> {
//                replaceFragment(FragmentCategory(), R.id.fragment_container)
//                fabAction = FAB_ACTION_ADD_CATEGORY
//            }
//            R.id.nav_cloud -> {
//                replaceFragment(FragmentCloud(), R.id.fragment_container)
//            }
//        }
        return true
    }
}
