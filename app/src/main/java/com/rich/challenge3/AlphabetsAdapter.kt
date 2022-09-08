package com.rich.challenge3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AlphabetsAdapter(val alphabetsList: ArrayList<Alphabets>, val layoutManager: GridLayoutManager):
    RecyclerView.Adapter<AlphabetsAdapter.AlphabetsViewHolder>() {
    val grid_view = 1
    val list_view = 2

    class AlphabetsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bindViewGrid(alphabetParam: Alphabets){
            val btnAlphabets = itemView.findViewById<Button>(R.id.btnAlphabets)
            btnAlphabets.text = alphabetParam.alphabetValue
            btnAlphabets.setOnClickListener {
                val dataBundle = Bundle()
                dataBundle.putString("clickedAlphabet",btnAlphabets.text.toString())
                it.findNavController().navigate(R.id.action_listAlphabetsFragment_to_listWordsFragment,dataBundle)
            }
        }

        fun bindViewList(alphabetParam: Alphabets){
            val btnAlphabets = itemView.findViewById<Button>(R.id.btnText)
            btnAlphabets.text = alphabetParam.alphabetValue
            btnAlphabets.setOnClickListener {
                val dataBundle = Bundle()
                dataBundle.putString("clickedAlphabet",btnAlphabets.text.toString())
                it.findNavController().navigate(R.id.action_listAlphabetsFragment_to_listWordsFragment,dataBundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetsViewHolder {
        var view : View
        if(viewType == grid_view) {
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_alphabets, parent, false)
        }else{
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_words, parent, false)
        }
        return AlphabetsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlphabetsViewHolder, position: Int) {
        if(layoutManager.spanCount == 1){
            holder.bindViewList(alphabetsList[position])
        }else {
            holder.bindViewGrid(alphabetsList[position])
        }
    }

    override fun getItemCount(): Int {
        return alphabetsList.size
    }

    override fun getItemViewType(position: Int): Int {
        val gridCount = layoutManager.spanCount
        if(gridCount == 3){
            return grid_view
        }else{
            return list_view
        }
    }


}