package com.robelseyoum3.weekendexcercise.common

import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false) : View {

    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

}



fun ImageView.loadUrl(url: String) {
    Picasso.get().load(url).into(this)
}



fun<T> Call<T>.enqueue(callback: CallBackKt<T>.() -> Unit) {

    val callBackKt = CallBackKt<T>()

    callback.invoke(callBackKt)

    this.enqueue(callBackKt)
}

class CallBackKt<T>: Callback<T> {

    var onResponse: ((Response<T>) -> Unit)? = null
    var onFailure: ((t: Throwable?) -> Unit)? = null

    override fun onFailure(call: Call<T>, t: Throwable) {
        onFailure?.invoke(t)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        onResponse?.invoke(response)
    }

}



fun TextView.setBoldAndColorSpannable(myText: String) {

    //here you SpannableString type by feeding the text into SpannableString
    val spannableContent = SpannableString(myText)

    spannableContent.setSpan(StyleSpan(Typeface.BOLD), 0,  ((myText.length/2) - 1), Spannable.SPAN_INCLUSIVE_INCLUSIVE)
    spannableContent.setSpan(ForegroundColorSpan(Color.rgb(72,126,176)), 0, myText.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

    this.text = spannableContent

}