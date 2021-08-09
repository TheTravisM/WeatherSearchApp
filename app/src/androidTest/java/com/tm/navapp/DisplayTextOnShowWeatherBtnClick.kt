package com.tm.navapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class DisplayTextOnShowWeatherBtnClick {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun displayTextOnBtnClick() {
        val textInputEditText = onView(
            allOf(withId(R.id.textInput_City_Search),
                isDisplayed()))
        textInputEditText.perform(click())

        val textInputEditText2 = onView(
            allOf(withId(R.id.textInput_City_Search),
                isDisplayed()))
        textInputEditText2.perform(replaceText("Cincinnati"), closeSoftKeyboard())

        val textInputEditText3 = onView(
            allOf(withId(R.id.textInput_City_Search),
                isDisplayed()))
        textInputEditText3.perform(pressImeActionButton())

        val materialButton = onView(
            allOf(withId(R.id.btn_Get_Weather),
                isDisplayed()))
        materialButton.perform(click())

        val textView = onView(
            allOf(withId(R.id.text_home),
                isDisplayed()))
        textView.check(matches(isDisplayed()))
    }
}
