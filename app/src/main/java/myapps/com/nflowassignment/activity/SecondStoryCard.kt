package myapps.com.nflowassignment.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import myapps.com.nflowassignment.R
import myapps.com.nflowassignment.Util
import myapps.com.nflowassignment.model.StoryCardModel
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import java.util.Arrays.asList



class SecondStoryCard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_story_card)
        var details : Button?= findViewById(R.id.btn_details)

        getData()
    }

    private fun getData() :ArrayList<StoryCardModel>{
        val dataList =  ArrayList<StoryCardModel>()
        val storyCardModel1= StoryCardModel("Ryan", 85, "March 30th","")
        dataList.add(storyCardModel1)
        //Melissa / 90% / <~September 21st
        val storyCardModel2= StoryCardModel("Melissa", 90, "September 21st","")
        dataList.add(storyCardModel2)
        //Sam / 98% / <~October 1st
        val storyCardModel3= StoryCardModel("Sam", 98, "October 1st","")
        dataList.add(storyCardModel3)
      return dataList;
    }

    fun getRandomList(list: List<StoryCardModel>): StoryCardModel {
        val randomArray = Arrays.asList(0, 1,0, 2)

        val rand = Random()
        val randomElement = randomArray.get(rand.nextInt(randomArray.size))
        println("\nIndex :" + randomElement)

        return list[randomElement]

    }
    public fun detailsBtnClickEvent(v: View){
        callActivity()


    }

    private fun callActivity() {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(Util.CARDOBJECT, getRandomList(getData()))
        startActivity(intent)
    }

}
