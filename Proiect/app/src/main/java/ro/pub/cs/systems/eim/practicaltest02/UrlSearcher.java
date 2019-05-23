package ro.pub.cs.systems.eim.practicaltest02;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class UrlSearcher extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];

        try {
            // create an instance of a HttpClient object
            HttpClient httpClient = new DefaultHttpClient();
            // create an instance of a HttpGet object, encapsulating the base Internet address (http://www.google.com) and the keyword
            HttpGet httpGet = new HttpGet(url);
            // create an instance of a ResponseHandler object
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            return httpClient.execute(httpGet, responseHandler);
            // execute the request, thus generating the result
        } catch (Exception exception) {
            Log.e(Constants.TAG, exception.getMessage());
            if (Constants.DEBUG) {
                exception.printStackTrace();
            }
        }

        return null;
    }
}
