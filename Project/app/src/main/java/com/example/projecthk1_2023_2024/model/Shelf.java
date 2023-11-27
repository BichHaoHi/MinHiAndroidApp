package com.example.projecthk1_2023_2024.model;

import androidx.databinding.BaseObservable;

import com.google.firebase.firestore.DocumentReference;

public class Shelf extends BaseObservable {
    private String Name;
    private DocumentReference ID_Zone;
    private boolean Enable;

    public Shelf() {
    }

    public Shelf(String Name, DocumentReference ID_Zone, boolean Enable) {
        this.Name = Name;
        this.ID_Zone = ID_Zone;
        this.Enable = Enable;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public DocumentReference getID_Zone() {
        return ID_Zone;
    }

    public void setID_Zone(DocumentReference ID_Zone) {
        this.ID_Zone = ID_Zone;
    }

    public boolean isEnable() {
        return Enable;
    }

    public void setEnable(boolean enable) {
        Enable = enable;
    }
}
