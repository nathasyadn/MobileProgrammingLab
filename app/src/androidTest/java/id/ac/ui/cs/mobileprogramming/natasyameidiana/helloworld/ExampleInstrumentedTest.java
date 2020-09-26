package id.ac.ui.cs.mobileprogramming.natasyameidiana.helloworld;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private String stringName;
    private String stringPhone;

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void initValidString() {
        stringName = "Espresso";
        stringPhone = "085782197947";
    }

    @Test
    public void changeText_sameActivity() {
        onView(withId(R.id.inputName))
                .perform(typeText(stringName), closeSoftKeyboard());
        onView(withId(R.id.inputPhone))
                .perform(typeText(stringPhone), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.result))
                .check(matches(withText("Success")));
    }
}