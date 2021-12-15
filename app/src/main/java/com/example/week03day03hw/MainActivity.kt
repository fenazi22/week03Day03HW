package com.example.week03day03hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    var edSearch:EditText? = null
    var listViews1:ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectViews()
        prepareListViews()
    }
    private fun connectViews (){
        edSearch = findViewById(R.id.edSearch);listViews1=findViewById(R.id.listViews1) }
        private fun prepareListViews(){
            var array:ArrayList<String> = arrayListOf()
            array.add("Faisal")
            array.add("Ali")
            array.add("omar")
            array.add("Salam")
            array.add("Mohammed")
            array.add("Abdullah")
            var arrayAdapter:ArrayAdapter<String> = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,array)
            listViews1?.adapter=arrayAdapter
            listViews1?.setOnItemClickListener { parent, view, position, id ->
                Log.i("ClickListener","${array.get(position)}")
            }
            edSearch?.addTextChangedListener {
                arrayAdapter.filter.filter(it)
            }
        }
}