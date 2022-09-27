package exportkit.figma;
 
/**
  * Created by Sergey on 30.12.2016.
  */
         
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

import androidx.annotation.Nullable;

public class ControllerSqlLite extends SQLiteOpenHelper {
 
         
    private static final String DATABASE_NAME = "android.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_TABLE = "table1";
 
     // поля таблицы для хранения ФИО, Должности и Телефона (id формируется автоматически)
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ID = "id_";

         
    // формируем запрос для создания базы данных
    private static final String DATABASE_CREATE = "create table "
    + DATABASE_TABLE + "("+ COLUMN_ID
            + " integer primary key autoincrement," + COLUMN_NAME
    + " text not null " + ");";
 


    public ControllerSqlLite(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
 
        //создаем таблицу
        db.execSQL(DATABASE_CREATE);
 
        //добавляем строку
        ContentValues initialValues = createContentValues("Igor");
        db.insert(DATABASE_TABLE, null, initialValues);
 
 
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS table1");
        onCreate(db);
    }
 
         
         
            /**
      * Создаёт новый контакт. Если создан успешно - возвращается
      * номер строки rowId, иначе -1
      */
      public long createNewTable(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues initialValues = createContentValues(name);
 
        long row = db.insert(DATABASE_TABLE, null, initialValues);
        db.close();
 
        return row;
    }
 
         
            /**
      * Изменение строчки
      */
    public boolean updateTable(long rowId, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues updateValues = createContentValues(name);
 
        return db.update(DATABASE_TABLE, updateValues, COLUMN_ID + "=" + rowId,
                                null) > 0;
    }
 
            /**
      * Удаление контакта
      */
    public void deleteTable(long rowId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE, COLUMN_ID + "=" + rowId, null);
        db.close();
    }
 
            /**
      * Получение всех контактов
      */
   public Cursor getFullTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query(DATABASE_TABLE, new String[] {COLUMN_NAME}, null,
                null, null, null, null);
    }
 
    /**
      * Получаем конкретный контакт
      */
    public Cursor getTable(long rowId) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mCursor = db.query(true, DATABASE_TABLE,
                                new String[] { COLUMN_NAME}, COLUMN_ID + "=" + rowId, null,
                null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
 
         
            /*
     * Описываем структуру данных
     */
        private ContentValues createContentValues(String name) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        return values;
    }

}