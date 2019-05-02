package myapps.com.nflowassignment.listnerinterface

import myapps.com.nflowassignment.model.StoryCardModel

/**
 * Created by Prathima on 5/1/2019.
 */
interface RecyclerClickListner {
    public fun onItemSelected(cardModel :StoryCardModel);
}