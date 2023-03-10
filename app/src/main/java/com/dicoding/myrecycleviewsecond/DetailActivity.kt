package com.dicoding.myrecycleviewsecond

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_HERO = "key_hero"
        const val EXTRA_ORIGIN = "origin_hero"
        const val EXTRA_AGE = "age_hero"
        const val EXTRA_BIRTHDAY = "birthday_hero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail_hero)

        val dataHero = intent.getParcelableExtra<Hero>(EXTRA_HERO)
        val origin = intent.getStringExtra(EXTRA_ORIGIN)
        val age = intent.getStringExtra(EXTRA_AGE)
        val birthday = intent.getStringExtra(EXTRA_BIRTHDAY)

        val tvDetailName = findViewById<TextView>(R.id.tv_item_name_detail)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_item_description_detail)
        val tvDetailPhoto = findViewById<ImageView>(R.id.img_item_photo_detail)
        val tvDetailOrigin = findViewById<TextView>(R.id.tv_item_origin)
        val tvDetailAge = findViewById<TextView>(R.id.tv_item_age)
        val tvDetailBirthday = findViewById<TextView>(R.id.tv_item_birthday)

        if (dataHero != null) {
            tvDetailName.text = dataHero.name
            tvDetailDescription.text = dataHero.description
            Glide.with(this)
                .load(dataHero.photo)
                .into(tvDetailPhoto)
            tvDetailOrigin.text = origin
            tvDetailAge.text = age
            tvDetailBirthday.text = birthday
        }
    }
}
