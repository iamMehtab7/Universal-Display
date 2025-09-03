package com.example.universaldisplay

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.BackgroundColorSpan
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SearchActivity : AppCompatActivity() {

    private lateinit var editSearch: EditText
    private lateinit var txtParagraph: TextView
    private lateinit var txtResultCount: TextView
    private lateinit var scrollView: ScrollView
    private lateinit var brandText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        editSearch = findViewById(R.id.editSearch)
        txtParagraph = findViewById(R.id.txtParagraph)
        txtResultCount = findViewById(R.id.txtResultCount)
        scrollView = findViewById(R.id.scrollView)

        // Get brand from intent
        val brand = intent.getStringExtra("brand") ?: "Unknown"
        brandText = getParagraphForBrand(brand)

        txtParagraph.text = brandText

        // Auto search when typing
        editSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim()
                if (query.isNotEmpty()) {
                    highlightAndScroll(brandText, query)
                } else {
                    txtParagraph.text = brandText
                    txtResultCount.text = "Type to search..."
                }
            }
        })
    }

    private fun getParagraphForBrand(brand: String): String {
        return when (brand) {
            "Infinix Tecno Itel" -> "1. Infinix X657 = Infinix X657C = Infinix X657B = Itel Vision 1 Plus = Itel Vision 1 Pro = Itel Vision 2S = Itel P36 = Itel P37 = Itel S16 = Infinix Smart 5A = Infinix Smart 5 = Infinix Hot 10 Lite (tray KF6 = Tecno Spark 7)\n" +
                    "\n" +
                    "2. Infinix Smart HD = Infinix Smart HD 2021 = X612 = X612B\n" +
                    "\n" +
                    "3. Tecno KE5 = Tecno KE5S = Tecno KE5K = Tecno Spark 6 GO = Tecno Spark GO 2020 = SPARKGO 2021\n" +
                    "\n" +
                    "4. Infinix Smart 6 HD = Infinix Smart HD 2022 = Infinix Hot 12i = Infinix Hot 20i = X6511C = X6512 = X665\n" +
                    "\n" +
                    "5. KG5 = BD4 = Tecno POP 5 LTE = BD4J = KG5H = KG5M = Tecno POP 5 PRO = BD4A = BD4H = BD4I = SPARK GO 2022\n" +
                    "\n" +
                    "6. Itel A60 = Itel A60S = Infinix Smart 7 = Tecno Spark 10 = Tecno Pop 7 Pro = Tecno Pop 7 = Tecno Spark 10C = Itel P40 = Tecno Spark Go 2023 = Tecno Spark 10 5G = Infinix Smart 7 HD = X6517 = X669 = BF6 = X6516 = X6515 = KI5Q = KI5N = KI5K = BF7 = BF7H = BF7N = BF7S = P662L = KI8 = X669C = A70 = P40 = A50 = A60 = A60S = S23 = A05S = KI5 = KI8 = P55 5G = Smart 7 = Smart 7 HD = Hot 30i = Spark GO 2023 = Spark 10 = Pop 7 = ZTE A34 = ZTE A54\n" +
                    "\n" +
                    "7. Infinix Hot 9 Play = Infinix Smart 4 Plus = X680B = X680C = X680 = X680F\n" +
                    "\n" +
                    "8. Infinix Hot 10 Play = Infinix Hot 11 Play = Pova Neo = LE6 = Spark 7 = Itel P37 Pro = Vision 2 Plus = P681L = P681LM = X688 = X688B = X688C = LE6H = KF7\n" +
                    "\n" +
                    "9. Infinix Hot 10 = Pova 1 = Pova = Camon 16 = Infinix Hot 10i = Tecno Spark 6 = Infinix Note 8i = X683 = X682B = CE7 = CE7I = X682C = X682 = LD7 = LD7J = X683C = KE7\n" +
                    "\n" +
                    "10. KG6K = A58 PRO = SPARK 8 = SMART 6 PLUS = S17 = A58 = A661W = S661W = A661L = Itel S17 = Itel A58 = Itel A58 Pro = Itel A49 = X6511G\n" +
                    "\n" +
                    "11. Itel Vision 3 = S661L = Tecno Spark 9 = Itel S18 = Itel Vision 3 = Tecno Spark 8C = Tecno Spark 9T = Itel Vision 5 = Itel P38 = KG5P = KG5J = KG5K = KH6 = KG5KS = KG5Q\n" +
                    "\n" +
                    "12. Infinix Note 11 = Infinix Note 12 Turbo = Infinix Note 12 5G = Infinix Note 12 Pro = X663 = X663D = X676B = X670 = X671 = X6716\n" +
                    "\n" +
                    "13. Infinix Smart 6 Plus = Infinix Hot 10S = Infinix Hot 10T = Tecno Spark 7P = Itel P38 Pro = Itel Vision 3 Plus = Infinix Hot 11 = X6823 = X689 = X6823C = X689B = X689D = X689C = X689F = KF7J\n" +
                    "\n" +
                    "14. Infinix Hot 12 = Infinix Note 12i = Infinix Hot 20 = Infinix Hot 20 Play = Pova Neo 2 = Infinix Hot 12 Play = Itel P40 Plus = X6816C = X6816D = X6816 = X6817 = X6819 = X6825 = X6826 = LG6 = LG6N = Pova 4 = LG7N\n" +
                    "\n" +
                    "15. Infinix X650 = KC2 = KC8 = CC7 = Infinix HOT 8 = Infinix HOT 8 PRO = Tecno SPARK 4\n" +
                    "\n" +
                    "16. Tecno KF6 = Tecno SPARK 7T = Tecno SPARK 7 = Tecno KG6 = Infinix X659 = Infinix X658 = Tecno Spark 7T = KF6H = KF6J = KG6 = Tecno Spark 8 (tray KE5)\n" +
                    "\n" +
                    "17. X6525 = X6526 = X6528 = Infinix Smart 8 = Tecno Spark Go 2024 = Infinix Smart 8HD = Tecno Spark 20 = Tecno Spark 20C = Infinix Hot 40i = Tecno Pop 8 = Itel P55 = Itel P55+ = Itel P55T = A666L = Itel S23 Plus = Itel S23+ = Itel S18 Pro = Itel S24 = Itel RS4 = BG7 = KJ5 = BG6 = BG6H = BG6M\n" +
                    "\n" +
                    "18. Infinix Hot 9 = Infinix Hot 9 Pro = Infinix Note 7 Lite = Camon 15 Air = Camon 15 = Tecno Spark 5 Pro = Tecno Spark 5 = X655C = X655 = X655D = X655F = X656 = DC6 = DC7 = KD7 = KD7S = KD7H\n" +
                    "\n" +
                    "19. Itel P36 Play = Itel Vision 1\n" +
                    "\n" +
                    "20. Itel S16 Pro = Itel Vision 2 = L6503\n" +
                    "\n" +
                    "21. Tecno Spark 5 Air = KD6 = KD6A = Tecno Spark 6 Air = KE6 = KE6J = Tecno Pouvoir 4 = LC7 = KE3 = Tecno Pouvoir 4 Pro = LC8 = Tecno Spark 2 Air = Tecno Spark Power 2\n" +
                    "\n" +
                    "22. CK6 = CK7 = CK8N = CK9 = Infinix X6739 = Infinix X678B = Infinix X6710 = Camon 20 = Camon GT 10 Pro = Tecno GT 10 Pro = Tecno Camon 20 = Tecno Camon 20 Pro = Tecno Camon 20 Pro 5G\n" +
                    "\n" +
                    "23. Infinix S5 = Infinix S5 Lite = Tecno Camon 12 Air = KC3 = CC3 = X652\n" +
                    "\n" +
                    "24. X6827 = Infinix Hot 20 Pro = Tecno Spark 8 Pro = KG8 = X6812B = Tecno Camon 17P = CG7 = Tecno Pova = LE6J = Neo 5G = Infinix Zero 5G = X6815B = X6812 = Infinix Hot 11S = Tecno Camon 18 = CH6 = Tecno Camon 19 Neo = CH6I = Infinix Zero 5G 2023 = X6815D = Tecno Camon 18P = CH7N\n" +
                    "\n" +
                    "25. Infinix X693 = Infinix NOTE 10 = Tecno POVA 2 = Tecno POVA 5G = Tecno POVA 3 = LE7 = LE8 = LF7 = Infinix X698 = Infinix X697 = Infinix NOTE 11i = Infinix NOTE 11S = Infinix NOTE 11 PRO\n" +
                    "\n" +
                    "26. X6831 = X6711 = X6838 = X6837 = X6832 = X6836 = Tecno Spark 20 Pro = KJ6 = Infinix Hot 40 = Tecno Spark 10 Pro = KI7 = Infinix Hot 30 5G = Infinix Note 30 5G = Infinix Hot 40 Pro = Pova 5 Pro 5G = LH7N = Tecno Spark 20 Pro 5G = KJ8 = Infinix Note 40X 5G (Version Problem)\n" +
                    "\n" +
                    "27. Itel A06 = Itel A50C = Itel A669W = Itel A669L\n" +
                    "\n" +
                    "28. Soon\n" +
                    "\n" +
                    "29. X668 = X668C = Infinix Hot 12 = Infinix Hot 12 Pro = Tecno Pop 6 Pro = BE4 = Infinix Pop 6 Pro = BE8\n" +
                    "\n" +
                    "30. Infinix Smart 4 = Tecno Pop 3 Plus = BB4K = BB4 = X653C = X653\n" +
                    "\n" +
                    "31. Tecno CC6 = Infinix X655 = Tecno KD7 = Infinix X652B = Tecno KC3 = Tecno KD7H = Tecno CD7 = X655C = X656 = C653C = X6524 = Tecno CD6 = CC6\n" +
                    "\n" +
                    "32. Infinix Hot 50 5G = X6720 = Infinix Hot 50i = X6531 = Infinix Smart 9 = X6532 = Tecno Spark Go 1 = KL4 = Tecno Spark 30 5G = KL8 = Itel P65 = Itel P671L = Tecno Spark 30C = KL5N = Itel A80 = Itel A671LC = Pova 6 Neo 5G = KL8 = Tecno Pop 9 = KL4 = KLT = KL5N = Tecno Pop 9 5G = KL8H = Tecno Spark 30C 5G = X6531B = X6720B = X6532C = Tecno Smart 9 HD = KL4H = Tecno Pop 9 4G = Tecno Spark Go 1S\n" +
                    "\n" +
                    "34. Infinix S4 = X626 = X627 = Infinix Smart 3 Plus\n" +
                    "\n" +
                    "35. X675 = Infinix Hot 11 2022\n" +
                    "\n" +
                    "36. Infinix X662 = KH7H = Tecno Spark 9 Pro = KH7 = KG7 = KG7H = KG6P = Infinix Hot 11 = Tecno Spark 8T = Tecno Spark 8P = X662\n" +
                    "\n" +
                    "37. Tecno KC1 = Tecno KC6 = Tecno Spark Go = Tecno Spark 4 Air\n" +
                    "\n" +
                    "38. Itel Vision 1 = Itel P36 Play\n" +
                    "\n" +
                    "39. Infinix X6511E = Infinix X6511D = Infinix X6511\n" +
                    "\n" +
                    "40. TECNO IN1 = Infinix X5515\n" +
                    "\n" +
                    "41. Tecno KB2 = X5516 = iACE2X\n" +
                    "\n" +
                    "42. CG6 = CG6J = Camon 17 = KF8 = Spark 7 Pro\n" +
                    "\n" +
                    "43. X687 = CE9 = Zero 8i\n" +
                    "\n" +
                    "44. Infinix X695 = Infinix Note 10 Pro\n" +
                    "\n" +
                    "45. Tecno Camon 19 Pro 5G = CI7 = CI7N = Tecno Camon 19 Pro = CI8 = CI8N = Camon 19 = CI6 = CI6N\n" +
                    "\n" +
                    "46. Tecno Camon 30 5G = CL7 = CL7K = Infinix Note 40 5G = Infinix X6852 = Tecno Pova 6 = LI7 = Tecno Pova 6 Pro 5G = LI9 = Tecno Camon 30 = CL6 = CL6K\n" +
                    "\n" +
                    "47. CH9 = Camon 18 Premier\n" +
                    "\n" +
                    "48. Infinix X6811 = Infinix Zero X = Infinix Zero X Pro = Infinix X6811 = Infinix X6811B\n" +
                    "\n" +
                    "49. Infinix X622 = Infinix X623 = Infinix Hot S3X = Infinix Hot 6X\n" +
                    "\n" +
                    "50. Infinix X625C = Infinix Hot 7 = Infinix X625D = Infinix Hot 7 Pro\n" +
                    "\n" +
                    "51. KB3 = KB8 = iSky 3 = Tecno Spark 3 Pro\n" +
                    "\n" +
                    "52. ID3K = ID5A = ID5B = CF7 = CF8 = Camon I2 = Camon I2X = Camon I Air 2 Plus\n" +
                    "\n" +
                    "53. CG8 = Infinix X6810 = Tecno Camon 17 Pro = Infinix Zero X Neo\n" +
                    "\n" +
                    "54. Infinix X690 = Infinix X690B = Infinix Note 7\n" +
                    "\n" +
                    "55. Infinix X666 = Infinix X666B = Infinix Hot 20 5G\n" +
                    "\n" +
                    "56.  Infinix X668 = Infinix X668C = BE8 = BE8I = KH6 = Infinix Hot 12 Pro = Pop 6 Pro"
            "Oppo Realme OnePlus" -> "1. Realme 6 = Realme 6i = Realme 7 = Realme 6s = Realme Narzo 20 Pro = Realme Narzo 30\n" +
                    "\n" +
                    "2. Realme XT = Realme K5 = Realme K1 = Oppo Reno Z = Oppo R15x = Realme X2 = Oppo K1\n" +
                    "\n" +
                    "3. Realme C2 = Oppo A1k\n" +
                    "\n" +
                    "4. Oppo A3s = Oppo A5 = Realme 2 = Realme C1 = Oppo AX5 = Oppo A12e\n" +
                    "\n" +
                    "5. Oppo F1s = Oppo A59 (Old)\n" +
                    "\n" +
                    "6. Oppo A18 = Oppo A38 = Oppo A59 5G = Oppo A57 5G = Oppo A57s = Oppo A57a = Oppo A77 = Oppo A77s = Oppo K10 5G = Oppo A17 = Oppo A17k = Oppo A57 2020 = Oppo A58 5G = Oppo A78 5G = OnePlus Nord N20SE = Oppo A58x 5G = Oppo A56s 5G = Oppo A57e = Oppo A2x 5G = Oppo A3b = Oppo A1x 5G = Oppo A2m 5G = OnePlus Nord N300 5G = Oppo A77 5G = Oppo A78 5G\n" +
                    "\n" +
                    "7. Realme 2 Pro = Realme U1 = Oppo F9 = Oppo F9 Pro\n" +
                    "\n" +
                    "8. Oppo A53 = Oppo A53s = Oppo A53 2020 = Oppo A54 4G = Oppo A55 4G = Oppo A11s = Realme Narzo 20 = Realme 7i = Oppo A33 = Oppo A54 = Oppo A32 = Realme C17 = OnePlus Nord N100 (Tray Oppo A55)\n" +
                    "\n" +
                    "9. Realme Narzo N53 = Realme C53 = Realme C51 = Realme Note 50\n" +
                    "\n" +
                    "10.\n" +
                    "Realme C30 = Realme C30s = Realme C33 = Realme Narzo 50i Prime = Realme C30F\n" +
                    "\n" +
                    "11. Realme C25 = Realme C25s = Realme Narzo 50A = Oppo A16 = Oppo A16s = Oppo A54s = Oppo A54 = Oppo A53s 5G = Oppo A55 5G = Oppo A56 5G (Try C11 only – Crown)\n" +
                    "\n" +
                    "12. Realme C11 = Realme C12 = Realme C15 = Realme Narzo 20 = Realme Narzo 30A = Oppo A15 = Oppo A15s = Oppo A16e = Oppo A16k = Realme Q2i 5G (Try A16 only – Crown)\n" +
                    "\n" +
                    "13. Realme C20 = Realme C11 2021 = Realme Narzo 50i = Realme C21\n" +
                    "\n" +
                    "14. Realme Narzo 10A = Realme Narzo 20A (Tray Realme C3 – Crown)\n" +
                    "\n" +
                    "15. Oppo A5s = Oppo A7 = Oppo A12 = Oppo A11k = Realme 3 = Realme 3i = Oppo A21 = A20 = A22 = A24 = CPH2083 = CPH1901 = RMX1825 = RMX1827 = CPH2083\n" +
                    "\n" +
                    "16. Realme C55 = Realme 11x 5G = Oppo F23 5G = Oppo A58 4G = Realme N55 = Oppo A98 5G = OnePlus Nord CE3 Lite 5G = Realme 11 5G = Realme C67 5G = Oppo K11x = Oppo A1 5G = Realme Narzo 60x 5G = Oppo A79 5G\n" +
                    "\n" +
                    "17. Realme 8i = Realme 9i = Oppo A96 = Realme Narzo 50 = Oppo K10\n" +
                    "\n" +
                    "18. Oppo A52 = Oppo A72 = Oppo A92 = Oppo A52 2020 = Oppo A92 2020 = Oppo A72 2020\n" +
                    "\n" +
                    "19. Realme C35 = Realme Narzo 50A Prime\n" +
                    "\n" +
                    "20. Realme C21Y = Realme C25Y (Single Pata)\n" +
                    "\n" +
                    "21. Realme C3 = Oppo A5 2020 = Oppo A9 2020 = Oppo A31 2020 = Realme 5 = Realme 5s = Realme 5i = Realme 10A = Realme 20A\n" +
                    "\n" +
                    "22. Oppo K3 = Oppo Reno 2Z = Oppo Reno 2F = Realme X\n" +
                    "\n" +
                    "23. Oppo A54 5G = Oppo A74 5G = Oppo A93 5G = Realme Q3 = OnePlus Nord N200\n" +
                    "\n" +
                    "24. Realme 8 5G = Realme 8s 5G = Realme Narzo 30 5G = Oppo A93 = Realme Q3i = Oppo A93s 5G = Realme V13 5G = Oppo K9x = Realme 9 5G = RMX3381 = RMX3388 = RMX3241\n" +
                    "\n" +
                    "25. Oppo F19 = Oppo F19 Pro = Oppo F19s = Oppo A95 4G = Oppo A95 5G = Oppo A94 5G = Oppo A96 5G = Oppo Reno 5Z = Oppo Reno 7Z = Oppo Reno 6Z = Oppo Reno 8Z = Oppo Reno 5F = Oppo Reno 5 Lite = Oppo Reno 6 Lite = Oppo Reno 7 Lite = Oppo Reno 8 Lite = Oppo A94 4G = Oppo A74 4G = Realme X7 = Realme X7 5G = Realme 7 Pro = Realme Q2 5G = Realme V15 = Oppo Reno 4 SE 5G = Realme 8 = Realme 8 Pro = Oppo F21 Pro 5G = CPH2219 = CPH2223 = CPH2285 = CPH2211 = CPH2237 = CPH2343 = CPH2203 = RMX3092 = RMX2170 = RMX2176 = RMX3092 = RMX2173 = RMX3085 = RMX3082 = CPH2341\n" +
                    "\n" +
                    "26. Oppo F15 = Oppo F17 = Oppo A73 = Oppo Reno 3 = Oppo A91 = Oppo K7 = Oppo Reno 3 SE = Find X2 Lite\n" +
                    "\n" +
                    "27. Oppo A18 = Oppo A57 (New)\n" +
                    "\n" +
                    "28. Realme 9i 5G = Realme 10 5G = Realme 10s\n" +
                    "\n" +
                    "29. Realme V25 = Oppo K9s = Realme Q5 = OnePlus Nord CE2 Lite = Realme 9 Pro 5G\n" +
                    "\n" +
                    "30. Realme 12x 5G = Realme C63 5G\n" +
                    "\n" +
                    "31. OnePlus 10R 5G = OnePlus 10T 5G = Oppo Reno 8 Pro 5G = OnePlus Ace = Realme GT Neo 3\n" +
                    "\n" +
                    "32. Realme 9 Pro 5G = Realme 9 Pro = OnePlus Nord CE2 Lite 5G = RMX3471 = CPH2381\n" +
                    "\n" +
                    "33. Oppo Reno 7 4G = Realme 11 4G = Oppo Reno 7 5G = Oppo Reno 8 4G = Oppo Reno 8 5G = Realme 9 4G = Realme 9 Pro Plus 5G = Realme 10 4G = Oppo F21 Pro 4G = Oppo F21s Pro 5G = Oppo Find X5 Lite 5G = OnePlus Nord CE2 5G = Oppo A78 4G = Oppo Reno 8T = Realme Narzo 7 SE 5G = Realme Narzo 50 Pro 5G\n" +
                    "\n" +
                    "34. Oppo A60 = Oppo A80 = Realme C65 = Realme Narzo N65 = Oppo A3 = Oppo A3X = Oppo A3 Pro 5G = Oppo K12X 5G\n" +
                    "\n" +
                    "35. Oppo Reno 8 Pro 5G = OnePlus 10R 5G = OnePlus 10T 5G = OnePlus Ace = Realme GT Neo 3\n" +
                    "\n" +
                    "36. Realme X SuperZoom = Realme X50 5G = Realme X3\n" +
                    "\n" +
                    "37. Oppo A9 = Oppo F11 = Oppo A9X\n" +
                    "\n" +
                    "38. Realme C63 4G = Realme C61 = Realme Narzo N63\n" +
                    "\n" +
                    "39. OnePlus 9R = OnePlus 8T\n" +
                    "\n" +
                    "40. Realme 1 = Oppo F5 Youth\n" +
                    "\n" +
                    "41. Soon\n" +
                    "\n" +
                    "42. OnePlus 4 Lite = Oppo Reno 12F 4G = Oppo Reno 12F 5G = Realme Narzo 70 Pro = Oppo F27 = Oppo Reno 12FS 4G = Oppo Reno 12FS 5G = Realme 12 Plus = Realme Narzo 70 = Realme P1 5G = Realme 12 Plus 5G = Realme P1 5G = Realme Narzo 70 5G = Oppo Reno 12F = Oppo Reno 12F 5G = Realme P3 5G = Oppo Reno 12FS = Oppo Reno 13F = Realme 13 Plus 5G = Oppo F27 5G = Realme 13 4G = Realme 12 4G = Realme Narzo 70 Turbo = Realme P1 Speed 5G = Realme 14 5G = OnePlus Nord CE 4 Lite = Realme Neo 7X = Oppo K12X\n" +
                    "\n" +
                    "43. Oppo Reno 5 4G = Oppo Reno 5 5G = Oppo Reno 6 5G = Oppo Reno 6 4G = OnePlus Nord 2 5G = OnePlus Nord CE 5G = OnePlus Nord 2T 5G = Realme GT Master Edition = Realme X7 Max 5G = Realme GT Neo 2T 5G = Realme GT Neo Fast = Realme Q3 Pro = Realme GT = Realme GT Neo = Oppo Find X3 Lite 5G\n" +
                    "\n" +
                    "44. Realme 10 Pro Plus 5G = Realme 11 Pro 5G = Realme 11 Pro Plus 5G = Realme 12 Pro 5G = Realme 12 Pro Plus 5G = Realme P1 Pro 5G = Oppo F27 Pro Plus 5G = Oppo Reno 11 5G = Oppo Reno 10 5G = Oppo Reno 10 Pro 5G = Oppo Reno 11 Pro 5G = Oppo Reno 8T 5G = Realme Narzo 60 Pro 5G = Oppo Reno 9 5G = Oppo Reno 9 Pro 5G = Oppo A1 Pro 5G\n" +
                    "\n" +
                    "45. Oppo K12 = OnePlus Ace 4 = OnePlus Nord CE 3 = OnePlus Nord CE 4 = Oppo K11 = Oppo Reno 11F = Oppo F25 Pro 5G\n" +
                    "\n" +
                    "46. Oppo A76 = Oppo A36\n" +
                    "\n" +
                    "47. Oppo Reno 5 = OnePlus Nord 2\n" +
                    "\n" +
                    "48. Realme 13 Pro Plus 5G = OnePlus Nord CE4 Lite = Realme 12 4G\n" +
                    "\n" +
                    "49. Oppo K12X = OnePlus Nord CE4 Lite 5G = Oppo F27 5G = Oppo Reno 12F = Oppo Reno 12FS = Oppo Reno 12FS 5G = Oppo Reno 12F 5G = Realme 12 = Realme 13+ 5G = Narzo 70 Turbo = Realme 13 Pro = Realme 13 4G = Oppo Reno 13F = Oppo Reno 13F 5G\n" +
                    "\n" +
                    "50. Realme P3X = Realme 14X = Realme C75 4G = Realme C75 5G = Realme C75X"
            "Redmi" -> "1. Redmi A1 New = Poco C50 = Redmi A1 = Redmi A1 Plus = Redmi A2 = Redmi A2 New = Redmi A2 Plus\n" +
                    "\n" +
                    "2. Redmi 10 Prime = Redmi 10 4G = Redmi Note 11 4G\n" +
                    "\n" +
                    "3. Redmi 9 = Redmi 9 Prime = Poco M2\n" +
                    "\n" +
                    "4. Redmi Note 11 4G = Poco M4 Pro 4G = Redmi Note 11 = Redmi Note 11S = Redmi Note 12S\n" +
                    "\n" +
                    "5. Poco C55 = Redmi 12C = Poco C40 = Redmi 10 = Redmi 10C = Redmi 10 Power = Redmi 11A\n" +
                    "\n" +
                    "6. Redmi 5A = Redmi Go\n" +
                    "\n" +
                    "7. Redmi 6A = Redmi 6\n" +
                    "\n" +
                    "8. Redmi 9A = Redmi 9AT = Redmi 9A Sport = Redmi 9i Sport = Mi 10A = Redmi 9C = Poco C3 = Poco C31 = Redmi 9i = Redmi 10A\n" +
                    "\n" +
                    "9. Redmi 12 5G = Redmi 12 4G = Redmi 13 4G = Redmi 13 5G = Redmi 13X 4G = Poco M6 Pro 5G = Poco M6 Plus 5G = Poco M6 4G = Redmi Note 12R = Redmi Note 13R = Redmi 12 New\n" +
                    "\n" +
                    "10. Redmi 9 Power = Poco M3 = Redmi Note 9 4G (Center Camera) = Redmi 9T\n" +
                    "\n" +
                    "11. Redmi Note 9 Pro = Redmi Note 9 Pro Max = Poco M2 Pro = Redmi Note 10 Lite\n" +
                    "\n" +
                    "12. Redmi 7 = Redmi Y3\n" +
                    "\n" +
                    "13. Soon\n" +
                    "\n" +
                    "14. Redmi Note 10T 5G = Redmi Note 10 5G = Redmi Note 11 SE = Poco M3 Pro 5G\n" +
                    "\n" +
                    "15. Redmi Note 11E = Poco M4 5G = Redmi 11R = Mi 10 5G = Redmi 11 Prime = Poco M5 = Redmi Prime 5G = Redmi 10 5G = Redmi Note 11R = Redmi Note 11 Prime 4G = Poco M4 5G\n" +
                    "\n" +
                    "16. Redmi Note 13 4G = Redmi Note 14 5G = Redmi Note 14 4G = Poco M7 Pro 5G\n" +
                    "\n" +
                    "17. Redmi Note 7 = Redmi Note 7 Pro = Redmi Note 7S\n" +
                    "\n" +
                    "18. Poco X3 = Mi 10i = Redmi Note 9 Pro 5G = Poco X3 Pro\n" +
                    "\n" +
                    "19. Redmi 13C 4G = Redmi 13C 5G = Poco M6 5G = Poco C65\n" +
                    "\n" +
                    "20. Redmi A3 New = Poco C61 = Redmi A3X\n" +
                    "\n" +
                    "21. Redmi Note 12 4G = Redmi Note 12 5G = Poco X5 5G = Redmi Note 12\n" +
                    "\n" +
                    "22. Redmi Note 10 Pro = Redmi Note 10 Pro Max = Redmi Note 11 Pro 4G = Redmi Note 11 Pro 5G = Poco X4 Pro 5G = Mi 11i 5G = Redmi Note 11 Pro Plus = Poco X4 Pro 5G\n" +
                    "\n" +
                    "23. Redmi Note 12 Pro = Redmi Note 12 Pro Plus = Poco X5 Pro\n" +
                    "\n" +
                    "24. Redmi Note 13 = Redmi Note 14\n" +
                    "\n" +
                    "25. Redmi S2 = Redmi Y2\n" +
                    "\n" +
                    "26. iQOO 5 5G = iQOO Z5 5G\n" +
                    "\n" +
                    "27. Redmi 14C = Redmi 14R = Redmi A4 = Redmi A3 Pro = Poco C75 = Redmi 14 New\n" +
                    "\n" +
                    "28. Redmi 11X Pro = Redmi 11i = Poco F3 = Poco F4 = Poco F3 Pro = Redmi K40 = Redmi K40 Pro = Redmi K40 Pro Plus = Redmi K40S = Mi 11X\n" +
                    "\n" +
                    "29. Redmi K20 = Redmi K20 Pro = Mi 9T = Mi 9T Pro\n" +
                    "\n" +
                    "30. Redmi K30S = Mi 10T = Mi 10T Pro\n" +
                    "\n" +
                    "31. Redmi K60 = Redmi K60 Pro = Poco F5 Pro\n" +
                    "\n" +
                    "32. Redmi Note 10 4G = Redmi Note 10S 4G = Redmi Note 11 SE 4G = Poco M5S\n" +
                    "\n" +
                    "33. Redmi Note 13 Pro 5G = Redmi K70E = Poco X6 5G = Poco X6 Pro 5G\n" +
                    "\n" +
                    "34. Redmi 8 = Redmi 8A = Redmi 8A Dual\n" +
                    "\n" +
                    "35. Redmi 6 Pro = Redmi A2 Lite\n" +
                    "\n" +
                    "36. Redmi A2 = Redmi 6X\n" +
                    "\n" +
                    "37. Redmi 10 Prime = Mi 10 4G Global\n" +
                    "\n" +
                    "38. Redmi Note 11 5G = Redmi Note 11T 5G = Redmi Note 11S 5G = Poco M4 Pro 5G\n" +
                    "\n" +
                    "39. Poco F5 = Redmi Note 12 Turbo = Redmi Note 13 5G\n" +
                    "\n" +
                    "40. Redmi K50 = Redmi K50 Pro = Redmi K60E\n" +
                    "\n" +
                    "41. (No data listed)\n" +
                    "\n" +
                    "42. Redmi 11T = Redmi 11T Pro\n" +
                    "\n" +
                    "43. Redmi 11 Lite 5G = Redmi 11 Lite = Redmi 11 Lite 4G = Redmi 11 Lite NE\n" +
                    "\n" +
                    "44. Redmi 13T = Redmi 13T Pro = Redmi K60 Ultra\n" +
                    "\n" +
                    "45. Poco X2 = Poco X2 Pro = Redmi K30 = Redmi K30i = Poco F2"
            "Moto" -> "1. Moto G22 = Moto G32 = Moto E32s\n" +
                    "\n" +
                    "4. Moto Edge 50 Fusion = Moto G85\n" +
                    "\n" +
                    "5. Moto G60 = Moto G60s = Moto G51 5G = Moto G40 Fusion\n" +
                    "\n" +
                    "6. Moto G10 = Moto G20 = Moto G30 = Moto G10 Power\n" +
                    "\n" +
                    "7. Moto G52 = Moto G82 = Moto G71s\n" +
                    "\n" +
                    "8. Moto G22 = Moto E32 = Moto E32s\n" +
                    "\n" +
                    "9. Moto G31 = Moto G41 = Moto G71 INCELL\n" +
                    "\n" +
                    "10. Moto G32 = Moto G73\n" +
                    "\n" +
                    "11. Moto E7 Power = Moto E7 = Moto E7i\n" +
                    "\n" +
                    "12. Moto Edge 30 Fusion = Moto S30 Pro\n" +
                    "\n" +
                    "13. Moto G13 = Moto G23\n" +
                    "\n" +
                    "14. Moto E7 Plus = Moto G9 Play = Moto G9\n" +
                    "\n" +
                    "15. Moto G14 = Moto G54 = Moto G64\n" +
                    "\n" +
                    "16. Moto E30 = Moto E40\n" +
                    "\n" +
                    "17. Moto G7 = Moto G7 Plus\n" +
                    "\n" +
                    "18. Moto G45 5G = Moto G34 = Moto G53 = Moto G23 = Moto G13\n" +
                    "\n" +
                    "22. Moto G04 = Moto G24 = Moto G24 Power (G24p)"
            "Vivo" -> "1. Vivo Y11 = Vivo Y12 = Vivo Y15 = Vivo Y17 = Vivo U10 = Vivo Y3\n" +
                    "\n" +
                    "2. Vivo T3x 5G = Vivo Y200i 5G = Vivo Y58 5G = iQOO Z9x\n" +
                    "\n" +
                    "3. Vivo Y20 = Vivo Y20g = Vivo Y12g = Vivo Y01\n" +
                    "\n" +
                    "4. Vivo Y19 = Vivo U20 = Vivo Y5s = Vivo U3x = iQOO Z5i\n" +
                    "\n" +
                    "5. Vivo Y03 = Vivo Y18 = Vivo T3 Lite 5G = Vivo Y28s 5G = Vivo Y18e = Vivo Y18i = Vivo Y18s = Vivo Z9 Lite 5G = Vivo Y28e 5G = Vivo Y03t\n" +
                    "\n" +
                    "6. Vivo Y22 = Vivo Y17s = Vivo Y22s = Vivo Y22 New = Vivo Y28 5G = Vivo Y33t = Vivo Y36i = Vivo Y36 = Vivo Y12 New\n" +
                    "\n" +
                    "7. Vivo Y91 = Vivo Y91i = Vivo Y90 = Vivo Y91c = Vivo Y93 = Vivo Y95 = Vivo Y1s\n" +
                    "\n" +
                    "8. Vivo Y79 = Vivo Y7 Plus = Vivo Y79a\n" +
                    "\n" +
                    "9. Vivo Y02 = Vivo Y02t = Vivo Y02 New = Vivo Y02a\n" +
                    "\n" +
                    "10. Vivo Y71 = Vivo Y71i = Vivo V7\n" +
                    "\n" +
                    "11. Vivo S1 = Vivo S1 Pro = Vivo Z1x = Vivo Y7s\n" +
                    "\n" +
                    "12. Vivo V17 = Vivo V19 Neo\n" +
                    "\n" +
                    "13. Vivo Z1 Pro = Vivo Z5x\n" +
                    "\n" +
                    "14. Vivo V28 = Vivo Y73 = Vivo V23e 5G = Vivo Y75 4G\n" +
                    "\n" +
                    "15. Vivo V20 = Vivo V21e 4G = Vivo V21e 5G = Vivo V20 2021 = Vivo V21 4G = Vivo V23e = Vivo Y73 4G = Vivo S6 = Vivo Y75 4G = iQOO Z6 4G\n" +
                    "\n" +
                    "16. (OLED ONLY) Vivo V20 = Vivo V23e = Vivo Y75 = Vivo V21e = Vivo Y70 = Vivo X50 Lite = Vivo Y55 = Vivo Y51 OLED\n" +
                    "\n" +
                    "17. Vivo T1 Pro = Vivo V25e 5G = Vivo V25 5G = Vivo V21 5G = Vivo S15e = Vivo S9e\n" +
                    "\n" +
                    "18. Vivo V11 = Vivo V11i = Vivo Z3i = Vivo Y97 = Vivo Z3\n" +
                    "\n" +
                    "19. Vivo Y81 = Vivo Y81i = Vivo Y83 = Vivo Y83 Pro = Vivo Y81s\n" +
                    "\n" +
                    "20. Vivo V9 = Vivo V9 Youth = Vivo V9 Pro = Vivo Y85\n" +
                    "\n" +
                    "21. Vivo Y21 = Vivo Y21s = Vivo Y21a = Vivo Y21e = Vivo Y21t = Vivo Y21g = Vivo Y02s = Vivo Y16 = Vivo Y30 5G = Vivo Y15a = Vivo Y15c = Vivo Y32 = Vivo Y33 5G\n" +
                    "\n" +
                    "22. Vivo Y51 2020 = Vivo Y31 2020 = Vivo Y73 = Vivo Y72s = Vivo Y53s = iQOO Z3 = iQOO U3 = iQOO U3x = Vivo Y33s = Vivo Y31 = Vivo Y15a = Vivo T2x = Vivo Y72 5G = Vivo Y55s 5G = Vivo Y76 5G = Vivo Y76s 5G = Vivo Y75 5G = Vivo Y77 5G = Vivo Y56 5G\n" +
                    "\n" +
                    "23. Vivo Y20 = Vivo Y20a = Vivo Y20t = Vivo Y20s = Vivo Y20i = Vivo Y20g = Vivo Y12g = Vivo Y20sg = Vivo Y12s = Vivo Y12a = Vivo Y20e = Vivo Y30g = Vivo Y31s 5G = Vivo Y15a = Vivo Y11s = Vivo Y12d = Vivo Y20g = Vivo Y12s = Vivo Y15s = Vivo Y01 = iQOO U1x\n" +
                    "\n" +
                    "24. Vivo T2x 5G = Vivo Y56 New = Vivo Y55s = Vivo Y77 5G = Vivo Y72 5G = Vivo Y72t = Vivo Y56 5G = Vivo Y75 5G = Vivo T1 5G = iQOO Z6 5G = iQOO Z6 Lite 5G = Vivo Y56 New\n" +
                    "\n" +
                    "25. Vivo Y27 4G = Vivo Y36 4G\n" +
                    "\n" +
                    "26. Vivo Y35 = Vivo Y35 New\n" +
                    "\n" +
                    "27. Vivo V21e 5G = Vivo S10e = Vivo S6 = Vivo S7e = Vivo Y73s = Vivo Y71t = Vivo Y55 4G = Vivo X50 = Vivo G1\n" +
                    "\n" +
                    "28. Vivo Y03 = Vivo Y18\n" +
                    "\n" +
                    "29. Vivo Y28 4G = Vivo Y38 5G = Vivo Y19s\n" +
                    "\n" +
                    "30. Vivo V27 5G = Vivo S16 = Vivo Y78 Plus = Vivo V29e = Vivo V29 Lite 5G = Vivo Y200 Pro = Vivo T2 Pro 5G = Vivo V27 Pro 5G = Vivo V29 SE 5G = Vivo Y78 5G = Vivo V30e 5G = Vivo Y300 Plus 5G = iQOO Z7 Pro = Vivo S16 = Vivo S16 Pro = Vivo S17e\n" +
                    "\n" +
                    "31. Vivo Y30 4G = Vivo Y50 (Only Crown)\n" +
                    "\n" +
                    "32. Vivo V5 = Vivo Y67\n" +
                    "\n" +
                    "33. Vivo Y78T = Vivo Y78 = Vivo Z8 = Vivo Z8x = Vivo Y100i = Vivo iQOO Z7x = Vivo Y36 5G = Vivo Y36\n" +
                    "\n" +
                    "34. Vivo V15 Pro = Vivo X27\n" +
                    "\n" +
                    "35. Vivo V11 Pro = Vivo X23\n" +
                    "\n" +
                    "36. Vivo V20 Pro = Vivo S7 = Vivo S7t\n" +
                    "\n" +
                    "37. Vivo V23 5G = Vivo S9 = Vivo S10 + Vivo S10 Pro = Vivo S12 Pro\n" +
                    "\n" +
                    "38. Vivo X60 = Vivo X70 = Vivo V2045\n" +
                    "\n" +
                    "39. Vivo iQOO 007 = Vivo iQOO Neo 5s = Vivo iQOO Neo 5 = Vivo S15\n" +
                    "\n" +
                    "40. Vivo Y100 = Vivo Y100A = Vivo Y100 = Vivo Y100 T2 5G = iQOO Z7 5G\n" +
                    "\n" +
                    "41. Vivo Y200 5G = Vivo Y200e 5G = Vivo Y100 = Vivo T3 5G = Vivo V29e\n" +
                    "\n" +
                    "42. Vivo Y52s = Vivo Y75 5G = Vivo Y72 = iQOO Z3 = Vivo Y51 = Vivo Y53s\n" +
                    "\n" +
                    "43. Vivo T4x 5G = iQOO Z10x 5G = Vivo T3x 5G = Vivo Y58 5G = iQOO 29x = Vivo Y200i 5G\n" +
                    "\n" +
                    "44. Vivo V40e = Vivo T3 Pro = iQOO Z9s = iQOO Z9s Pro"
            "Samsung" -> "1. Samsung F22 = Samsung A22 4G = Samsung M22\n" +
                    "\n" +
                    "2. Samsung A12 = Samsung M12 = Samsung F12 = Samsung A02 = Samsung M02 = Samsung A32 5G = Samsung M23 5G = Samsung A125 = Samsung M127 = Samsung A022 = Samsung M022 = Samsung A326 = Samsung M326\n" +
                    "\n" +
                    "3. Samsung M11 = Samsung A11\n" +
                    "\n" +
                    "4. Samsung A04s = Samsung A23 = Samsung A13 5G = Samsung A136 = Samsung A047 = Samsung A047F\n" +
                    "\n" +
                    "5. Samsung A04e = Samsung A02s = Samsung A03s = Samsung M02s = Samsung A03 = Samsung A04 = Samsung F04 = Samsung F02s\n" +
                    "\n" +
                    "6. Samsung J6 Plus = Samsung J4 Plus\n" +
                    "\n" +
                    "7. Samsung A10 = Samsung M10 = Samsung A10s\n" +
                    "\n" +
                    "8. Samsung A30 = Samsung A50 = Samsung A30s = Samsung A50s\n" +
                    "\n" +
                    "9. Samsung A15 = Samsung A15 5G = Samsung F15 = Samsung M15\n" +
                    "\n" +
                    "10. Samsung M21 = Samsung M21s = Samsung M30 = Samsung M30s = Samsung M31 = Samsung F41 = Samsung M31s = Samsung M305 = Samsung M315 = Samsung M307 = Samsung F415\n" +
                    "\n" +
                    "11. Samsung F62 = Samsung M62 = Samsung A71 4G = Samsung A71 5G = Samsung M51\n" +
                    "\n" +
                    "12. Samsung A70 = Samsung A70s = Samsung A707 = Samsung A705\n" +
                    "\n" +
                    "13. Samsung A20 = Samsung A20s\n" +
                    "\n" +
                    "14. Samsung A60 = Samsung M40\n" +
                    "\n" +
                    "15. Samsung A01 Core = Samsung M01 Core = Samsung A013 = Samsung M013\n" +
                    "\n" +
                    "16. Samsung A24 = Samsung A25 = Samsung F34 = Samsung M34\n" +
                    "\n" +
                    "17. Samsung A32 4G = Samsung M32 4G\n" +
                    "\n" +
                    "18. Samsung M01 = Samsung A01 = Samsung M015 = Samsung A015\n" +
                    "\n" +
                    "19. Samsung A05s = Samsung M14 4G = Samsung A057\n" +
                    "\n" +
                    "20. Samsung A13 = Samsung A13 4G = Samsung A13 Lite = Samsung F13 = Samsung M13 = Samsung A135 = Samsung A137\n" +
                    "\n" +
                    "21. Samsung A14 4G = Samsung A14 5G = Samsung A146 = Samsung A146B = Samsung A145F\n" +
                    "\n" +
                    "22. Samsung M14 5G = Samsung F14 5G = Samsung M146B = Samsung E146B\n" +
                    "\n" +
                    "23. Samsung A15 5G = Samsung A15 4G = Samsung F15 5G = Samsung M15 5G\n" +
                    "\n" +
                    "24. Samsung A16 5G = Samsung A16 4G = Samsung A26 5G = Samsung A166P\n" +
                    "\n" +
                    "25. Samsung A22 5G = Samsung F42 5G = Samsung A22s 5G\n" +
                    "\n" +
                    "26. Samsung A23 4G = Samsung A23 5G = Samsung F23 5G = Samsung M23 5G = Samsung M33 5G\n" +
                    "\n" +
                    "27. Samsung A24 = Samsung A25 5G = Samsung M34 5G\n" +
                    "\n" +
                    "28. Samsung A32 4G = Samsung M32 4G\n" +
                    "\n" +
                    "29. Samsung A51 = Samsung A51 5G = Samsung M31s\n" +
                    "\n" +
                    "30. Samsung A52 5G = Samsung A52 4G = Samsung A52s 4G\n" +
                    "\n" +
                    "31. Samsung A53 5G = Samsung A53 4G\n" +
                    "\n" +
                    "32. Samsung A55 5G = Samsung A35 5G = Samsung M35 5G\n" +
                    "\n" +
                    "33. Samsung M52 5G = Samsung M53 5G = Samsung M54 5G = Samsung F54 5G = Samsung M52 = Samsung M54 = Samsung M53\n" +
                    "\n" +
                    "34. Samsung M55 5G = Samsung F55 5G = Samsung C55 5G = Samsung M55s 5G\n" +
                    "\n" +
                    "35. Samsung S20 FE 4G = Samsung S20 FE 5G\n" +
                    "\n" +
                    "36. Samsung A06 5G = Samsung F06 5G = Samsung M06 5G = Samsung A066B = Samsung E066B = Samsung M066B"
            else -> "No data available."
        }
    }

    private fun highlightAndScroll(text: String, word: String) {
        val spannable = SpannableString(text)
        var index = text.indexOf(word, 0, ignoreCase = true)
        var count = 0
        var firstIndex = -1

        while (index >= 0) {
            count++
            spannable.setSpan(
                BackgroundColorSpan(Color.YELLOW),
                index,
                index + word.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            if (firstIndex == -1) firstIndex = index
            index = text.indexOf(word, index + word.length, ignoreCase = true)
        }

        txtParagraph.text = spannable
        txtResultCount.text = "Found $count result(s)"

        if (count > 0 && firstIndex != -1) {
            txtParagraph.post {
                val layout = txtParagraph.layout
                if (layout != null) {
                    val line = layout.getLineForOffset(firstIndex)
                    val y = layout.getLineTop(line)
                    scrollView.smoothScrollTo(0, y)
                }
            }
        }
    }
}
