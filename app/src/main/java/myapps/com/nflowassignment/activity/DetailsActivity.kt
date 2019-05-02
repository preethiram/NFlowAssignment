package myapps.com.nflowassignment.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import myapps.com.nflowassignment.R
import myapps.com.nflowassignment.Util
import myapps.com.nflowassignment.model.StoryCardModel

class DetailsActivity : AppCompatActivity() {
       var name:TextView?=null
    var score:TextView?=null
    var date:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         name = findViewById(R.id.txt_name)
         score = findViewById(R.id.txt_score)
         date = findViewById(R.id.txt_date)
         setData()

    }

    private fun setData() {
        val item = getIntent().getSerializableExtra(Util.CARDOBJECT) as? StoryCardModel
        name?.setText(": "+item?.name)
        score?.setText(": "+item?.score)
        date?.setText(": "+item?.date_created)
    }


}
