package com.nerostarx.articulocate.views.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.nerostarx.articulocate.viewmodel.MainViewModel
import com.nerostarx.articulocate.R
import com.nerostarx.articulocate.adapters.ArcAdapter
import com.nerostarx.articulocate.databinding.FragmentResultBinding
import com.nerostarx.articulocate.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by activityViewModels()
    private var _binding: MainFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val nextButton = binding.graphCreate
        val graphNodes = binding.nodesNumber
        val arcsRecycler = binding.arcsRecycler
        val adapter = ArcAdapter(viewModel)
        val layoutManager = LinearLayoutManager(requireContext(),VERTICAL,false)

        arcsRecycler.setHasFixedSize(false)
        arcsRecycler.layoutManager = layoutManager
        arcsRecycler.adapter = adapter

        nextButton.setOnClickListener {
                viewModel.createGraph()
                findNavController().navigate(R.id.to_result_nav)
        }

        binding.sommetsConfirm.setOnClickListener {
            if(graphNodes.text.isNotEmpty()){
                Toast.makeText(requireContext(), "ajout de noeuds...", LENGTH_SHORT).show();
                viewModel.setNodesGraph(graphNodes.text.toString().toInt())
            }
        }
    }

}