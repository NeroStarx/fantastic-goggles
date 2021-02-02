package com.nerostarx.articulocate.views.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nerostarx.articulocate.R
import com.nerostarx.articulocate.databinding.FragmentResultBinding
import com.nerostarx.articulocate.viewmodel.MainViewModel

class ResultFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentResultBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        for(arc in viewModel.arcList){
            viewModel.addEdge(arc.src,arc.dst)
        }

        val list = viewModel.getArticulationPoints(viewModel.graph)

        binding.resultText.text = list.toString()

        binding.returnButton.setOnClickListener {
            findNavController().navigate(R.id.back_tomain)
        }
    }
}