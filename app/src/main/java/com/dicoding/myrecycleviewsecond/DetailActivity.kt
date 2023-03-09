package com.dicoding.myrecycleviewsecond

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailActivity : AppCompatActivity() {
    private lateinit var rvDetailHeroes: RecyclerView
    private val detail = ArrayList<HeroDetail>()

    companion object {
        const val EXTRA_HERO = "key_hero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail_hero)

        val dataHero = intent.getParcelableExtra(EXTRA_HERO) as? HeroDetail


        rvDetailHeroes = findViewById(R.id.rv_detail_heroes)
        rvDetailHeroes.setHasFixedSize(true)

        if (dataHero != null) {
            showRecyclerList(dataHero)
        }

        detail.addAll(getDetailHeroes())



//        val dataHero = intent.getParcelableExtra(EXTRA_HERO)
    }

    private fun getDetailHeroes(): ArrayList<HeroDetail> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataOrigin = resources.getStringArray(R.array.data_origin)
        val dataAge = resources.getStringArray(R.array.data_age)
        val dataBirthday = resources.getStringArray(R.array.data_birthday)
        val detailHero = ArrayList<HeroDetail>()
        for (i in dataName.indices) {
            val hero = HeroDetail(dataName[i], dataDescription[i], dataPhoto[i], dataOrigin[i], dataAge[i], dataBirthday[i])
            detailHero.add(hero)
        }
        return detailHero
    }

    private fun showRecyclerList(dataHero: HeroDetail) {
        rvDetailHeroes.layoutManager = LinearLayoutManager(this)
        val detailHeroAdapter = DetailHeroAdapter(detail)
        rvDetailHeroes.adapter = detailHeroAdapter
    }
}
