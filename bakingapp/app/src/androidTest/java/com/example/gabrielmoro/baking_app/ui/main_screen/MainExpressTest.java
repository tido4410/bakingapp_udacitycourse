package com.example.gabrielmoro.baking_app.ui.main_screen;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.gabrielmoro.baking_app.R;
import com.example.gabrielmoro.baking_app.ui.recipe_detail_screen.RecipeDetailActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Reference: https://developer.android.com/training/testing/ui-testing/espresso-testing
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainExpressTest {

    @Rule
    public ActivityTestRule<MainActivity> launchActivity = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public ActivityTestRule<RecipeDetailActivity> detailActivity = new ActivityTestRule<>(RecipeDetailActivity.class);

    @Before
    public void setup() {
        waitFor(1000);
    }

    @Test
    public void selectTheFirstRecipeToShowTheIngredients() {
        onView(withId(R.id.rvRecipes)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.rvIngredients)).check(matches(isDisplayed()));
    }

    @Test
    public void selectTheFirstRecipeToShowTheSteps() {
        onView(withId(R.id.rvRecipes)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.rvSteps)).check(matches(isDisplayed()));
        detailActivity.finishActivity();
    }

    @Test
    public void selectTheSecondRecipeToShowTheIngredients() {
        onView(withId(R.id.rvRecipes)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(withId(R.id.rvIngredients)).check(matches(isDisplayed()));
    }

    @Test
    public void selectTheSecondRecipeToShowTheSteps() {
        onView(withId(R.id.rvRecipes)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(withId(R.id.rvSteps)).check(matches(isDisplayed()));
        detailActivity.finishActivity();
    }

    private void waitFor(long milisseconds) {
        try {
            Thread.sleep(milisseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
