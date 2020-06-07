package com.dontsu.android_kotlin_viewpager_indicator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.dontsu.android_kotlin_viewpager_indicator.fragments.PageOneFragment
import com.dontsu.android_kotlin_viewpager_indicator.fragments.PageThreeFragment
import com.dontsu.android_kotlin_viewpager_indicator.fragments.PageTwoFragment
import com.dontsu.android_kotlin_viewpager_indicator.util.CircleIndicator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentViewPagerAdapter: FragmentViewPagerAdapter

    private val pageOneFragment = PageOneFragment()
    private val pageTwoFragment = PageTwoFragment()
    private val pageThreeFragment = PageThreeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentViewPagerAdapter = FragmentViewPagerAdapter(supportFragmentManager)
        viewPagerContainer.adapter = fragmentViewPagerAdapter
        viewPagerContainer.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                indicator.selectDot(position)
            }

        })

        indicator.createDotPanel(3, R.drawable.indicator_dot_off, R.drawable.indicator_dot_on, 0)

        if (indicator.context == this) {
            Log.d("정체" , indicator.context.toString())
        }
    }

    @Suppress("DEPRECATION")
    inner class FragmentViewPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return when(position) {
                0 -> pageOneFragment
                1 -> pageTwoFragment
                else -> pageThreeFragment
            }
        }

        override fun getCount(): Int = 3
    }

}