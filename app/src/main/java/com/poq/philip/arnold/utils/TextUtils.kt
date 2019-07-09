package com.poq.philip.arnold.utils

import android.view.View
import android.widget.TextView

object TextUtils {
    fun FindTextView(view: View, id: Int): TextView {
        return view.findViewById(id)
    }
    fun FindAndSetText(view: View, id: Int, text: String?) {
        FindTextView(view, id).text = text
    }
}