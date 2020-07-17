package com.system.indipick;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoogleRWAndroid {
        public String sendToGoogleSheet(String url) {
            String str = "FAIL";
            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setReadTimeout(5000);
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("Request URL ... ");
                sb.append(url);
                printStream.println(sb.toString());
                boolean redirect = false;
                int status = conn.getResponseCode();
                if (status != 200 && (status == 302 || status == 301 || status == 303)) {
                    redirect = true;
                }
                if (redirect) {
                    String newUrl = conn.getHeaderField("Location");
                    String cookies = conn.getHeaderField("Set-Cookie");
                    conn = (HttpURLConnection) new URL(newUrl).openConnection();
                    conn.setRequestProperty("Cookie", cookies);
                    conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
                    conn.addRequestProperty("User-Agent", "Mozilla");
                    conn.addRequestProperty("Referer", "google.com");
                }
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuffer html = new StringBuffer();
                while (true) {
                    String readLine = in.readLine();
                    String inputLine = readLine;
                    if (readLine != null) {
                        html.append(inputLine);
                        html.append("\n");
                    } else {
                        in.close();
                        return html.toString();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "FAIL";
            }
        }
    }

