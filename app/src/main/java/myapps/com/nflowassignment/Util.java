package myapps.com.nflowassignment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import myapps.com.nflowassignment.model.StoryCardModel;

/**
 * Created by Prathima on 5/1/2019.
 */

public class Util {

    public static String CARDOBJECT="CardObject";
    public static String BASE_URL="https://gist.githubusercontent.com/";

    public static List<StoryCardModel> sortByDate(List<StoryCardModel> list){

        Comparator<StoryCardModel> compareById = new Comparator<StoryCardModel>() {
            @Override
            public int compare(StoryCardModel o1, StoryCardModel o2) {
                return o1.getDate_created().compareTo(o2.getDate_created());
            }
        };

        Collections.sort(list, compareById);

//        Collections.sort(employees, compareById);

//        Collections.sort(employees, compareById.reversed());

        return list;
    }
}
