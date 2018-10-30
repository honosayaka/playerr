package cn.honosayaka.getsong;

import java.io.BufferedInputStream;

import java.io.File;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.OutputStream;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.URL;

import java.net.URLConnection;

public class HttpConnectionUtil {
	static String path=null;

	public static void downloadFile(Songbean song) {
    	String urlPath = "http://music.163.com/song/media/outer/url?id="+song.getId();
        File file = null;
        try {

            // 统一资源

            URL url = new URL(urlPath);

            // 连接类的父类，抽象类

            URLConnection urlConnection = url.openConnection();

            // http的连接类

            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;

            // 设定请求的方法，默认是GET

            httpURLConnection.setRequestMethod("POST");

            // 设置字符编码

            httpURLConnection.setRequestProperty("Charset", "UTF-8");

            // 打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）。

            httpURLConnection.connect();

 

            // 文件大小

   //         int fileLength = httpURLConnection.getContentLength();

 

            // 文件名
//
//            String filePathUrl = httpURLConnection.getURL().getFile();
//
//            String fileFullName = filePathUrl.substring(filePathUrl.lastIndexOf(File.separatorChar) + 1);

 

//            System.out.println("file length---->" + fileLength);

 

      //      URLConnection con = url.openConnection();

 

            BufferedInputStream bin = new BufferedInputStream(httpURLConnection.getInputStream());

 

             path = "/tmp/"+song.getId()+"_"+song.getName()+".mp3";

            

            file = new File(path);
//
//            if (!file.getParentFile().exists()) {
//
//                file.getParentFile().mkdirs();
//
//            }

            OutputStream out = new FileOutputStream(file);


            int len = 0;

            byte[] buf = new byte[1024];

            while ((len = bin.read(buf)) != -1) {


                out.write(buf, 0, len);

            }

            bin.close();

            out.close();

        } catch (MalformedURLException e) {


            e.printStackTrace();

        } catch (IOException e) {


            e.printStackTrace();

        }
 

    }

	public static String getPath() {
		return path;
	}
 

}
