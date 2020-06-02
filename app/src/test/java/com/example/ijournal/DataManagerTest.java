package com.example.ijournal;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataManagerTest {
    static DataManager sDataManager;

    @BeforeClass
    public static void classSetup(){
        sDataManager = DataManager.getInstance();
    }

    @Before
    public void setUp(){
        sDataManager.getNotes().clear();
        sDataManager.initializeExampleNotes();
    }

    @Test
    public void createNewNote() {
        final CourseInfo course = sDataManager.getCourse("android_async");
        final String noteTitle = "Test Note Title";
        final  String noteText = "Test note text description";

        int noteIndex = sDataManager.createNewNote();
        NoteInfo newNote = sDataManager.getNotes().get(noteIndex);
        newNote.setCourse(course);
        newNote.setTitle(noteTitle);
        newNote.setText(noteText);

        NoteInfo compareNote = sDataManager.getNotes().get(noteIndex);
        assertEquals(compareNote.getText(), noteText);
        assertEquals(compareNote.getTitle(), noteTitle);
        assertEquals(compareNote.getCourse(), course);
    }
}