package com.assingment.android.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.assingment.android.R
import com.assingment.android.view.share.SharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: Fragment() {

    private val layoutId: Int = R.layout.fragment_home
    private val model: SharedViewModel by sharedViewModel()
    private val homeViewModel: HomeViewModel by viewModel()

    private lateinit var inputName: String

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
        val rank = view.findViewById<Button>(R.id.ctaRank)
        val editText = view.findViewById<EditText>(R.id.nameInput)

        homeViewModel.isNameExists.observe(viewLifecycleOwner) { checkName(it) }

        button.setOnClickListener {
            inputName = editText.text.toString()
            val isRequiredToJoin = inputName.isNotBlank() || inputName.isNotEmpty()

            if (isRequiredToJoin) {
                homeViewModel.isNameExists(inputName)
            }
        }

        rank.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_rankFragment)
        }
    }

    private fun checkName(exists: Boolean) {
        if (!exists) {
            model.setName(inputName)
            findNavController().navigate(R.id.action_homeFragment_to_quizFragment)
        }
    }

}
