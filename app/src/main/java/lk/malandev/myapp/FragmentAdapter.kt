package lk.malandev.myapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
):FragmentStateAdapter(fragmentManager,lifecycle) {

    private var fragments: List<Fragment> = emptyList()

    fun setFragments(frgList: List<Fragment> ){
        fragments = frgList
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}