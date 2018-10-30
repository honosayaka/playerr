package cn.honosayaka.getsong;

 

public class Player {
	
	static Songbean song = null;
	public static void play() {
		try {
			song = Getter.getId();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		HttpConnectionUtil.downloadFile(song);
		System.out.println(song);
		MP3Player mp3 = new MP3Player(HttpConnectionUtil.getPath());
		mp3.play();
	}
	
	public static void play(Songbean song) {
		HttpConnectionUtil.downloadFile(song);
		System.out.println(song);
		MP3Player mp3 = new MP3Player(HttpConnectionUtil.getPath());
		mp3.play();
	}
	
	public static void main(String[] args) {
		while(true) {
			play();
		}
	}

}
