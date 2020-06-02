package com.example.ijournal;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.*;
import  static androidx.test.espresso.action.ViewActions.*;
import  static androidx.test.espresso.matcher.ViewMatchers.*;
import  static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;

@RunWith(AndroidJUnit4.class)
public class NoteCreationTest {
    @Rule
    public ActivityTestRule<JornaList2Activity> mJornaList2ActivityActivityTestRule =
            new ActivityTestRule<>(JornaList2Activity.class);

    @Test
    public void createNewNote(){
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.text_note_title)).perform(typeText("Note title"));
        onView(withId(R.id.text_note_text)).perform(typeText("This is a test text note"), closeSoftKeyboard());
    }
}