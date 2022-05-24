package sg.edu.np.mad.otpgenerator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context c) {
        // Tag version num to DB
        super(c, "OTP_Account.db", null, 1);

        /* Eg. app updates, may need to add more things to DB, so need to change SQL DB
         schema. So in source ode, change DB version to version 2 for a new DB schema.
         When existing user install the app with old version, will call onUpgrade mtd
         to upgrade DB, so best not to use DROP TABLE in onUpdate as all previous DB will
         be lost. */
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Account (Username TEXT, Password TEXT)";
        // Find db, if not exist, will create one
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Take care all versions of DB here (eg. version 3 vs version 10)
        // With every upgrade, shouldn't drop table to delete all data

        db.execSQL("DROP TABLE IF EXISTS Account"); // Not recommended
        onCreate(db); // Call onCreate mtd to make a database
    }

    public void insertAccount(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Account VALUES(\"" + user.Username + "\",\"" + user.Password + "\")");
        db.close(); // When done, close the database connection

    }
}
