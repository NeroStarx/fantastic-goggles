package com.nerostarx.articulocate.adapters

import android.view.LayoutInflater
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nerostarx.articulocate.R
import com.nerostarx.articulocate.model.Arc
import com.nerostarx.articulocate.viewmodel.MainViewModel

class ArcAdapter(val viewModel: MainViewModel): RecyclerView.Adapter<ArcAdapter.ArcViewHolder>() {


    override fun getItemCount(): Int = viewModel.arcList.size + 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArcViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ArcViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: ArcViewHolder, position: Int) {
        if(position == 0){
            holder.confirmButton.visibility = VISIBLE
            holder.destInput.visibility = VISIBLE
            holder.srcInput.visibility = VISIBLE
            holder.src.visibility = INVISIBLE
            holder.dst.visibility = INVISIBLE

            holder.confirmButton.setOnClickListener {
                if(holder.srcInput.text.isNotEmpty() && holder.destInput.text.isNotEmpty()){
                    viewModel.arcList.add(
                        Arc(holder.srcInput.text.toString().toInt()
                            ,holder.destInput.text.toString().toInt()))
                    notifyDataSetChanged()
                }
            }
        }else{
            holder.confirmButton.visibility = INVISIBLE
            holder.destInput.visibility = INVISIBLE
            holder.srcInput.visibility = INVISIBLE
            holder.src.visibility = VISIBLE
            holder.dst.visibility = VISIBLE

            val arcItem = viewModel.arcList[position-1]
            holder.src.text = arcItem.src.toString()
            holder.dst.text = arcItem.dst.toString()

        }
    }

    class ArcViewHolder(inflater: LayoutInflater, parent: ViewGroup)
        :RecyclerView.ViewHolder(inflater.inflate(R.layout.arc_item,parent,false)) {

        val confirmButton: Button = itemView.findViewById(R.id.confirm_button)
        val srcInput : EditText = itemView.findViewById(R.id.src_nodenum)
        val destInput : EditText = itemView.findViewById(R.id.dest_nodenum)
        val src : TextView = itemView.findViewById(R.id.src_text)
        val dst: TextView = itemView.findViewById(R.id.dest_text)
    }
}