package com.daviti.portfolio.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.daviti.portfolio.R
import com.daviti.portfolio.WealthManager
import java.text.DecimalFormat

/**
 * Fragment 2 — ანალიტიკა
 * Fragment Result API-ით იღებს მონაცემებს InputFragment-იდან
 * გამოთვლები: WealthManager.calculateFinalSavings()
 */
class AnalyticsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_analytics, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val daliTvKValue        = view.findViewById<TextView>(R.id.dali_tv_k_value)
        val daliTvIncomeDisplay = view.findViewById<TextView>(R.id.dali_tv_income_display)
        val daliTvExpensesDisplay = view.findViewById<TextView>(R.id.dali_tv_expenses_display)
        val daliTvNetDisplay    = view.findViewById<TextView>(R.id.dali_tv_net_display)
        val daliTvSavings       = view.findViewById<TextView>(R.id.dali_tv_savings)

        val df = DecimalFormat("#,##0.00")

        // K კოეფიციენტი ყოველთვის ჩანს
        daliTvKValue.text = "K = (6 + 12) / 24 = ${WealthManager.K}"

        // Fragment Result API — ვუსმენთ InputFragment-ის გაგზავნილ მონაცემებს
        setFragmentResultListener("financialData") { _, bundle ->
            val income   = bundle.getDouble("income")
            val expenses = bundle.getDouble("expenses")
            val net      = income - expenses
            val savings  = WealthManager.calculateFinalSavings(income, expenses)

            daliTvIncomeDisplay.text   = "შემოსავალი:         ${df.format(income)} ₾"
            daliTvExpensesDisplay.text = "ხარჯები:               ${df.format(expenses)} ₾"
            daliTvNetDisplay.text      = "სუფთა (I − E):       ${df.format(net)} ₾"
            daliTvSavings.text         = "Final Savings × K:  ${df.format(savings)} ₾"
        }
    }
}
