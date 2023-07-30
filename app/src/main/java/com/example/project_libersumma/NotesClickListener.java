package com.example.project_libersumma;

import androidx.cardview.widget.CardView;

import com.example.project_libersumma.Models.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);
}
