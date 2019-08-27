package com.robelseyoum3.weekendexcercise.presenter

import com.robelseyoum3.weekendexcercise.models.teammodels.TeamModel

class BubblePresenter: BasePresenter<BubbleView>() {
    override fun onViewAttached(view: BubbleView) {
        super.onViewAttached(view)
        view.showLoading()
        val number = view.getIntArry()
        
        view.showBubbleSort(bubbleSort(number))

    }

    //bubble sort
    fun bubbleSort(arr: IntArray?): IntArray {
        var swap = true
        while (swap) {
            swap = false
            for (i in 0 until arr!!.size - 1) {
                if (arr[i] > arr[i + 1]) {
                    val temp = arr[i]
                    arr[i] = arr[i + 1]
                    arr[i + 1] = temp

                    swap = true
                }
            }
        }
        return arr!!
    }
}


interface BubbleView: BasePresenter.View{
    fun showLoading()
    fun showBubbleSort(results: IntArray)
    fun getIntArry(): IntArray
}