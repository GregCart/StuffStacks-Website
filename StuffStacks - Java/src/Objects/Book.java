package Objects;

import java.io.File;
import java.net.URL;
import java.sql.Date;

public class Book {
	private String title;
	private String author;
	private String series;
	private String publisher;
	private int length;
	private int seriesNum;
	private File fileName;
	private URL link;
	private Date published;
	private Boolean isSeries;
	
	
	//getters
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getSeries() {
		return series;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getSeriesNum() {
		return seriesNum;
	}
	
	public File getFile() {
		return fileName;
	}
	
	public URL getLink() {
		return link;
	}
	
	public Date getDate() {
		return published;
	}
	
	public Boolean getIsSeries() {
		return isSeries;
	}
	
	
	//setters
	public Book(String title, String author, String series, String publisher, int length,int seriesNum, File fileName, Date published, Boolean isSeries) {
		this.title = title;
		this.author = author;
		this.series = series;
		this.publisher = publisher;
		this.length = length;
		this.seriesNum = seriesNum;
		this.fileName = fileName;
		this.published = published;
		this.isSeries = isSeries;
		seriesCheck(isSeries);
	}
	
	public Book(String title, String author, String series, String publisher, int length, int seriesNum, URL link, Date published, Boolean isSeries) {
		this.title = title;
		this.author = author;
		this.series = series;
		this.publisher = publisher;
		this.length = length;
		this.seriesNum = seriesNum;
		this.link = link;
		this.published = published;
		this.isSeries = isSeries;
		seriesCheck(isSeries);
	}
	
	public Book(String title, String author, String series, String publisher, int length, int seriesNum, File fileName, URL link, Date published, Boolean isSeries) {
		this.title = title;
		this.author = author;
		this.series = series;
		this.publisher = publisher;
		this.length = length;
		this.seriesNum = seriesNum;
		this.fileName = fileName;
		this.link = link;
		this.published = published;
		this.isSeries = isSeries;
		seriesCheck(isSeries);
	}
	
	private void seriesCheck(Boolean isSeries) {
		if (isSeries == false) {
			series = null;
			seriesNum = 0;
		}
	}
}
