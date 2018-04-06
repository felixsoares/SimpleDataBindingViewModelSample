package com.felix.databindingexample.bindable

import android.databinding.BindingAdapter
import android.widget.EditText
import com.felix.databindingexample.util.Mask

/**
 * Created by Felix on 06/04/2018.
 */

@BindingAdapter("maskFormat")
fun EditText.setMaskFormat(maskFormat: String) {
    this.addTextChangedListener(Mask.mask(maskFormat, this))
}
