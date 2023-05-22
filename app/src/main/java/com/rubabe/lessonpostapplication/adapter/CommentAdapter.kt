package com.rubabe.lessonpostapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rubabe.lessonpostapplication.R
import com.rubabe.lessonpostapplication.model.Comment

class CommentAdapter(val mContext: Context, var list : List<Comment>) : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.nameText)
        var email = itemView.findViewById<TextView>(R.id.emailText)
        var comment = itemView.findViewById<TextView>(R.id.commnetText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.comment_row,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.email.text = list[position].email
        holder.comment.text = list[position].body
    }

    override fun getItemCount(): Int {
        return list.size
    }

}