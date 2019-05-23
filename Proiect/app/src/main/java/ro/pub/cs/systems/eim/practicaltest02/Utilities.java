package ro.pub.cs.systems.eim.practicaltest02;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

class Utilities {
    static BufferedReader getReader(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    static PrintWriter getWriter(Socket socket) throws IOException {
        return new PrintWriter(socket.getOutputStream(), true);
    }

    static String getPageFromUrl(String url) {
        AsyncTask<String, Void, String> urlSearcher = new UrlSearcher().execute(url);
        try {
            return urlSearcher.get();
        } catch (InterruptedException interruptedException) {
            Log.d(Constants.TAG, "An exception has occurred " + interruptedException.getMessage());
            if (Constants.DEBUG) {
                interruptedException.printStackTrace();
            }
        } catch (ExecutionException executionException) {
            Log.d(Constants.TAG, "An exception has occurred " + executionException.getMessage());
            if (Constants.DEBUG) {
                executionException.printStackTrace();
            }
        }
        return null;

    }
}
