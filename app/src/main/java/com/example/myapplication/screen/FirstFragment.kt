package com.example.myapplication.screen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.RecyclerViewAdapter
import com.example.myapplication.data.Item
import com.example.myapplication.databinding.FirstFragmentLayoutBinding
import com.example.myapplication.screen.viewmodel.FirstViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


/**
 * Fragment to show user search and show weather details
 */
class FirstFragment : Fragment() {

    //databinding
    private lateinit var binding: FirstFragmentLayoutBinding

    //factory injection that handles view model injections
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var itemAdapter: RecyclerViewAdapter // Replace with your actual adapter class


    val viewModel: FirstViewModel by viewModels<FirstViewModel> {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //TODO: had more time, would implement jetpack compose
        binding =
            DataBindingUtil.inflate(inflater, R.layout.first_fragment_layout, container, false)

        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        initViews()
        initObservers()
    }

    private fun initObservers() {

        viewModel.snackbarText.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let {
                //TODO had more time, would custom style the message shown
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }

        viewModel.details.observe(viewLifecycleOwner, Observer { list ->
            list?.let {
                // Filter out items where 'name' is blank or null
                val filteredItems = list.filter {  it.name != null &&  it.name.isNotBlank() }

                // Sort items by 'listId' and then by 'name'
                val sortedItems = filteredItems.sortedWith(compareBy({ it.listId }, { it.name }))

                viewModel.itemAdapter.submitList(sortedItems)
            }
         })
    }

    private fun initViews() {
        binding.listRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.listRecycler.adapter = viewModel.itemAdapter
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }


}