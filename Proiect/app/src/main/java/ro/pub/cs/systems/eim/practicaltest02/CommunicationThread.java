package ro.pub.cs.systems.eim.practicaltest02;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class CommunicationThread extends Thread {

    private Socket socket;
    private HashMap<String, String> cachedData = new HashMap<>();

    CommunicationThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        if (socket == null) {
            Log.e(Constants.TAG, "[COMMUNICATION THREAD] Socket is null!");
            return;
        }
        try {
            Log.v(Constants.TAG, "Connection opened with " + socket.getInetAddress() + ":" + socket.getLocalPort());
            PrintWriter printWriter = Utilities.getWriter(socket);
            BufferedReader bufferedReader = Utilities.getReader(socket);

            Log.i(Constants.TAG, "[COMMUNICATION THREAD] Waiting for parameters from client operation and operators!");
            String url = bufferedReader.readLine();
            if (url == null) {
                return;
            }

            if ("".equals(url)) {
                printWriter.println("No url valid");
            }

            if (cachedData.containsKey(url)) {
                printWriter.println(cachedData.get(url));
            } else {
                String result = Utilities.getPageFromUrl(url);
                if (result == null || "".equals(result)) {
                    printWriter.println("No url valid");
                }
                cachedData.put(url, result);
                printWriter.println(result);
            }

            socket.close();
            Log.v(Constants.TAG, "Connection closed");
        } catch (IOException ioException) {
            Log.e(Constants.TAG, "An exception has occurred: " + ioException.getMessage());
            if (Constants.DEBUG) {
                ioException.printStackTrace();
            }
        }

    }
}
