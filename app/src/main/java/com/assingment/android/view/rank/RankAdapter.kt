package com.assingment.android.view.rank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assingment.android.R
import com.assingment.android.model.QuizQuestion
import com.assingment.android.model.QuizUserTaken
import com.assingment.android.view.share.SharedViewModel

class RankAdapter(private val rankList: List<QuizUserTaken>) : RecyclerView.Adapter<RankAdapter.ViewHolder>() {

    override fun getItemCount(): Int = rankList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_rank, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(rankList[position])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.item_rank_name)
        private val score: TextView = view.findViewById(R.id.item_rank_score)

        fun bind(userRank: QuizUserTaken) {
            name.text = userRank.name
            userRank.score?.let { score.setText(it.toString()) }
        }
    }

}