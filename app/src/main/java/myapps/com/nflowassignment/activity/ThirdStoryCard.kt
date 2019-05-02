package myapps.com.nflowassignment.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import io.reactivex.disposables.Disposable
import myapps.com.nflowassignment.R
import myapps.com.nflowassignment.Util
import myapps.com.nflowassignment.adapter.StoryCardAdapter
import myapps.com.nflowassignment.api.ApiInterface
import myapps.com.nflowassignment.listnerinterface.RecyclerClickListner
import myapps.com.nflowassignment.model.StoryCardModel
import java.util.*
import java.util.stream.Collectors

class ThirdStoryCard : AppCompatActivity() ,RecyclerClickListner{

    var mListRecyclerView: RecyclerView? = null
    var mAdapter: StoryCardAdapter? = null
    var GENDER_MALE:String ="Male"
    var GENDER_FEMALE:String="Female"
    var dataList  =  ArrayList<StoryCardModel>();
    var genderList:ArrayList<StoryCardModel> = ArrayList<StoryCardModel>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_story_card)

        var gender : RadioGroup?= findViewById(R.id.gender)

             getData();
        mListRecyclerView = findViewById(R.id.recyclerView)
        mListRecyclerView?.setLayoutManager( LinearLayoutManager(this));
        mAdapter =  StoryCardAdapter(genderList,this);
        mListRecyclerView?.setAdapter(mAdapter);
        gender?.setOnCheckedChangeListener(
                RadioGroup.OnCheckedChangeListener { group, checkedId ->
                    val radio: RadioButton = findViewById(checkedId)
                    genderList.clear()
                    if(radio.id==R.id.gender_female){

                        getFilterList(GENDER_FEMALE, genderList)

                    }else if(radio.id==R.id.gender_male){
                        getFilterList(GENDER_MALE, genderList)
                    }
                    mAdapter?.notifyDataSetChanged();
                })
    }

    private fun getFilterList(gender :String, filteredDataList:ArrayList<StoryCardModel>) :List<StoryCardModel> {

        //val filteredArticleList = dataList.stream().filter { dataList -> data.category.contains(gender) }.collect(Collectors.toList())
        dataList.forEach(){
            if(it.category.equals( gender)){
                filteredDataList.add(it)
            }
        }

        return Util.sortByDate(filteredDataList)
    }
    override fun onItemSelected(cardModel: StoryCardModel) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(Util.CARDOBJECT, cardModel)
        startActivity(intent)
    }

    private fun getData(): List<StoryCardModel> {

        /*Ryan - 63 - 1546341851000
        Sam - 86 - 1536442851000
        Joey - 78 - 1546442992000
        Melissa - 91 - 1540341851000
        Jess - 93 - 1540341751000
        Carly - 89 - 1540341651000*/
        val storyCardModel1= StoryCardModel("Ryan", 85, "1546341851000",GENDER_MALE)
        dataList.add(storyCardModel1)
        val storyCardModel2= StoryCardModel("Melissa", 90, "1540341851000",GENDER_FEMALE)
        dataList.add(storyCardModel2)
        val storyCardModel3= StoryCardModel("Sam", 86, "1536442851000",GENDER_MALE)
        dataList.add(storyCardModel3)
        val storyCardModel4= StoryCardModel("Joey", 78, "1546442992000",GENDER_MALE)
        dataList.add(storyCardModel4)
        val storyCardModel5= StoryCardModel("Jess", 93, "1540341751000",GENDER_FEMALE)
        dataList.add(storyCardModel5)
        val storyCardModel6= StoryCardModel("Carly", 89, "1540341651000",GENDER_FEMALE)
        dataList.add(storyCardModel6)
        return dataList;
    }



}
