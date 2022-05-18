package com.assingment.android.view.rank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.assingment.android.R
import com.assingment.android.model.QuizUserTaken
import org.koin.androidx.viewmodel.ext.android.viewModel

class RankFragment : Fragment() {

    private val layoutId: Int = R.layout.fragment_rank
    private val rankViewModel: RankViewModel by viewModel()

    private lateinit var rankAdapter: RankAdapter
    private lateinit var rankList: RecyclerView
    private lateinit var list: MutableList<QuizUserTaken>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rankList = view.findViewById(R.id.rank_list)

        rankViewModel.rankScoreList.observe(viewLifecycleOwner) { constructList(it) }
        rankViewModel.getScoreRankFromDB()
    }

    private fun constructList(list: MutableList<QuizUserTaken>) {
        if (list.isNotEmpty()) {
            rankAdapter = RankAdapter(list)
            rankList.adapter = rankAdapter
        }
    }

}