package com.futuneotech.freneoh.presentation.activities

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.window.layout.WindowMetricsCalculator
import com.futuneotech.freneoh.R
import com.futuneotech.freneoh.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

enum class WindowSizeClass { COMPACT, MEDIUM, EXPANDED }

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null
    private var navHostFragment: NavHostFragment? = null
    private var isExpandedScreen: Boolean = false
    var widthWindowSize: WindowSizeClass = WindowSizeClass.EXPANDED

    override fun onCreate(savedInstanceState: Bundle?) {
        computeWindowSizeClasses()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initNavController()
        initOnBackPress()
        setContentView(binding.root)
    }

    private fun initNavController() {
        if (navHostFragment == null)
            navHostFragment =
                supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        if (navController == null)
            navController = navHostFragment?.navController
    }

    private fun initOnBackPress() {
        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val backStackEntryCount =
                        navHostFragment?.childFragmentManager?.backStackEntryCount
                    if (backStackEntryCount == 0) {
                        finish()
                    } else {
                        Navigation
                            .findNavController(this@MainActivity,R.id.fragment_container)
                            .navigateUp()
                    }
                }
            })
    }


    private fun computeWindowSizeClasses() {
        val metrics = WindowMetricsCalculator
            .getOrCreate()
            .computeCurrentWindowMetrics(this)

        val widthDp = metrics.bounds.width() / resources.displayMetrics.density
        widthWindowSize = when {
            widthDp < 600f -> WindowSizeClass.COMPACT
            widthDp < 840f -> WindowSizeClass.MEDIUM
            else -> WindowSizeClass.EXPANDED
        }

        if (widthWindowSize == WindowSizeClass.EXPANDED) {
            isExpandedScreen = true
        }
    }

    fun isExpanded() = isExpandedScreen
}