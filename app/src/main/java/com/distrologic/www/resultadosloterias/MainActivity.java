package com.distrologic.www.resultadosloterias;

import android.os.AsyncTask;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    /*
public void setDate(View view){
    PickerDialogs pickerDialogs = new PickerDialogs();
    pickerDialogs.show(getSupportFragmentManager(),"date_picker");

}
*/
    String JSON_STRING;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getJson(View view){
        new BackgroundTask().execute();
    }



    class BackgroundTask extends AsyncTask<Void,Void,String>{

        String Server_url;
        String Json_url;
        String Fecha_url;
        String Loteria_url;

        @Override
        protected void onPreExecute() {

            //Server_url="http://distrologic.com/loteria/app/getInfo.php?fecha=2016-09-10&loteria=Nacional";
            Server_url = "http://distrologic.com/loteria/app/getInfo.php";
         Fecha_url = "2016-09-10"; //aca voy a hacer el get elementbyid.text del calendario
            Loteria_url = "Nacional"; //aca voy a hacer el get elementbyid.text del textview


            //version final de la url del server
            Json_url = Server_url + "?fecha=" + Fecha_url + "&loteria=" + Loteria_url;

            System.out.println(Json_url);
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                URL url = new URL(Json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while((JSON_STRING = bufferedReader.readLine())!=null){
                    stringBuilder.append(JSON_STRING+"\n");

                }

                bufferedReader.close();
                inputStream.close();

                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView demoResultadosLoterias = (TextView) findViewById(R.id.demoResultadosLoterias);
            demoResultadosLoterias.setText(result);


        }
    }




}


