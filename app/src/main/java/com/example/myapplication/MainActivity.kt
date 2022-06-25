package com.example.myapplication

import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.text.format.DateUtils
import android.view.View
import android.view.ViewStub
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.time.ZoneId
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openPanel (view: View) {
        val posts = findViewById<LinearLayout>(R.id.Posts)
        val panelElement = findViewById<LinearLayout>(R.id.Panel)

        val buttonOpen = findViewById<Button>(R.id.openPanel)
        val buttonClose = findViewById<Button>(R.id.closePanel)
        val buttonAdd = findViewById<Button>(R.id.addNewPost)


        posts.visibility = View.INVISIBLE
        buttonOpen.visibility = View.INVISIBLE

        panelElement.visibility = View.VISIBLE
        buttonClose.visibility = View.VISIBLE
        buttonAdd.visibility = View.VISIBLE

    }

    fun closePanel (view: View ) {
        val posts = findViewById<LinearLayout>(R.id.Posts)
        val panelElement = findViewById<LinearLayout>(R.id.Panel)

        val buttonOpen = findViewById<Button>(R.id.openPanel)
        val buttonClose = findViewById<Button>(R.id.closePanel)
        val buttonAdd = findViewById<Button>(R.id.addNewPost)

        posts.visibility = View.VISIBLE
        buttonOpen.visibility = View.VISIBLE

        panelElement.visibility = View.INVISIBLE
        buttonClose.visibility = View.INVISIBLE
        buttonAdd.visibility = View.INVISIBLE
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addNewPost (view: View) {
        val panelElement = findViewById<LinearLayout>(R.id.Panel)

     /*   val stub = findViewById<ViewStub>(R.id.layout_stub)

        include

        stub.setLayoutResource(panelElement);
        val inflated = stub.inflate()*/


        val buttonOpen = findViewById<Button>(R.id.openPanel)
        val buttonClose = findViewById<Button>(R.id.closePanel)
        val buttonAdd = findViewById<Button>(R.id.addNewPost)

        val title = findViewById<EditText>(R.id.titleInput)
        val description = findViewById<EditText>(R.id.descriptionInput)
        val author = findViewById<EditText>(R.id.authorInput)

        val posts = findViewById<LinearLayout>(R.id.Posts)

        val textTitle = TextView(this)
        val textDescription = TextView(this)
        val textAuthor = TextView(this)
        val textDate = TextView(this)

        textTitle.text = title.text
        textDescription.text = description.text
        textAuthor.text = author.text
        textDate.text = LocalDate.now(ZoneId.systemDefault()).toString()

        textTitle.textSize = 23f;
        textTitle.setTypeface(null, Typeface.BOLD)
        textAuthor.setTypeface(null, Typeface.BOLD)
        textDate.setTypeface(null, Typeface.BOLD)

        posts.addView(textTitle)
        posts.addView(textDescription)
        posts.addView(textAuthor)
        posts.addView(textDate)

        posts.visibility = View.VISIBLE
        buttonOpen.visibility = View.VISIBLE

        panelElement.visibility = View.INVISIBLE
        buttonClose.visibility = View.INVISIBLE
        buttonAdd.visibility = View.INVISIBLE


    }
}