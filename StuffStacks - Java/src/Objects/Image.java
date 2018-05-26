package Objects;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;

public class Image {

	private String name;
	private String photographer;
	private String album;
	private String place;
	private ArrayList<String> people;
	private File fileName;
	private URL link;
	private Date date;
	private Boolean isPeople;
	
	
	//getters
	public String getName() {
		return name;
	}
	
	public String getPhotographer() {
		return photographer;
	}
	
	public String getAlbum() {
		return album;
	}
	
	public String getPlace() {
		return place;
	}
	
	public ArrayList<String> getPeople() {
		return people;
	}
	
	public File getFile() {
		return fileName;
	}
	
	public URL getLink() {
		return link;
	}
	
	public Date getDate() {
		return date;
	}
	
	public Boolean getIsPpl() {
		return isPeople;
	}
	
	
	//setters
	public Image(String name, String photographer, String album, String place, ArrayList<String> people, File fileName, Date date, Boolean isPeople) {
		this.name = name;
		this.photographer = photographer;
		this.album = album;
		this.place = place;
		this.people = people;
		this.fileName = fileName;
		this.date = date;
		this.isPeople = isPeople;
		rPpl(isPeople);
	}
	
	public Image(String name, String photographer, String album, String place, ArrayList<String> people, URL link, Date date, Boolean isPeople) {
		this.name = name;
		this.photographer = photographer;
		this.album = album;
		this.place = place;
		this.people = people;
		this.link = link;
		this.date = date;
		this.isPeople = isPeople;
		rPpl(isPeople);
	}
	
	public Image(String name, String photographer, String album, String place, ArrayList<String> people, URL link, File fileName, Date date, Boolean isPeople) {
		this.name = name;
		this.photographer = photographer;
		this.album = album;
		this.place = place;
		this.people = people;
		this.link = link;
		this.fileName = fileName;
		this.date = date;
		this.isPeople = isPeople;
		rPpl(isPeople);
	}
	
	private void rPpl(Boolean isPeople) {
		if (isPeople == false) {
			people = null;
		}
	}
}
