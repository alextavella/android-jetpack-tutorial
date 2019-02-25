package com.example.androidjetpacktutorial.ui.start

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidjetpacktutorial.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.start_fragment.*
import javax.inject.Inject

class StartFragment : Fragment() {

    companion object {
        fun newInstance() = StartFragment()
    }

    private val viewModel: StartViewModel by lazy {
        ViewModelProviders
            .of(activity as AppCompatActivity, factory)
            .get(StartViewModel::class.java)
    }

    @Inject
    lateinit var factory: StartViewModelFactory

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.start_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getCount().observe(this, Observer<Int> { count ->
            textViewCount.text = "$count"
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonCounter.setOnClickListener { viewModel.increaseCount() }
    }
}
