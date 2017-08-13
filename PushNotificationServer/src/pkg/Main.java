/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.simple.JSONObject;

/**
 *
 * @author iSaleem
 */
public class Main {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) throws IOException {
        String url = "https://fcm.googleapis.com/fcm/send";
        String token = "eHz12xzAheM:APA91bEWNC90qsgcwvYQ6Ec5W57yEG6i_f7Hpfz8L4xreJtOtcFOhy5g8mE0f2ZRy0x_2poVRbsqLivPWzBdb5oxzJmCHeZGPwjUDyHoManWu-Iuj56qkbyopx-tGCJz0b6JCdjvrjPn";

        OkHttpClient client = new OkHttpClient();
        JSONObject root = new JSONObject();
        root.put("to", token);
        root.put("priority", "high");
        JSONObject notification = new JSONObject();
        notification.put("body", "aaa");
        notification.put("title","zzzz");
        
        root.put("notification", notification);
        
        RequestBody body = RequestBody.create(JSON, root.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Authorization", "key=")
                .build();
        Response response = client.newCall(request).execute();
       
        System.out.println(response.body().string());
    }

}

