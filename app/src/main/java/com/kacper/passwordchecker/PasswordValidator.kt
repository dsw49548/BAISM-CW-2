package com.kacper.passwordchecker

object PasswordValidator {

    fun hasMinLength(password: String): Boolean = password.length >= 8

    fun hasDigit(password: String): Boolean = password.any { it.isDigit() }

    fun hasUppercase(password: String): Boolean = password.any { it.isUpperCase() }

    fun hasSpecialChar(password: String): Boolean = password.any { !it.isLetterOrDigit() }

    fun strength(password: String): String {
        val score = listOf(
            hasMinLength(password),
            hasDigit(password),
            hasUppercase(password),
            hasSpecialChar(password)
        ).count { it }

        return when (score) {
            4 -> "Silne"
            3 -> "Średnie"
            else -> "Słabe"
        }
    }
}
