package Objects;
import java.io.File;
import java.net.URL;
import java.util.*;
import java.sql.Date;


public class Song {
	
	private String name;
	private String artist;
	private String album;
	private String key;
	private ArrayList<String> ft;
	private File fileName;
	private URL link;
	private double length;
	private int tempo;
	private Date albumRel;
	private Boolean isFt;
	
	
	//getters
	public String getName() {
		return name;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getAlbum() {
		return album;
	}
	
	public String getKey() {
		return key;
	}
	
	public File getFile() {
		return fileName;
	}
	
	public URL getLink() {
		return link;
	}
	
	public ArrayList<String> getFt() {
		return ft;
	}
	
	public double getLength() {
		return length;
	}
	
	public int getTempo() {
		return tempo;
	}
	
	public Date getDate() {
		return albumRel;
	}
	
	public Boolean getIsFt() {
		return isFt;
	}
	
	//setters
	public Song(String name, String artist, String album, String key, ArrayList<String> ft, File fileName, double length, int tempo, Date albumRel, Boolean isFt) {
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.key = key;
		this.fileName = fileName;
		this.ft = ft;
		this.length = length;
		this.tempo = tempo;
		this.albumRel = albumRel;
		this.isFt = isFt;
		isFtSet(isFt);
	}
	
	public Song(String name, String artist, String album, String key, ArrayList<String> ft, URL link,  double length, int tempo, Date albumRel, Boolean isFt) {
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.key = key;
		this.link = link;
		this.ft = ft;
		this.length = length;
		this.tempo = tempo;
		this.albumRel = albumRel;
		this.isFt = isFt;
		isFtSet(isFt);
	}
	
	public Song(String name, String artist, String album, String key, ArrayList<String> ft, File fileName, URL link, double length, int tempo, Date albumRel, Boolean isFt) {
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.key = key;
		this.fileName = fileName;
		this.link = link;
		this.ft = ft;
		this.length = length;
		this.tempo = tempo;
		this.albumRel = albumRel;
		this.isFt = isFt;
		isFtSet(isFt);
	}
	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public void setArtist(String artist) {
//		this.artist = artist;
//	}
//	
//	public void setAlbum(String album) {
//		this.album = album;
//	}
//	
//	public void setFt(ArrayList<String> ft) {
//		this.ft = ft;
//	}
//	
//	public void setLength(float length) {
//		this.length = length;
//	}
//	
//	public void setTempo(int tempo) {
//		this.tempo = tempo;
//	}
//	
//	public void setIsFt(Boolean isFt) {
//		this.isFt = isFt;
//	}
//	
	public void isFtSet(Boolean isFt) {
		if (isFt == false) {
			ft = null;
		}
	}
	
}
