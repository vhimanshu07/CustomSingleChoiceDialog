package com.example.customsinglechoicedialog

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var btn: TextView
    lateinit var btn2: TextView
    lateinit var btn3: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)
        /**
         *
         * alert  dialog
         *
         */
        val contactDialog = AlertDialog.Builder(this)
            .setTitle("Add contacts")
            .setMessage("Do you want to add contacts?")
            .setIcon(R.drawable.ic_contact)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You added the contact", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "You didn't add the contact", Toast.LENGTH_SHORT)
                    .show()
            }
        btn.setOnClickListener {
            contactDialog.show()
        }

        /**
         *
         * Single choice dialog
         *
         */
        val options = arrayOf("First item", "Second item", "Third item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of the options")
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You Accepted Single choice dialogue", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You Declined Single choice dialogue", Toast.LENGTH_SHORT)
                    .show()
            }
            .setSingleChoiceItems(options, 0) { dialogueinterface, i ->
                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }.create()

        btn2.setOnClickListener {
            singleChoiceDialog.show()
        }

        /**
         *
         * multi choice  dialog
         *
         */
        val checked = booleanArrayOf(true,false,false)
        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of the options")
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You Accepted Multi choice dialogue", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You Declined Multi choice dialogue", Toast.LENGTH_SHORT)
                    .show()
            }
            .setMultiChoiceItems(options, checked) { _, i ,isChecked->
                if(isChecked)
                Toast.makeText(this, "You checked on ${options[i]}", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
            }.create()

        btn3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}