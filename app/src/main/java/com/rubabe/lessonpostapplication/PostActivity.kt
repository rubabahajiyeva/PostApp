package com.rubabe.lessonpostapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rubabe.lessonpostapplication.adapter.CommentAdapter
import com.rubabe.lessonpostapplication.databinding.ActivityPostBinding
import com.rubabe.lessonpostapplication.model.Comment
import com.rubabe.lessonpostapplication.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    lateinit var post: Post
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPostBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = intent
        post = intent.getSerializableExtra("Post") as Post
        binding.postTitleText.text = post.title
        binding.postBodyText.text = post.body
        binding.commentRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        getComment()
    }

    fun getComment() {

        val api = Constants.getApi()
        api.getComments(post.id).enqueue(object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                val postList: List<Comment> = response.body() as List<Comment>
                binding.commentRecyclerView.adapter = CommentAdapter(this@PostActivity,postList)
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occurred", Toast.LENGTH_LONG).show()
            }

        })
    }
}
