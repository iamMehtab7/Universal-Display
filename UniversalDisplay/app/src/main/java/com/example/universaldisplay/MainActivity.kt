package com.example.universaldisplay
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup button clicks
        findViewById<Button>(R.id.btnInfinix).setOnClickListener {
            openSearchActivity("Infinix Tecno Itel")
        }
        findViewById<Button>(R.id.btnOppo).setOnClickListener {
            openSearchActivity("Oppo Realme OnePlus")
        }
        findViewById<Button>(R.id.btnRedmi).setOnClickListener {
            openSearchActivity("Redmi")
        }
        findViewById<Button>(R.id.btnMoto).setOnClickListener {
            openSearchActivity("Moto")
        }
        findViewById<Button>(R.id.btnVivo).setOnClickListener {
            openSearchActivity("Vivo")
        }
        findViewById<Button>(R.id.btnSamsung).setOnClickListener {
            openSearchActivity("Samsung")
        }
    }

    private fun openSearchActivity(brand: String) {
        val intent = Intent(this, SearchActivity::class.java)
        intent.putExtra("brand", brand)
        startActivity(intent)
    }
}