package com.example.practice5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

//class Adaptorrv(val fruits:List<String>):RecyclerView.Adapter<Myviewholder>() { //for list of fruits
class Adaptorrv(val fruitsList:List<Fruits>,val clickListener:(Fruits)->Unit):RecyclerView.Adapter<Myviewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
       val layoutInflater=LayoutInflater.from(parent.context)
        val list=layoutInflater.inflate(R.layout.listitem,parent,false)
        return Myviewholder(list)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        val fruits= fruitsList[position]
//        holder.textview.text= fruits //for list
//        holder.textview.text= fruits.name
        holder.bind(fruits,clickListener)

    }
}
class Myviewholder(val view: View):RecyclerView.ViewHolder(view){
    fun bind(fruits: Fruits,clickListener: (Fruits) -> Unit) {
        val textview = view.findViewById<TextView>(R.id.tvname)
        textview.text=fruits.name
        view.setOnClickListener{
//            Toast.makeText(view.context, "the ${fruits.name} and ${fruits.supplier}", Toast.LENGTH_LONG).show()
            clickListener(fruits)
        }
    }
}