package com.cefer.g4gmvp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cefer.g4gmvp.contract.Contract
import com.cefer.g4gmvp.databinding.ActivityMainBinding
import com.cefer.g4gmvp.model.Model
import com.cefer.g4gmvp.presenter.Presenter

class MainActivity : AppCompatActivity(), Contract.View {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: Contract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // instantiating object of Presenter Interface
        presenter = Presenter(this, Model())

        binding.nextCourseBtn.setOnClickListener { presenter.onButtonClick() }

    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
        binding.courseDetailTv.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.GONE
        binding.courseDetailTv.visibility = View.VISIBLE
    }

    // method to set random string
    // in the Course Detail TextView
    override fun setString(string: String?) {
        binding.courseDetailTv.text = string
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}