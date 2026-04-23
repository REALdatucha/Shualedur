package com.daviti.portfolio

/**
 * WealthManager - ყველა მათემატიკური ოპერაცია ამ კლასში
 *
 * სტუდენტი: დავითი ამირანაშვილი
 * ჯგუფი: 2
 * K = (სახელის ასოები + გვარის ასოები) / დაბადების რიცხვი
 * K = (6 + 12) / 24 = 0.75
 */
object WealthManager {

    private const val NAME_LETTERS    = 6   // დ-ა-ვ-ი-თ-ი
    private const val SURNAME_LETTERS = 12  // ა-მ-ი-რ-ა-ნ-ა-შ-ვ-ი-ლ-ი
    private const val BIRTH_DAY       = 24

    val K: Double = (NAME_LETTERS + SURNAME_LETTERS).toDouble() / BIRTH_DAY  // = 0.75

    /**
     * Final Savings = (Income - Expenses) * K
     */
    fun calculateFinalSavings(income: Double, expenses: Double): Double {
        return (income - expenses) * K
    }

    /**
     * ვალიდაცია: String -> Double? (null = არასწორი)
     */
    fun parseAmount(value: String): Double? {
        val trimmed = value.trim()
        if (trimmed.isEmpty()) return null
        return trimmed.toDoubleOrNull()
    }
}
