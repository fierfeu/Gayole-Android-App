package com.example.gayoleapp

import android.util.Log
import android.webkit.WebView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.web.action.AtomAction
import androidx.test.espresso.web.assertion.WebViewAssertions.webMatches
import androidx.test.espresso.web.model.Atoms.getTitle
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.espresso.web.webdriver.DriverAtoms.*
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.`is`
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class Gayole_mainMenu_tests {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun goodWebAppReach() {
        onWebView(withId(R.id.mainView))
                .check(webMatches(getTitle(), `is`("Gayole")))
    }

    @Test
    fun openMainMenuTest() {
        onWebView(withId(R.id.mainView))
                .withElement(findElement(Locator.ID, "mainMenu"))
                .perform(webClick())
                .withElement(findElement(Locator.ID, "mainMenuTitle"))
                .check(webMatches(getText(), `is`("Menu Principal")))
    }

    @Test
    fun loadGameBoard() {
        onWebView()
                .withElement(findElement(Locator.ID, "mainMenu"))
                .perform(webClick())
        val buttons = AtomAction(findMultipleElements(Locator.TAG_NAME, "button"),
                onWebView(withId(R.id.mainView)),
                null).get())
        }
        Log.v("INFO", "buttons= " + buttons.toString())
        var nb = buttons.size
        /*assertThat(buttons.count(), greaterThan(0))
        onWebView().withElement(buttons.first()).perform(webClick())*/
    }
}

