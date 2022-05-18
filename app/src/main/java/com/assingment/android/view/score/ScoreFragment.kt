package com.assingment.android.view.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.assingment.android.R
import com.assingment.android.model.QuizQuestion
import com.assingment.android.model.QuizUserTaken
import com.assingment.android.view.share.SharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScoreFragment : Fragment() {

    private val layoutId: Int = R.layout.fragment_score

    private val model: SharedViewModel by sharedViewModel()
    private val scoreViewModel: ScoreViewModel by viewModel()

    private lateinit var name: TextView
    private lateinit var score: TextView

    private var readyToInsert = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        name = view.findViewById(R.id.name)
        score = view.findViewById<TextView>(R.id.score)
        val button = view.findViewById<Button>(R.id.ctaButton)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_scoreFragment_to_homeFragment)
        }

        model.pairedViewModel.observe(viewLifecycleOwner) {
            bindData(it)
            insertNewUser(it)
        }
    }

    private fun bindData(dataPair: Pair<String?, MutableList<QuizQuestion>?>) {
        name.text = dataPair.first
        score.text = dataPair.second?.size.toString()
    }

    private fun insertNewUser(dataPair: Pair<String?, MutableList<QuizQuestion>?>) {
        if (readyToInsert) {
            readyToInsert = false
            val newUser = QuizUserTaken(dataPair.first, dataPair.second?.size)
            scoreViewModel.addToDatabase(newUser)
        }
    }

}
