package com.example.safetyapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context) : SQLiteOpenHelper(context, "USERDB", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
       db?.execSQL("CREATE TABLE USERS (USERID INTEGER PRIMARY KEY AUTOINCREMENT, PHONENO INTEGER)")
        db?.execSQL("INSERT INTO USERS(PHONENO) VALUES ()")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}