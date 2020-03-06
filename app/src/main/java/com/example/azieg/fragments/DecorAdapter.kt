package com.example.azieg.fragments

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.example.azieg.R
import com.example.azieg.databinding.FragmentDecorItemBinding


import com.example.azieg.fragments.DecorListFragment.OnListFragmentInteractionListener
import com.example.azieg.fragments.dummy.DecorItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_decor_item.view.*


/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class DecorAdapter(
    private val mValues: List<DecorItem>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<DecorAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    private lateinit var binding: FragmentDecorItemBinding

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DecorItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = FragmentDecorItemBinding.inflate(LayoutInflater.from(parent.context))
        val view = binding.root
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        Picasso.get().load(item.imageUrl).placeholder(R.drawable.now_loading).error(R.drawable.error_dino).into(holder.mDecorImage)

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mDecorImage: AppCompatImageView = mView.decor_image
    }
}
