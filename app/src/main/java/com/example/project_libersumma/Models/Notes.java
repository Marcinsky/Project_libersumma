package com.example.project_libersumma.Models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.junit.Test;

import java.io.Serializable;

@Entity(tableName = "notes")
public class Notes implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int ID = 0;

    @ColumnInfo(name = "title")
    String title = "";

    @ColumnInfo(name = "notes")
    String notes = "";

    @ColumnInfo(name = "date")
    String date = "";

    @ColumnInfo(name = "pinned")
    boolean pinned = false;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    @Test
    public void testGettersAndSetters() {
        Notes notes = new Notes();

        notes.setID(1);
        assertEquals(1, notes.getID());

        notes.setTitle("Test Title");
        assertEquals("Test Title", notes.getTitle());

        notes.setNotes("Test Notes");
        assertEquals("Test Notes", notes.getNotes());

        notes.setDate("2022-04-09");
        assertEquals("2022-04-09", notes.getDate());

        notes.setPinned(true);
        assertTrue(notes.isPinned());
    }

    @Test
    public void testDefaultValues() {
        Notes notes = new Notes();

        assertEquals(0, notes.getID());
        assertEquals("", notes.getTitle());
        assertEquals("", notes.getNotes());
        assertEquals("", notes.getDate());
        assertFalse(notes.isPinned());
    }
}
