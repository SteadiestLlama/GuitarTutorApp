package uk.ac.aber.dcs.cs39440.les35.guitartutorapp.objects;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Note objects stored in the room database, storing the note's name and frequency
 */
@Entity(tableName= "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String noteName;

    private float frequency;

    public String getNoteName() {
        return noteName;
    }

    public int getId(){
        return id;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(short frequency) {
        this.frequency = frequency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Note(String noteName, float frequency){
        this.noteName = noteName;
        this.frequency = frequency;
    }
}
