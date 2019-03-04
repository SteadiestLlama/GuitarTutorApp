package uk.ac.aber.dcs.cs39440.les35.guitartutorapp.datasource;

import android.app.Application;
import android.os.AsyncTask;

import java.util.Arrays;
import java.util.List;

import uk.ac.aber.dcs.cs39440.les35.guitartutorapp.model.NotesDAO;
import uk.ac.aber.dcs.cs39440.les35.guitartutorapp.objects.MyApplication;
import uk.ac.aber.dcs.cs39440.les35.guitartutorapp.objects.Note;

public class NotesRepository {
    // Data access object to allow interaction with the Notes table/entity
    private NotesDAO noteDAO;
    private Note[] notesList;

    public NotesRepository(Application application){
        GuitarRoomDatabase db = GuitarRoomDatabase.getDatabase(application);
        noteDAO = db.getNotesDao();
        notesList = noteDAO.getAllNotes();
    }

    /**
     * Public call for inserting a note into the room database Notes table.
     * Creates a new instance of the corresponding extension of AsyncTask and
     * @param notes The notes that are being added to the table.
     */
    public void insert(Note[] notes){

        new InsertAsyncTask(noteDAO).execute(notes);
    }

    public Note[] getNotesList() {
        return notesList;
    }

    public Note getNoteByName(String noteName){
       Note note = noteDAO.getNoteByName(noteName);
        return note;
    }

    public Note getNoteBefore(int id){
        Note note = noteDAO.getNoteBefore(id);
        return note;
    }

    public Note getNoteAfter(int id){
        Note note = noteDAO.getNoteAfter(id);
        return note;
    }

    static class InsertAsyncTask extends AsyncTask<Note, Void, Void> {
        private NotesDAO mAsyncTaskDao;

        InsertAsyncTask (NotesDAO dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Note... params) {
            System.out.println("inserting at repo");
            // Calls the insert multiple notes method as it supports inserting just one item
            mAsyncTaskDao.insertNotes(params);
            return null;
        }
    }
}
