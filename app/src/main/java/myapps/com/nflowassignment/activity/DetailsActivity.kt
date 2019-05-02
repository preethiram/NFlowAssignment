package myapps.com.nflowassignment.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import myapps.com.nflowassignment.R
import myapps.com.nflowassignment.Util
import myapps.com.nflowassignment.model.StoryCardModel

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name : TextView?= findViewById(R.id.txt_name)
        var score : TextView?= findViewById(R.id.txt_score)
        var date : TextView?= findViewById(R.id.txt_date)

        val item = getIntent().getSerializableExtra(Util.CARDOBJECT) as? StoryCardModel

        name?.setText(": "+item?.name)
        score?.setText(": "+item?.score)
        date?.setText(": "+item?.date_created)
    }
}
