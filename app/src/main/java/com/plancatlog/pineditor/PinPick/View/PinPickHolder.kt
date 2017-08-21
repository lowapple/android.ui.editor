package com.plancatlog.pineditor.PinPick.View

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.plancatlog.pineditor.PinPick.Model.PinPickImage
import kotlinx.android.synthetic.main.pinpick_image_view.view.*

/**
 * Created by plancatlog on 2017. 8. 19..
 */

class PinPickHolder(view: View, listener: OnPinPickListener) : RecyclerView.ViewHolder(view), View.OnClickListener {
    interface OnPinPickListener {
        fun onSelect(pinPickHolder: PinPickHolder)
        fun onDeselect(pinPickHolder: PinPickHolder)
    }

    val imageView: ImageView
    val imageNumLayout: FrameLayout
    val imageNum: TextView

    private lateinit var pinpickImage: PinPickImage
    private val onPinPickListener = listener
    private var isSelected = false

    init {
        imageView = view.pinpick_image_thumbnail
        imageNum = view.pinpick_select_num
        imageNumLayout = view.pinpick_select_layout
        imageNumLayout.visibility = View.GONE

        view.setOnClickListener(this)
    }

    fun setPinPick(pinPickImage: PinPickImage) {
        this.pinpickImage = pinpickImage
    }

    override fun onClick(p0: View?) {
        if (isSelected)
            onPinPickListener.onDeselect(this)
        else
            onPinPickListener.onSelect(this)
    }

    fun setSelected(selected: Boolean, count: Int) {
        if (selected) {
            imageNumLayout.visibility = View.VISIBLE
            imageNum.text = count.toString()
        } else {
            imageNumLayout.visibility = View.GONE
        }
    }
}