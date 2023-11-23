package com.example.projecthk1_2023_2024.model;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;


public class Export {
    private Timestamp Create_Date;
    private String Status;
    private boolean Enable;
    private Timestamp Date_Success;
    private DocumentReference IDUser_confirm;
    public Export(){}

    public Export(Timestamp create_Date, String status, boolean enable, Timestamp date_Success, DocumentReference IDUser_confirm) {
        Create_Date = create_Date;
        Status = status;
        Enable = enable;
        Date_Success = date_Success;
        this.IDUser_confirm = IDUser_confirm;
    }

    public Timestamp getCreate_Date() {
        return Create_Date;
    }

    public void setCreate_Date(Timestamp create_Date) {
        Create_Date = create_Date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public boolean isEnable() {
        return Enable;
    }

    public void setEnable(boolean enable) {
        Enable = enable;
    }

    public Timestamp getDate_Success() {
        return Date_Success;
    }

    public void setDate_Success(Timestamp date_Success) {
        Date_Success = date_Success;
    }

    public DocumentReference getIDUser_confirm() {
        return IDUser_confirm;
    }

    public void setIDUser_confirm(DocumentReference IDUser_confirm) {
        this.IDUser_confirm = IDUser_confirm;
    }
}
