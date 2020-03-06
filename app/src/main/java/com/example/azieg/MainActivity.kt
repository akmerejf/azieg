package com.example.azieg

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.azieg.databinding.ActivityMainBinding
import com.example.azieg.fragments.DecorListFragment
import com.example.azieg.fragments.dummy.DecorItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DecorListFragment.OnListFragmentInteractionListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onListFragmentInteraction(item: DecorItem?) {
        Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
    }
}
