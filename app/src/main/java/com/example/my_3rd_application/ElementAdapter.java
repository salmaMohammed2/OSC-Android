package com.example.my_3rd_application;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ElementAdapter extends RecyclerView.Adapter<ElementAdapter.ElementHolder> {


    List<Note> note ;
    OnSelectItem onSelectItem;
    Context context;
    public ElementAdapter(List<Note> note, Context context)
    {
        this.context=context;
        this.note =note;

    }
    public void setOnSelectItem(OnSelectItem onSelectItem)
    {
        this.onSelectItem= onSelectItem;

    }
    @NonNull
    @Override
    public ElementHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_xml, parent, false);
        return new ElementHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementHolder holder, int position) {
        holder.OnBind(note.get(position),position,context);

    }

    @Override
    public int getItemCount() {
        if(note==null)
            return 0;
        else
            return note.size();
    }

    public class ElementHolder extends RecyclerView.ViewHolder {
        View cardViewClick;
        TextView noteName;
        TextView description;
        public ElementHolder(@NonNull View itemView) {
            super(itemView);
            noteName=itemView.findViewById(R.id.name_txt);
            description=itemView.findViewById(R.id.description_txt);
            cardViewClick=itemView.findViewById(R.id.cardViewClick);
        }
        void OnBind(Note item,int position,Context context) {
            noteName.setText(item.getNoteName());
            description.setText(item.getDescription());
            cardViewClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(view.getContext(),EditDeleteNote.class);
                    i.putExtra("id",String.valueOf(item.getId()));
                    i.putExtra("key1",item.getNoteName());
                    i.putExtra("key2",item.getDescription());

                    view.getContext().startActivity(i);

                }
            });
        }
    }
    interface OnSelectItem{
        void onClick(Note note, int position);
    }
}
