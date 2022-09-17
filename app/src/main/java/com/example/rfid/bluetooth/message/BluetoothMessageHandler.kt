package com.example.rfid.bluetooth.message

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log

class BluetoothMessageHandler(looper: Looper) : Handler(looper)
{
    val TAG = "bluetooth handler";

    val RECIEVE_MESSAGE = 1

    private val sb = StringBuilder()

    override fun handleMessage(msg: Message)
    {
        when (msg.what) {
            RECIEVE_MESSAGE -> {
                val readBuf = msg.obj as ByteArray
                val strIncom = String(readBuf, 0, msg.arg1)
                sb.append(strIncom) // формируем строку
                val endOfLineIndex: Int = sb.indexOf("\r\n") // определяем символы конца строки
                if (endOfLineIndex > 0) {                                            // если встречаем конец строки,
                    val sbprint: String = sb.substring(0, endOfLineIndex) // то извлекаем строку
                    sb.delete(0, sb.length) // и очищаем sb
                   Log.d(TAG, sbprint);
                }
            }
        }
    }
}