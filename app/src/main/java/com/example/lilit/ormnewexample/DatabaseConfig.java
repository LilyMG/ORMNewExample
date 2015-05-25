package com.example.lilit.ormnewexample;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Lilit on 5/22/15.
 */
public class DatabaseConfig extends OrmLiteConfigUtil{


    public static void main(String[] args) {
        try {
            writeConfigFile("orm_lite_config");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
