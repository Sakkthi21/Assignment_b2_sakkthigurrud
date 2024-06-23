package com.example.projectname

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.projectname.databinding.SolutionBinding

class SolutionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: SolutionBinding = DataBindingUtil.setContentView(this, R.layout.solution)

        val user = User("Grace", "Hopper", 5)
        binding.user = user
    }
}
