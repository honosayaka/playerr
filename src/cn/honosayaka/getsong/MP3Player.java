package cn.honosayaka.getsong;

 

import java.io.BufferedInputStream;

import java.io.FileInputStream;

 

import javazoom.jl.player.Player;

 

public class MP3Player {

    private String filename;

    private Player player;

 

    public MP3Player(String filename) {

        this.filename = filename;

    }

 

    public void play() {

        try {

            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));

            player = new Player(buffer);

            player.play();
            buffer.close();

 

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public void stop() {

    	try {

    		player.close();

    		

    	} catch (Exception e) {

    		System.out.println(e);

    	}

    }

}
