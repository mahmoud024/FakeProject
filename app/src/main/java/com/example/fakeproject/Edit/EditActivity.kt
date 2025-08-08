package com.example.fakeproject.Edit

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.fakeproject.Details.EXTRA_POST
import com.example.fakeproject.MainActivity
import com.example.fakeproject.Model.Post
import com.example.fakeproject.R
import com.example.fakeproject.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    private lateinit var viewModel: EditViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_edit)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_edit)
        viewModel = ViewModelProvider(this).get(EditViewModel::class.java)

        val post = intent.getSerializableExtra(EXTRA_POST) as Post
        binding.etTitle.setText(post.title)
        binding.etContent.setText(post.body)

        binding.btnUpdatePut.setOnClickListener {
            Toast.makeText(this,"Updated successfuly!",Toast.LENGTH_SHORT).show()
            viewModel.updatePost(post.id,
                Post(
                    post.userId,
                    post.id,
                    binding.etTitle.text.toString(),
                    binding.etContent.text.toString()
                )
            )
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnDelete.setOnClickListener {
            Toast.makeText(this,"Deleted successfuly!",Toast.LENGTH_SHORT).show()
            viewModel.deletePost(post.id )

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }


    }
}