package com.example.fakeproject

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakeproject.Details.DetailsActivity
import com.example.fakeproject.Model.Post
import com.example.fakeproject.databinding.ActivityMainBinding

const val EXTRA_POST_ID = "EXTRA_POST_ID"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:MainViewModel
    private lateinit var postAdapter: PostAdapter
    private val blogPosts = mutableListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.posts.observe(this, Observer { posts ->
            Log.i(TAG, "Number of Posts are : ${posts.size}")
            blogPosts.addAll(posts)
            postAdapter.notifyDataSetChanged()
        })

        postAdapter =  PostAdapter(this,blogPosts, object :PostAdapter.ItemClickListener{
            override fun onItemClick(post: Post) {
                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtra(EXTRA_POST_ID, post.id)
                startActivity(intent)
            }

        })

        binding.rvPosts.adapter = postAdapter
        binding.rvPosts.layoutManager = LinearLayoutManager(this)
        viewModel.getPosts()






    }
}