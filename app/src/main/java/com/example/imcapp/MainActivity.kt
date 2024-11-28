package com.example.imcapp

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.RangeSlider

class MainActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    //private val selectedColor = ContextCompat.getColor(this, R.color.secondary)
    //private val defaultColor = ContextCompat.getColor(this, R.color.component)

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            //selectedCard(viewMale)
            //deselectedCard(viewFemale)
            ChangeGender(isMaleSelected)
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            //selectedCard(viewFemale)
            //deselectedCard(viewFemale)
            ChangeGender(isFemaleSelected)
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }
    }

    //private fun selectedCard(cardView: CardView) {
    //    cardView.setCardBackgroundColor(selectedColor)
    //}

    //private fun deselectedCard(cardView: CardView) {
    //    cardView.setCardBackgroundColor(defaultColor)
    //}

    private fun ChangeGender(isSelectedComponent: Boolean) {
        if(isMaleSelected == true) {
            viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        }else if(isFemaleSelected == true) {
            viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
        }
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {

        val colorReference = if (isSelectedComponent) {
            R.color.secondary
        } else {
            R.color.component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
    }
}