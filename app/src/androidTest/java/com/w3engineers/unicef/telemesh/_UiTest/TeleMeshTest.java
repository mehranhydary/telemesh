package com.w3engineers.unicef.telemesh._UiTest;


import android.content.Intent;
import android.support.test.espresso.NoActivityResumedException;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.w3engineers.unicef.telemesh.R;
import com.w3engineers.unicef.telemesh.data.local.usertable.UserEntity;
import com.w3engineers.unicef.telemesh.ui.chat.ChatActivity;
import com.w3engineers.unicef.telemesh.ui.splashscreen.SplashActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TeleMeshTest {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Rule
    public ActivityTestRule<ChatActivity> mChatTestRule = new ActivityTestRule<>(ChatActivity.class, true, false);

    /*@Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_COARSE_LOCATION",
                    "android.permission.WRITE_EXTERNAL_STORAGE");*/

    @Test
    public void teleMeshTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction baseEditText = onView(
                allOf(withId(R.id.edit_text_first_name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.first_name_layout),
                                        0),
                                0)));
        baseEditText.perform(scrollTo(), replaceText("Mimo"), closeSoftKeyboard());

        ViewInteraction baseEditText2 = onView(
                allOf(withId(R.id.edit_text_first_name), withText("Mimo"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.first_name_layout),
                                        0),
                                0)));
        baseEditText2.perform(pressImeActionButton());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction baseEditText3 = onView(
                allOf(withId(R.id.edit_text_last_name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.last_name_layout),
                                        0),
                                0)));
        baseEditText3.perform(scrollTo(), replaceText("Saha"), closeSoftKeyboard());

        ViewInteraction baseEditText4 = onView(
                allOf(withId(R.id.edit_text_last_name), withText("Saha"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.last_name_layout),
                                        0),
                                0)));
        baseEditText4.perform(pressImeActionButton());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.image_view_camera),
                        childAtPosition(
                                allOf(withId(R.id.image_layout),
                                        childAtPosition(
                                                withId(R.id.scrollview),
                                                0)),
                                2)));
        appCompatImageView.perform(scrollTo(), click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction constraintLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recycler_view),
                                childAtPosition(
                                        withId(R.id.profile_image_layout),
                                        1)),
                        3),
                        isDisplayed()));
        constraintLayout.perform(click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction profileImageLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recycler_view),
                                childAtPosition(
                                        withId(R.id.profile_image_layout),
                                        1)),
                        0),
                        isDisplayed()));
        profileImageLayout.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.menu_done), withText("Done"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        2),
                                0),
                        isDisplayed()));
        actionMenuItemView.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatImageView1 = onView(
                allOf(withId(R.id.image_view_camera),
                        childAtPosition(
                                allOf(withId(R.id.image_layout),
                                        childAtPosition(
                                                withId(R.id.scrollview),
                                                0)),
                                2)));
        appCompatImageView1.perform(scrollTo(), click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction reSelectImage = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recycler_view),
                                childAtPosition(
                                        withId(R.id.profile_image_layout),
                                        1)),
                        6),
                        isDisplayed()));
        reSelectImage.perform(click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.menu_done), withText("Done"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        2),
                                0),
                        isDisplayed()));
        actionMenuItemView2.perform(click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction baseButton = onView(
                allOf(withId(R.id.button_signup), withText("Sign Up"),
                        childAtPosition(
                                allOf(withId(R.id.image_layout),
                                        childAtPosition(
                                                withId(R.id.scrollview),
                                                0)),
                                5)));
        baseButton.perform(scrollTo(), click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction bottomNavigationMessageFeed = onView(
                allOf(withId(R.id.action_message_feed),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_navigation),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationMessageFeed.perform(click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction bottomNavigationSurvey = onView(
                allOf(withId(R.id.action_survey),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_navigation),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationSurvey.perform(click());

        ViewInteraction bottomNavigationSettings = onView(
                allOf(withId(R.id.action_setting),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_navigation),
                                        0),
                                3),
                        isDisplayed()));
        bottomNavigationSettings.perform(click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction viewProfile = onView(
                allOf(withId(R.id.layout_view_profile),
                        childAtPosition(
                                allOf(withId(R.id.layout_settings),
                                        childAtPosition(
                                                withId(R.id.layout_scroll),
                                                0)),
                                0)));
        viewProfile.perform(scrollTo(), click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction switchCompat = onView(
                allOf(withId(R.id.notification_switch),
                        childAtPosition(
                                allOf(withId(R.id.item_notification_settings),
                                        childAtPosition(
                                                withId(R.id.layout_notification_sound),
                                                0)),
                                2)));
        switchCompat.perform(scrollTo(), click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction constraintLayout2 = onView(
                allOf(withId(R.id.layout_choose_language),
                        childAtPosition(
                                allOf(withId(R.id.layout_settings),
                                        childAtPosition(
                                                withId(R.id.layout_scroll),
                                                0)),
                                2)));
        constraintLayout2.perform(scrollTo(), click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.radio_bangla), withText("বাংলা"),
                        childAtPosition(
                                allOf(withId(R.id.radio_group_language),
                                        childAtPosition(
                                                withId(R.id.alert_buy_sell_dialog_layout),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatRadioButton.perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction bottomNavigationItemView2 = onView(
                allOf(withId(R.id.action_setting),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_navigation),
                                        0),
                                3),
                        isDisplayed()));
        bottomNavigationItemView2.perform(click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction constraintLayoutCooseLanguage = onView(
                allOf(withId(R.id.layout_choose_language),
                        childAtPosition(
                                allOf(withId(R.id.layout_settings),
                                        childAtPosition(
                                                withId(R.id.layout_scroll),
                                                0)),
                                2)));
        constraintLayoutCooseLanguage.perform(scrollTo(), click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatRadioButton2 = onView(
                allOf(withId(R.id.radio_english), withText("English"),
                        childAtPosition(
                                allOf(withId(R.id.radio_group_language),
                                        childAtPosition(
                                                withId(R.id.alert_buy_sell_dialog_layout),
                                                1)),
                                0),
                        isDisplayed()));
        appCompatRadioButton2.perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction bottomNavigationItemViewSettings = onView(
                allOf(withId(R.id.action_setting),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_navigation),
                                        0),
                                3),
                        isDisplayed()));
        bottomNavigationItemViewSettings.perform(click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction actionOnWallet = onView(
                allOf(withId(R.id.layout_open_wallet),
                        childAtPosition(
                                allOf(withId(R.id.layout_settings),
                                        childAtPosition(
                                                withId(R.id.layout_scroll),
                                                0)),
                                4)));
        actionOnWallet.perform(scrollTo(), click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.button_buy), withText("Buy Data"),
                        childAtPosition(
                                allOf(withId(R.id.button_view),
                                        childAtPosition(
                                                withId(R.id.my_wallet_layout),
                                                2)),
                                0),
                        isDisplayed()));
        appCompatButton.perform(click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.button_buy), withText("Buy Data"),
                        childAtPosition(
                                allOf(withId(R.id.transaction_layout),
                                        childAtPosition(
                                                withId(R.id.buy_data_layout),
                                                2)),
                                1),
                        isDisplayed()));
        appCompatButton2.perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.confirmation_ok), withText("OK"),
                        childAtPosition(
                                allOf(withId(R.id.alert_buy_sell_dialog_layout),
                                        childAtPosition(
                                                withId(android.R.id.custom),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatButton3.perform(click());

//        pressBack();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.button_buy), withText("Buy Data"),
                        childAtPosition(
                                allOf(withId(R.id.button_view),
                                        childAtPosition(
                                                withId(R.id.my_wallet_layout),
                                                2)),
                                0),
                        isDisplayed()));
        appCompatButton4.perform(click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButtonSellData = onView(
                allOf(withId(R.id.button_sell), withText("Sell Data"),
                        childAtPosition(
                                allOf(withId(R.id.button_view),
                                        childAtPosition(
                                                withId(R.id.my_wallet_layout),
                                                2)),
                                1),
                        isDisplayed()));
        appCompatButtonSellData.perform(click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButtonAgain = onView(
                allOf(withId(R.id.button_buy), withText("Sell Data"),
                        childAtPosition(
                                allOf(withId(R.id.sell_transaction_layout),
                                        childAtPosition(
                                                withId(R.id.sell_data_layout),
                                                2)),
                                1),
                        isDisplayed()));
        appCompatButtonAgain.perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.confirmation_ok), withText("OK"),
                        childAtPosition(
                                allOf(withId(R.id.alert_buy_sell_dialog_layout),
                                        childAtPosition(
                                                withId(android.R.id.custom),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatButton6.perform(click());

//        pressBack();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.button_sell), withText("Sell Data"),
                        childAtPosition(
                                allOf(withId(R.id.button_view),
                                        childAtPosition(
                                                withId(R.id.my_wallet_layout),
                                                2)),
                                1),
                        isDisplayed()));
        appCompatButton8.perform(click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction constraintLayout3 = onView(
                allOf(withId(R.id.layout_about_us),
                        childAtPosition(
                                allOf(withId(R.id.layout_settings),
                                        childAtPosition(
                                                withId(R.id.layout_scroll),
                                                0)),
                                5)));
        constraintLayout3.perform(scrollTo(), click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction constraintLayoutShareApp = onView(
                allOf(withId(R.id.layout_share_app),
                        childAtPosition(
                                allOf(withId(R.id.layout_settings),
                                        childAtPosition(
                                                withId(R.id.layout_scroll),
                                                0)),
                                3)));
        constraintLayoutShareApp.perform(scrollTo(), click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction constraintLayoutPrivacyPolicy = onView(
                allOf(withId(R.id.layout_privacy_policy),
                        childAtPosition(
                                allOf(withId(R.id.layout_settings),
                                        childAtPosition(
                                                withId(R.id.layout_scroll),
                                                0)),
                                6)));
        constraintLayoutPrivacyPolicy.perform(scrollTo(), click());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction bottomNavigationContacts = onView(
                allOf(withId(R.id.action_contact),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_navigation),
                                        0),
                                0),
                        isDisplayed()));
        bottomNavigationContacts.perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        UserEntity userEntity = new UserEntity()
                .setAvatarIndex(1)
                .setOnline(true)
                .setMeshId("0xaa2dd785fc60eeb8151f65b3ded59ce3c2f12ca4")
                .setUserFirstName("Daniel")
                .setUserLastName("Alvez");
        userEntity.setId(0);

        Intent intent = new Intent();
        intent.putExtra(UserEntity.class.getName(), userEntity);
        mChatTestRule.launchActivity(intent);

        /*ViewInteraction constraintLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.contact_recycler_view),
                                childAtPosition(
                                        withId(R.id.mesh_contact_layout),
                                        0)),
                        0),
                        isDisplayed()));
        constraintLayout2.perform(click());*/

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*ViewInteraction baseEditText5 = onView(
                allOf(withId(R.id.edit_text_message),
                        childAtPosition(
                                allOf(withId(R.id.input_field),
                                        childAtPosition(
                                                withId(R.id.message_layout),
                                                5)),
                                0),
                        isDisplayed()));
        baseEditText5.perform(replaceText("hi"), closeSoftKeyboard());

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.image_view_send),
                        childAtPosition(
                                allOf(withId(R.id.input_field),
                                        childAtPosition(
                                                withId(R.id.message_layout),
                                                5)),
                                1),
                        isDisplayed()));
        appCompatImageView2.perform(click());*/

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            pressBack();
        } catch (NoActivityResumedException e) {
            e.printStackTrace();
        }
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
