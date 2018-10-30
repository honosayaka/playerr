package cn.honosayaka.getsong;

public class Songbean {
	private String id;
	private String name;
	private String singer;
	public Songbean(String id, String name, String singer) {
		super();
		this.id = id;
		this.name = name;
		this.singer = singer;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSinger() {
		return singer;
	}

	@Override
	public String toString() {
		
		return this.id+"_"+this.name+"_"+this.singer;
	}
}
