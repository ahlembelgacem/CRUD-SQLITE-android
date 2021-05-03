package com.example.tp5;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {

        public Helper(@Nullable Context context)
        {

            super(context, "ContactsManager", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL("CREATE TABLE contact(_id INTEGER PRIMARY KEY, nom TEXT, phone TEXT )");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


            db.execSQL("DROP TABLE IF EXISTS contact");

            onCreate(db);

        }


        //Méthode d'insertion de contact

        public void insertContact(Contact c)
        {
            SQLiteDatabase db= this.getWritableDatabase();

            ContentValues cv=new ContentValues();
            cv.put("nom",c.getNom());
            cv.put("phone",c.getPhone());

            db.insert("contact",null,cv);

            db.close();


        }


        public Cursor getAllContacts()
        {

            SQLiteDatabase db=this.getReadableDatabase();

            Cursor c = db.rawQuery("SELECT * FROM contact",null);

            return c;
        }


        //selection d'un contact par id

        public Contact getOneContact(int id)
        {

            SQLiteDatabase db=this.getReadableDatabase();

            Cursor c=db.query("contact",new String[]{"_id","nom","phone"},"_id=?",new String[]{String.valueOf(id)},
                    null,null,null);
            c.moveToFirst();
            Contact cn=new Contact(c.getInt(0),c.getString(1),c.getString(2));
            return cn;

        }


        public void updateContact(Contact c)

        {
            SQLiteDatabase db=this.getWritableDatabase();

            ContentValues cv=new ContentValues();
            cv.put("nom",c.getNom());
            cv.put("phone",c.getPhone());


            db.update("contact",cv,"_id=?",new String[]{String.valueOf(c.getId())});

            db.close();


        }


        public void deleteContact(int id)
        {

            SQLiteDatabase db=this.getWritableDatabase();

            db.delete("contact","_id=?",new String[]{String.valueOf(id)});

            db.close();
        }



    }


