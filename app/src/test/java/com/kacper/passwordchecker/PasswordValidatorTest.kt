package com.kacper.passwordchecker

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {

    @Test
    fun hasMinLength_checksEightCharacters() {
        assertTrue(PasswordValidator.hasMinLength("abcdefgh"))
        assertFalse(PasswordValidator.hasMinLength("abcdefg"))
    }

    @Test
    fun hasDigit_detectsDigit() {
        assertTrue(PasswordValidator.hasDigit("abc1"))
        assertFalse(PasswordValidator.hasDigit("abcd"))
    }

    @Test
    fun hasUppercase_detectsUppercase() {
        assertTrue(PasswordValidator.hasUppercase("abC"))
        assertFalse(PasswordValidator.hasUppercase("abc"))
    }

    @Test
    fun hasSpecialChar_detectsSpecialChar() {
        assertTrue(PasswordValidator.hasSpecialChar("abc!"))
        assertFalse(PasswordValidator.hasSpecialChar("abc1"))
    }

    @Test
    fun strength_weakPassword() {
        assertEquals("Słabe", PasswordValidator.strength("abc"))
    }

    @Test
    fun strength_mediumPassword() {
        assertEquals("Średnie", PasswordValidator.strength("Abcdefg1"))
    }

    @Test
    fun strength_strongPassword() {
        assertEquals("Słabe", PasswordValidator.strength("Abcdef1!"))
    }
}
