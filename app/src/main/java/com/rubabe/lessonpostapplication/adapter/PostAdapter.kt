package com.rubabe.lessonpostapplication.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rubabe.lessonpostapplication.MainActivity
import com.rubabe.lessonpostapplication.R
import com.rubabe.lessonpostapplication.model.Post

class PostAdapter(val mContext: MainActivity, list: List<Post>, val listener: OnItemClickListener) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    var list : List<Post>
    init {
        this.list=list
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.titleText)
        var body = itemView.findViewById<TextView>(R.id.bodyText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.posts_row,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.title.text = item.title
        holder.body.text = item.body
        holder.itemView.setOnClickListener {
            listener.OnItemClick(list[position])
        }
    }


}
interface OnItemClickListener{
    fun OnItemClick(item : Post)
}