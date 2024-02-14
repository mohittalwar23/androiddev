package com.example.catmeymey.data

import com.example.catmeymey.R
import com.example.catmeymey.model.Cat

object DataSource {

    val cats: List<Cat> = listOf(
        Cat(
            R.drawable.banana,
            "Banana Cat",
            R.raw.banana,
            R.drawable.banana_gif
        ),
        Cat(
            R.drawable.happy,
            "Happy Cat",
            R.raw.happy,
            R.drawable.happy_gif
        ),
        Cat(
            R.drawable.maxwell,
            "Maxwell cat",
            R.raw.maxwell,
            R.drawable.maxwell_gif
        ),
        Cat(
            R.drawable.chippi,
            "Chippi Chippi Cat",
            R.raw.chippi,
            R.drawable.chipi_gif
        ),
        Cat(
            R.drawable.drama,
            "Drama Kitten",
            R.raw.drama,
            R.drawable.drama_gif
        )
    )
}