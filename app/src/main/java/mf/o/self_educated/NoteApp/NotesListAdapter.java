package mf.o.self_educated.NoteApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.ListHolder> {
       public String data[];
       public Context  context;

    public NotesListAdapter(Context context, String[] data) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_room,parent,false);
        ListHolder holder = new ListHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesListAdapter.ListHolder holder, int position) {

        holder.notesName.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ListHolder extends RecyclerView.ViewHolder {

        TextView titleName , notesName;
        public ListHolder(@NonNull View itemView) {
            super(itemView);


            titleName = itemView.findViewById(R.id.TitleName);
            notesName = itemView.findViewById(R.id.NoteShow);
        }
    }
}
