package com.rich.challenge3

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class AlphabetsAdapter(private val alphabetsList: ArrayList<Alphabets>):
    RecyclerView.Adapter<AlphabetsAdapter.AlphabetsViewHolder>() {

    class AlphabetsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        fun bindView(alphabetParam: Alphabets){
            val btnAlphabets = itemView.findViewById<Button>(R.id.btnAlphabets)
            btnAlphabets.text = alphabetParam.alphabetValue
            btnAlphabets.setOnClickListener {
                var activity : AppCompatActivity = itemView.context as AppCompatActivity
                val wordsFragment = ListWordsFragment(btnAlphabets.text.toString())
                activity.supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,wordsFragment).addToBackStack("frag").commit()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_alphabets,parent,false)
        return AlphabetsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlphabetsViewHolder, position: Int) {
        holder.bindView(alphabetsList[position])
    }

    override fun getItemCount(): Int {
        return alphabetsList.size
    }
}