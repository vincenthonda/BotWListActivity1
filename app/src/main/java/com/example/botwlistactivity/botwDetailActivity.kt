package com.example.botwlistactivity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.botwlistactivity.databinding.ActivityBotwDetailBinding
import com.squareup.picasso.Picasso

class botwDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBotwDetailBinding

    companion object {
        val EXTRA_BOTW = "Silver Lynel"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityBotwDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botw = intent.getParcelableExtra<botwItem>(EXTRA_BOTW)
        binding.textViewBotwItemName.text = botw?.name
        Picasso.get().load(botw?.thumbnail).into(binding.imageViewBotwItemImage)
        binding.textViewBotwItemDescription.text = botw?.description
        binding.textViewBotwItemCategory.text = botw?.category
        binding.textViewBotwItemDrops.text = botw?.drops
        binding.textViewBotwItemLocations.text = botw?.locations
        binding.textViewBotwItemID.text = botw?.id.toString()
    }
}