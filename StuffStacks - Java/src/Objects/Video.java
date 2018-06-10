package Objects;
import java.io.File;
import java.net.URL;
import java.util.Date;

public class Video {

	private String title;
	private String creator;
	private String type;
	private File fileName;
	private URL link;
	private Object SE;
	private double length;
	private Date released;
	private Boolean isSeason;
	
	
	//getters
	public String getTitle() {
		return title;
	}
	
	public String getCreator() {
		return creator;
	}
	
	public String getType() {
		return type;
	}
	
	public Object getSE() {
		return SE;
	}
	
	public File getFileName() {
		return fileName;
	}
	
	public URL getLink() {
		return link;
	}
	
	public double getLength() {
		return length;
	}
	
	public Date getDate() {
		return released;
	}
	
	public Boolean getIsSeason() {
		return isSeason;
	}
	
	 
	//setters
	public Video(String title, String creator, String type, Object SE, URL link, double length, Date released, Boolean isSeason) {
		this.title = title;
		this.creator = creator;
		this.type = type;
		this.SE = SE;
		this.link = link;
		this.length = length;
		this.released = released;
		this.isSeason = isSeason;
		seasonCheck(isSeason);
	}
	
	public Video(String title, String creator, String type, Object SE, File fileName, double length, Date released, Boolean isSeason) {
		this.title = title;
		this.creator = creator;
		this.type = type;
		this.SE = SE;
		this.fileName = fileName;
		this.length = length;
		this.released = released;
		this.isSeason = isSeason;
		seasonCheck(isSeason);
	}
	
	public Video(String title, String creator, String type, Object SE, File fileName, URL link, double length, Date released, Boolean isSeason) {
		this.title = title;
		this.creator = creator;
		this.type = type;
		this.SE = SE;
		this.fileName = fileName;
		this.link = link;
		this.length = length;
		this.released = released;
		this.isSeason = isSeason;
		seasonCheck(isSeason);
	}
	
	private void seasonCheck(Boolean isCD) {
		if (isCD == false) {
			SE = (Double) null;
		}
	}
}
