package asilbek.bsb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TypeRecycler(var list: MutableList<Category>,
                   private val clickListener: (Category) -> Unit) :
    RecyclerView.Adapter<TypeRecycler.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.name)
        var img = itemView.findViewById<ImageView>(R.id.img)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.child_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val card = list.get(position)
        holder.name.text = card.name
        holder.img.setImageResource(card.img)
    }
}