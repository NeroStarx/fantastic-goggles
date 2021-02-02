package com.nerostarx.articulocate.viewmodel

import androidx.lifecycle.ViewModel
import com.nerostarx.articulocate.model.Arc
import com.nerostarx.articulocate.model.Graph

class MainViewModel : ViewModel() {

    var graph : Graph? = null
    var arcList: ArrayList<Arc> = ArrayList()

    fun createGraph(nodesNum: Int){
        graph = Graph(nodesNum)
    }

    fun addEdge(depart : Int, destination: Int){
            graph?.addEdge(depart,destination)
    }

    fun getArticulationPoints(graph: Graph?): ArrayList<Int>?{
        return graph?.apFun()
    }

}