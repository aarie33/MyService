package arie.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

public class OriginService extends Service {
    public static final String ORIGIN_SERVICE = "OriginService";

    public OriginService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(ORIGIN_SERVICE, "Origin Service dijalankan");
        processAsync processAsync = new processAsync();
        processAsync.execute();
        return START_STICKY;
    }

    private class processAsync extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(ORIGIN_SERVICE, "Stop Service");
            stopSelf();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(ORIGIN_SERVICE, "onDestroy()");
    }
}
