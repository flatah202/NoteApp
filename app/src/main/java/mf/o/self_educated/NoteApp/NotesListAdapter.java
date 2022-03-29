package mf.o.self_educated.NoteApp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.NotesViewHolder> {

    private ArrayList<Work_page> notesList = new ArrayList<>();
    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_room, parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.notes.setText(notesList.get(position).getTitle());
        holder.titleList.setText(notesList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public void setNotesList(ArrayList<Work_page> notesList){
        this.notesList = notesList;
        notifyDataSetChanged();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {
        TextView titleList , notes;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            titleList = itemView.findViewById(R.id.note_title1);
            notes = itemView.findViewById(R.id.input_note_show1);
        }
    }
}
