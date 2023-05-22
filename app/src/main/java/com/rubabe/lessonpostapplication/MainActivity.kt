package com.rubabe.lessonpostapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rubabe.lessonpostapplication.adapter.OnItemClickListener
import com.rubabe.lessonpostapplication.adapter.PostAdapter
import com.rubabe.lessonpostapplication.databinding.ActivityMainBinding
import com.rubabe.lessonpostapplication.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        getPosts()

    }

    private fun getPosts() {
        val api = Constants.getApi()
        api.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val postList: List<Post> = response.body() as List<Post>
                binding.recyclerView.adapter = PostAdapter(this@MainActivity, postList, object : OnItemClickListener {
                        override fun OnItemClick(item: Post) {
                            val intent = Intent(this@MainActivity,PostActivity::class.java)
                            intent.putExtra("Post",item)
                            startActivity(intent)
                        }
                    })
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "An error has occurred", Toast.LENGTH_SHORT).show()
            }

        })

}
}

