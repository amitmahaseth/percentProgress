package com.example.rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private var mContext:Context,private  var textItem:ArrayList<TextData>):
    RecyclerView.Adapter<CustomViewAdapter>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewAdapter {
       val view=LayoutInflater.from(mContext).inflate(R.layout.list_profile,parent,false)
        return CustomViewAdapter(view)
    }

    override fun onBindViewHolder(holder: CustomViewAdapter, position: Int) {

        var listItem=textItem[position]
        holder.tv_name.text=listItem.name


        holder.tv_price.text= textItem.get(position).price.toString()
        holder.tv_count.text=textItem.get(position).countItem.toString()

        holder.image_plus.setOnClickListener {
           if (textItem.get(position).countItem<10){
               val counter=textItem.get(position).countItem+1
               textItem.get(position).countItem=counter
               notifyDataSetChanged()

//               val price=textItem.get(position).basePrice*counter
//               textItem.get(position).price=price
           }
            Toast.makeText(mContext,"hiiiiii",Toast.LENGTH_SHORT).show()
        }


    }

    override fun getItemCount(): Int {

        return textItem.size
    }
}
class CustomViewAdapter(ItemView: View):RecyclerView.ViewHolder(ItemView) {
    var tv_name=itemView.findViewById<TextView>(R.id.tv_name)
    var tv_price=itemView.findViewById<TextView>(R.id.tv_price)
    var image_plus=itemView.findViewById<ImageView>(R.id.image_plus)
    var tv_count=itemView.findViewById<TextView>(R.id.tv_count)
    var image_minus=itemView.findViewById<ImageView>(R.id.image_minus)

}