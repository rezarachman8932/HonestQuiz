package com.assingment.android.view.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.assingment.android.R
import com.assingment.android.view.share.SharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class QuizFragment: Fragment() {

    private val layoutId: Int = R.layout.fragment_quiz
    private val quizViewModel : QuizViewModel by sharedViewModel()
    private val model: SharedViewModel by sharedViewModel()

    private lateinit var next: Button
    private lateinit var back: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.ctaButton)
        val pager = view.findViewById<ViewPager2>(R.id.pager)
        next = view.findViewById(R.id.nextButton)
        back = view.findViewById(R.id.backButton)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_quizFragment_to_scoreFragment)
        }

        quizViewModel.quizQuestions.observe(viewLifecycleOwner) {
            pager.adapter = QuizAdapter(it, model)
        }

        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                quizViewModel.page = position
            }
        })

        checkCurrentPage()

        next.setOnClickListener {
            pager.setCurrentItem(quizViewModel.page + 1, true)
            checkCurrentPage()
        }

        back.setOnClickListener {
            pager.setCurrentItem(quizViewModel.page - 1, true)
            checkCurrentPage()
        }

        quizViewModel.getQuiz()
    }

    private fun checkCurrentPage() {
        val lastIndex = quizViewModel.quizQuestions.value?.size?.minus(1)

        when (quizViewModel.page) {
            0 -> {
                back.visibility = View.GONE
            }
            lastIndex -> {
                next.visibility = View.GONE
            }
            else -> {
                next.visibility = View.VISIBLE
                back.visibility = View.VISIBLE
            }
        }
    }

}
