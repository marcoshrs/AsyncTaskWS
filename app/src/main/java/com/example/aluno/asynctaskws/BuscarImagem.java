package com.example.aluno.asynctaskws;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by aluno on 13/07/18.
 */

public class BuscarImagem extends AsyncTask<String, Integer, Bitmap> {

    private Activity activity;

    public BuscarImagem(Activity activity){
        this.activity = activity;
    }


    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap imagem = null;
        try{
            URL url = new URL(strings[0]);
            imagem = BitmapFactory.decodeStream(url.openStream());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return imagem;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        ImageView imageView = (ImageView) activity.findViewById(R.id.imageViewPrincipal);
        imageView.setImageBitmap(bitmap);
    }
}
