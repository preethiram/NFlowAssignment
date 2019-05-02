package myapps.com.nflowassignment.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import myapps.com.nflowassignment.R
import myapps.com.nflowassignment.Util
import myapps.com.nflowassignment.adapter.StoryCardAdapter
import myapps.com.nflowassignment.api.ApiClient
import myapps.com.nflowassignment.api.ApiInterface
import myapps.com.nflowassignment.listnerinterface.RecyclerClickListner
import myapps.com.nflowassignment.model.GenderModel
import myapps.com.nflowassignment.model.StoryCardModel
import kotlin.collections.ArrayList

class ThirdStoryCard : AppCompatActivity() ,RecyclerClickListner{
    private var myCompositeDisposable: CompositeDisposable? = CompositeDisposable();
    private var myRetrogenderArrayList:ArrayList<GenderModel> = ArrayList()
    var mListRecyclerView: RecyclerView? = null
    var mAdapter: StoryCardAdapter? = null
    var GENDER_MALE:String ="Male"
    var GENDER_FEMALE:String="Female"
    var dataList  =  ArrayList<StoryCardModel>();
    var genderList:ArrayList<StoryCardModel> = ArrayList<StoryCardModel>();
    var gender : RadioGroup?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_story_card)
       initializeViews()
        getData()
        loadJSON()
        setAdapter()

        gender?.setOnCheckedChangeListener(
                RadioGroup.OnCheckedChangeListener { group, checkedId ->
                    val radio: RadioButton = findViewById(checkedId)
                    genderList.clear()
                    if(radio.id==R.id.gender_female){
                           if(myRetrogenderArrayList.get(1).females!=null)
                          genderList.addAll(myRetrogenderArrayList.get(1).females)
                       // getFilterList(GENDER_FEMALE, genderList)

                    }else if(radio.id==R.id.gender_male){
                        if(myRetrogenderArrayList.get(0).males!=null)
                        genderList.addAll(myRetrogenderArrayList.get(0).males)
                      //  getFilterList(GENDER_MALE, genderList)
                    }
                    mAdapter?.notifyDataSetChanged();
                })
    }


    private fun initializeViews() {
        gender = findViewById(R.id.gender)
        mListRecyclerView = findViewById(R.id.recyclerView)
    }

    private fun setAdapter() {
        mListRecyclerView?.setLayoutManager( LinearLayoutManager(this));
        mAdapter =  StoryCardAdapter(genderList,this);
        mListRecyclerView?.setAdapter(mAdapter);
    }

    private fun getFilterList(gender :String, filteredDataList:ArrayList<StoryCardModel>) :List<StoryCardModel> {

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


    private fun loadJSON() {


        val requestInterface=  ApiClient.getClient().create(ApiInterface::class.java)

        myCompositeDisposable?.add(requestInterface.getGenderData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError))

    }

    private fun handleResponse(genderData: List<GenderModel>) {

        myRetrogenderArrayList.addAll(genderData)

    }

    private fun handleError(error: Throwable) {

        Log.d("ERROR", error.localizedMessage)


    }


    override fun onDestroy() {
        super.onDestroy()
        myCompositeDisposable?.dispose()
    }
}
