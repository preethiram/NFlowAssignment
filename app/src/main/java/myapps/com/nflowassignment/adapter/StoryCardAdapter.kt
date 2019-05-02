package myapps.com.nflowassignment.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import myapps.com.nflowassignment.R
import myapps.com.nflowassignment.listnerinterface.RecyclerClickListner
import myapps.com.nflowassignment.model.StoryCardModel


/**
 * Created by Prathima on 5/1/2019.
 */
class StoryCardAdapter (private val list: List<StoryCardModel>, private var recyclerclickListner :RecyclerClickListner) : RecyclerView.Adapter<StoryCardAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val model: StoryCardModel = list[position]

        holder.bind(model, recyclerclickListner)
    }


    override fun getItemCount(): Int = list.size

    class ItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
            RecyclerView.ViewHolder(inflater.inflate(R.layout.category_recycler_item, parent, false)) {
        private var mNameView: TextView? = null
        private var mScoreView: TextView? = null
        private var timestamp: TextView? = null
        private var container: LinearLayout? = null


        init {
            mNameView = itemView.findViewById(R.id.item_name)
            mScoreView = itemView.findViewById(R.id.item_score)
            timestamp = itemView.findViewById(R.id.item_date)
            container=itemView.findViewById(R.id.container)


        }

        fun bind(model: StoryCardModel,recyclerclickListner: RecyclerClickListner) {
            mNameView?.text = model.name
            mScoreView?.text = model.score.toString()
            timestamp?.text = model.date_created

            container?.setOnClickListener(View.OnClickListener {

                recyclerclickListner.onItemSelected(model)
            })
        }

    }

}