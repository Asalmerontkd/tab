package com.example.omy.tab.Utilerias;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class Utils extends AppCompatActivity {

    public static void mostrarToas(String mensaje, Context context)
    {
        Toast.makeText(context,mensaje,Toast.LENGTH_LONG).show();
    }


}
