package com.example.employeesystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class mydatabasehelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "gudaygeday";
    private static final String TABLE_NAME = "employee";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "firstname";
    private static final String COL_3 = "middlename";
    private static final String COL_4 = "gender";
    private static final String COL_5 = "salary";
    private static final String COL_6 = "department";


    public mydatabasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COL_1 + " INTEGER PRIMARY KEY," + COL_2 + " TEXT,"
                + COL_3 + " TEXT," + COL_4 + " TEXT," + COL_5 + " TEXT," + COL_6 + " TEXT" +")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }



    public boolean adddata(jamualem jam) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentvalues = new ContentValues();
        if (jam.getFirstname().isEmpty() || jam.getMiddlename().isEmpty() || jam.getGender().isEmpty() || jam.getSalary().isEmpty() || jam.getDepartment().isEmpty()) {
            db.close();
            return false;
        }
        contentvalues.put(COL_2, jam.getFirstname());
        contentvalues.put(COL_3, jam.getMiddlename());
        contentvalues.put(COL_4, jam.getGender());
        contentvalues.put(COL_5, jam.getSalary());
        contentvalues.put(COL_6, jam.getDepartment());
        long result = db.insert(TABLE_NAME, null, contentvalues);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updatedata(jamualem han) {
        SQLiteDatabase db = getWritableDatabase();

        if (han.getFirstname().isEmpty() || han.getMiddlename().isEmpty() || han.getGender().isEmpty() || han.getSalary().isEmpty() || han.getDepartment().isEmpty()) {
            db.close();
            return false;
        }

        ContentValues values = new ContentValues();
        values.put(COL_1, han.getId());
        values.put(COL_2, han.getFirstname());
        values.put(COL_3, han.getMiddlename());
        values.put(COL_4, han.getGender());
        values.put(COL_5, han.getSalary());
        values.put(COL_6, han.getDepartment());

        int numRowsAffected = db.update(TABLE_NAME, values, COL_1 + " = ?", new String[] { String.valueOf(han.getId()) });
        if (numRowsAffected == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<jamualem> view() {
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        List<jamualem> jamualemList = new ArrayList<jamualem>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                jamualem jam = new jamualem();
                jam.setId(Integer.parseInt(cursor.getString(0)));
                jam.setFirstname(cursor.getString(1));
                jam.setMiddlename(cursor.getString(2));
                jam.setGender(cursor.getString(3));
                jam.setSalary(cursor.getString(4));
                jam.setDepartment(cursor.getString(5));
                jamualemList.add(jam);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return jamualemList;
    }

    public void deleteing(jamualem han){

         SQLiteDatabase del=this.getWritableDatabase();
       del.delete(TABLE_NAME, COL_1 + " = ?", new String[] { String.valueOf(han.getId()) });
      del.close();

    }


}



