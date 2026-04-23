package com.daviti.portfolio.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.daviti.portfolio.R
import com.daviti.portfolio.WealthManager

/**
 * Fragment 1 — შეყვანა
 * მონაცემები გადაეცემა Fragment Result API-ით (setFragmentResult)
 * ID-ები: prefix „dali" (da=ინიციალები, li=გვარის ბოლო 2 ასო)
 */
class InputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_input, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val daliEtIncome   = view.findViewById<EditText>(R.id.dali_et_income)
        val daliEtExpenses = view.findViewById<EditText>(R.id.dali_et_expenses)
        val daliBtnSave    = view.findViewById<Button>(R.id.dali_btn_save)

        daliBtnSave.setOnClickListener {

            // ვალიდაცია WealthManager-ის მეშვეობით
            val income   = WealthManager.parseAmount(daliEtIncome.text.toString())
            val expenses = WealthManager.parseAmount(daliEtExpenses.text.toString())

            if (income == null) {
                daliEtIncome.error = "გთხოვთ შეიყვანოთ სწორი შემოსავალი"
                daliEtIncome.requestFocus()
                return@setOnClickListener
            }

            if (income < 0) {
                daliEtIncome.error = "შემოსავალი უნდა იყოს დადებითი"
                daliEtIncome.requestFocus()
                return@setOnClickListener
            }

            if (expenses == null) {
                daliEtExpenses.error = "გთხოვთ შეიყვანოთ სწორი ხარჯები"
                daliEtExpenses.requestFocus()
                return@setOnClickListener
            }

            if (expenses < 0) {
                daliEtExpenses.error = "ხარჯები უნდა იყოს დადებითი"
                daliEtExpenses.requestFocus()
                return@setOnClickListener
            }

            // გაგზავნა Fragment Result API-ით
            val bundle = Bundle().apply {
                putDouble("income", income)
                putDouble("expenses", expenses)
            }
            setFragmentResult("financialData", bundle)

            // წარმატების შეტყობინება
            daliEtIncome.error   = null
            daliEtExpenses.error = null
        }
    }
}
