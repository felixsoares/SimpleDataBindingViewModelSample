package com.felix.databindingexample.bindable

import android.databinding.BindingAdapter
import android.widget.TextView

/**
 * Created by Felix on 06/04/2018.
 */

@BindingAdapter("color")
fun TextView.setTextColor(color: Int) {
    this.setTextColor(this.context.resources.getColor(color))
}
