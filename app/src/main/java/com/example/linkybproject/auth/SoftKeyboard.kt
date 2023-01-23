package com.example.linkybproject.auth

import android.os.Handler
import android.os.Message
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import kotlinx.coroutines.delay
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean


class SoftKeyboard(private val layout: ViewGroup, private val im: InputMethodManager) : View.OnFocusChangeListener {
    private val CLEAR_FOCUS = 0
    private var layoutBottom: Int = 0
    private val coords = IntArray(2)
    private var isKeyboardShow = false
    private val softKeyboardThread = SoftKeyboardChangesThread()
    private val editTextList = ArrayList<EditText>()

    private var tempView: View? = null

    init {
        keyboardHideByDefault()
        initEditTexts(layout)
        this.softKeyboardThread.start()
    }

    fun openSoftKeyboard() {
        if (!isKeyboardShow) {
            layoutBottom = getLayoutCoordinates()
            im.toggleSoftInput(0, InputMethodManager.SHOW_IMPLICIT)
            softKeyboardThread.keyboardOpened()
            isKeyboardShow = true
        }
    }

    fun closeSoftKeyboard() {
        if (isKeyboardShow) {
            im.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
            isKeyboardShow = false
        }
    }

    fun setSoftKeyboardCallback(mCallback: SoftKeyboardChanged) {
        softKeyboardThread.callback = mCallback
    }

    fun unRegisterSoftKeyboardCallback() {
        softKeyboardThread.stopThread()
    }

    interface SoftKeyboardChanged {
        fun onSoftKeyboardHide()
        fun onSoftKeyboardShow()
    }

    private fun getLayoutCoordinates(): Int {
        layout.getLocationOnScreen(coords)
        return coords[1] + layout.height
    }

    private fun keyboardHideByDefault() {
        layout.isFocusable = true
        layout.isFocusableInTouchMode = true
    }

    private fun initEditTexts(viewgroup: ViewGroup) {
        val childCount = viewgroup.childCount
        for (i in 0 until childCount) {
            val v = viewgroup.getChildAt(i)
            if (v is ViewGroup) {
                initEditTexts(v)
            }
            if (v is EditText) {
                val editText = v as EditText
                editText.onFocusChangeListener = this
                editText.isCursorVisible = true
                editTextList.add(editText)
            }
        }
    }

    override fun onFocusChange(v: View, hasFocus: Boolean) {
        if (hasFocus) {
            tempView = v
            if (!isKeyboardShow) {
                layoutBottom = getLayoutCoordinates()
                softKeyboardThread.keyboardOpened()
                isKeyboardShow = true
            }
        }
    }

    private val mHandler = object : Handler() {
        override fun handleMessage(m: Message) {
            when (m.what) {
                CLEAR_FOCUS -> {
                    tempView?.clearFocus()
                    tempView = null
                }
            }
        }
    }

    private inner class SoftKeyboardChangesThread : Thread() {
        private val started = AtomicBoolean(true)
        var callback: SoftKeyboardChanged? = null

        override fun run() {
            while (started.get()) {
                // Wait until keyboard is requested to open
                synchronized(this) {
                    try {
//                        this.join()
                        this.stopThread()
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                var currentBottomLocation = getLayoutCoordinates()

                // There is some lag between open soft-keyboard function and when it really appears.
                while (currentBottomLocation == layoutBottom && started.get()) {
                    currentBottomLocation = getLayoutCoordinates()
                }

                if (started.get())
                    callback?.onSoftKeyboardShow()

                // When keyboard is opened from EditText, initial bottom location is greater than layoutBottom
                // and at some moment equals layoutBottom.
                // That broke the previous logic, so I added this new loop to handle this.
                while (currentBottomLocation >= layoutBottom && started.get()) {
                    currentBottomLocation = getLayoutCoordinates()
                }

                // Now Keyboard is shown, keep checking layout dimensions until keyboard is gone
                while (currentBottomLocation != layoutBottom && started.get()) {
                    synchronized(this) {
                        try {
                            this.stopThread()
//                            Thread.sleep(500)
//                            delay(500)
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                    }
                    currentBottomLocation = getLayoutCoordinates()
                }

                if (started.get())
                    callback?.onSoftKeyboardHide()

                // if keyboard has been opened clicking and EditText.
                if (isKeyboardShow && started.get())
                    isKeyboardShow = false

                // if an EditText is focused, remove its focus (on UI thread)
                if (started.get())
                    mHandler.obtainMessage(CLEAR_FOCUS).sendToTarget()
            }
        }

        fun keyboardOpened() {
            synchronized(this) {
//                notify()
                interrupt()
            }
        }

        fun stopThread() {
            synchronized(this) {
                started.set(false)
                interrupt()
            }
        }
    }
}
