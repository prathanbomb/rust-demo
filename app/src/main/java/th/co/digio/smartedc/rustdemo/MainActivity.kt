package th.co.digio.smartedc.rustdemo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    var textView: TextView? = null

    companion object {
        init {
            System.loadLibrary("rust")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.sample_text)

        // Example of a call to a native method
        startRequestFromJni(this)

    }

    /**
     * A native method that is implemented by the 'rust' native library,
     * which is packaged with this application.
     */
    private external fun startRequestFromJni(callback: MainActivity)

    fun appendToTextView(string: String) {
        textView!!.append(
            """
            $string
            
            """.trimIndent()
        )
    }

    fun hello() {
        Log.d(TAG, "Looks like it works")
    }
}