package com.example.moneyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertNumber = findViewById<EditText>(R.id.idDecimal)
        val usdToPound = findViewById<RadioButton>(R.id.idUSDtoPound)
        val poundToUSD = findViewById<RadioButton>(R.id.idPoundtoUSD)
        val result = findViewById<TextView>(R.id.idResult)
        val button = findViewById<Button>(R.id.idBtnConvert)
         button.setOnClickListener(){
             val money = DecimalFormat("$###,###.00")
             val amount = convertNumber.text.toString().toDouble()
             val conversionRate = .88
             val resultNum: Double?

             if (usdToPound.isChecked){
                if (amount <= 10000.0){
                    resultNum = amount * conversionRate
                    result.text = "$resultNum pounds"
                } else {
                    Toast.makeText(this@MainActivity, "You can only convert $10,000 or less", Toast.LENGTH_LONG).show()
                }
             } else if (poundToUSD.isChecked){
                 if (amount <= 10000.0){
                     resultNum = amount / conversionRate
                     result.text = money.format(resultNum)
                 } else {
                     Toast.makeText(this@MainActivity, "You can only convert 10,000 pounds or less", Toast.LENGTH_LONG).show()
                 }
             }

         }
    }
}