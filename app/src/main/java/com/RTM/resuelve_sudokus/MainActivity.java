package com.RTM.resuelve_sudokus;

import static java.lang.System.out;
import static java.sql.DriverManager.println;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.Debug;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity {
private EditText etn ;
private String[] lista_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etn = findViewById(R.id.et0000);

        int i = 0;
        lista_et = new String[81];
        String code;
            for (int r = 0; r < 3 ; r++){
                for (int c = 0; c < 3; c++){
                    for (int f = 0; f < 3; f++){
                        for (int p = 0; p < 3; p++){
                            code = "et" + String.valueOf(r) + String.valueOf(c) + String.valueOf(f) + String.valueOf(p);
                            int etID = getResources().getIdentifier(code,"id",getPackageName());
                            etn = findViewById(etID);
                            Log.i("ID",code);
                            lista_et[i]=code;
                            i++;
                        }
                    }
                }
            }
        comprobarFilas();
    }
    public void imprimirListaEditText(){
        for (int i=0; i<lista_et.length;i++){
            Log.d("idS",lista_et[i]);
        }
    }
    public void comprobarFilas(){
        String[] nums ={"","","","","","","","",""};//9 huecosn por 9 posibles numeros
        int i=0;
        int j=0;
        while (i<9){
            for (int k = j; k<k+3; k++) {
                //instanciamos temporalmente el editText
             //   Log.i("p",lista_et[k]);
                int etID = getResources().getIdentifier(lista_et[k],"id",getPackageName());
                etn = (EditText) findViewById(etID);
                //accedemos a su texto y recogemos su valor en NUMs
                nums[i]=etn.getText().toString();
                if (i<9){
                    i++;
                }

            }
            j=j+7;
        }
        for (int w=0; w<nums.length;w++){
            Log.i("numeros:",nums[w]);
        }
    }

}