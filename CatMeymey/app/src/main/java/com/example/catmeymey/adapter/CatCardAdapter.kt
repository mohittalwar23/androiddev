package com.example.catmeymey.adapter

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RawRes
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.catmeymey.R
import com.example.catmeymey.SecondActivity
import com.example.catmeymey.data.DataSource
import com.example.catmeymey.model.Cat

class CatCardAdapter(
    private val context: Context?,
    private val layout: Int
) : RecyclerView.Adapter<CatCardAdapter.CatCardViewHolder>() {

    private val cats: List<Cat> = DataSource.cats
    private var mediaPlayer: MediaPlayer? = null

    inner class CatCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView? = view.findViewById(R.id.cat_image)
        val nameTextView: TextView? = view.findViewById(R.id.cat_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatCardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView: View = inflater.inflate(R.layout.vertical, parent, false)
        return CatCardViewHolder(itemView)
    }

    override fun getItemCount(): Int = cats.size

    override fun onBindViewHolder(holder: CatCardViewHolder, position: Int) {
        val currentCat = cats[position]
        holder.imageView?.setImageResource(currentCat.imageResourceId)
        holder.nameTextView?.text = currentCat.name

        // Set a click listener on the itemView (the entire card)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("drawableResourceId", currentCat.drawableResourceId)
            context?.startActivity(intent)

            playMp3(currentCat.soundResourceId)
        }
    }

    private fun playMp3(@RawRes soundResourceId: Int) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(context, soundResourceId)
        mediaPlayer?.start()

        mediaPlayer?.setOnCompletionListener {
            mediaPlayer?.release()
        }
    }

    override fun onViewRecycled(holder: CatCardViewHolder) {
        super.onViewRecycled(holder)
        holder.imageView?.setImageDrawable(null)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        mediaPlayer?.release()
        mediaPlayer = null
        super.onDetachedFromRecyclerView(recyclerView)
    }
}