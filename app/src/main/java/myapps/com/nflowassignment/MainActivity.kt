package myapps.com.nflowassignment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import java.text.SimpleDateFormat
import java.util.*
import android.widget.Toast





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var name :TextView?= findViewById(R.id.txt_name)
        var score :TextView?= findViewById(R.id.txt_score)
        var date :TextView?= findViewById(R.id.txt_date)
        /*val score=findViewById<TextView>(R.id.txt_score) as TextView
        val date=findViewById<TextView>(R.id.txt_date) as TextView*/
        name?.setText(": "+"Ryan")
        score?.setText(": "+"45")
        date?.setText(": "+getDate())

    }

    private fun getDate(): String {
        val c = Calendar.getInstance()
        System.out.println("Current time => " + c.time)

        val df = SimpleDateFormat("MM-dd-yyyy HH:mm:ss")
        val formattedDate = df.format(c.time)

        return formattedDate.toString()
    }


}
