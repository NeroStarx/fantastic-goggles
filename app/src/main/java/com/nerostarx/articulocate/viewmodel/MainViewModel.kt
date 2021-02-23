package com.nerostarx.articulocate.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.nerostarx.articulocate.model.Arc
import com.nerostarx.articulocate.model.Graph

class MainViewModel : ViewModel() {

    //var graph : Graph? = null
    var arcs: ArrayList<Arc> = ArrayList()
    var arcList: ArrayList<ArrayList<Int>> = ArrayList()
    var heuristique = 0
    var graphNodes = 0


    fun setNodesGraph(nodes : Int){
        graphNodes = nodes
        /*var temList = ArrayList<Int>()
        for (minNode in 0 until nodes){
            temList.add(0)
        }
        for(node in 0 until nodes){
            arcList.add(temList)
        }*/
        arcList = arrayListOf(
            arrayListOf(0, 10, 11, 12, 13,14),
            arrayListOf(10, 0, 15, 16, 17, 18),
            arrayListOf(11, 15, 0, 19, 20, 21),
            arrayListOf(12, 16, 19, 0, 22, 23),
            arrayListOf(13, 17, 20, 22, 0, 24),
            arrayListOf(14, 18, 21, 23, 24,0))
    }

    fun createGraph(){
         var graph = arrayListOf(
             arrayListOf(0, 10, 11, 12, 13,14),
             arrayListOf(10, 0, 15, 16, 17, 18),
             arrayListOf(11, 15, 0, 19, 20, 21),
             arrayListOf(12, 16, 19, 0, 22, 23),
             arrayListOf(13, 17, 20, 22, 0, 24),
             arrayListOf(14, 18, 21, 23, 24,0))
        Graph.V = graphNodes
        var s = 0
        heuristique =  Graph.travllingSalesmanProblem(arcList, s)
    }

    fun gettags():String{
        var out = ""

        for(tag in Graph.tags){
            out += tag
            break
        }

        return out
    }

    /*fun addEdge(depart : Int, destination: Int){
            graph?.addEdge(depart,destination)
    }

    fun getArticulationPoints(graph: Graph?): ArrayList<Int>?{
        return graph?.apFun()
    }*/

}