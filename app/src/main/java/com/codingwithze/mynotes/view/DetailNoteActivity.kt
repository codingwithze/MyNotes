package com.codingwithze.mynotes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingwithze.mynotes.R
import com.codingwithze.mynotes.database.Note
import com.codingwithze.mynotes.databinding.ActivityDetailNoteBinding

class DetailNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataIntent()
    }

    private fun getDataIntent() {
        val dataIntent = intent.extras
        val dataNote = dataIntent?.getParcelable<Note>("notedata")

        binding.tvDate.setText(dataNote?.date)
        binding.tvDescription.setText(dataNote?.description)
        binding.toolbar.title = dataNote?.title

        setToolbar()
    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}