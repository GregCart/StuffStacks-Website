package Objects;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;

public class Usables {
	
	@SuppressWarnings("unused")
	private Book B;
	@SuppressWarnings("unused")
	private Song S;
	@SuppressWarnings("unused")
	private Image I;
	@SuppressWarnings("unused")
	private Video V;
	
	
	public Usables(Book B) {
		this.B = B;
		useBook(B);
	}
	
	public Usables(Song S) {
		this.S = S;
		useSong(S);
	}
	
	public Usables(Image I) {
		this.I = I;
		useImage(I);
	}
	
	public Usables(Video V) {
		this.V = V;
		useVideo(V);
	}
	
	public static Object[] useBook(Book B) {
		String s1 = B.getAuthor();
		String s2 = B.getPublisher();
		String s3 = B.getSeries();
		String s4 = B.getTitle();
		Date d5 = B.getDate();
		int i6 = B.getLength();
		int i7 = B.getSeriesNum();
		Object[] usableBook = {s1, s2, s3, s4, d5.toString(), i6, i7};
		return usableBook;
	}
	
	public static Object[] useSong(Song S) {
		String s1 = S.getArtist();
		String s2 = S.getAlbum();
		String s3 = S.getKey();
		String s4 = S.getName();
		Date d5 = S.getDate();
		int i6 = S.getTempo();
		ArrayList<String> al7 = S.getFt();
		Object[] usableImage = {s1, s2, s3, s4, d5.toString(), i6, al7};
		return usableImage;
	}
	
	public static Object[] useImage(Image I) {
		String s1 = I.getPhotographer();
		String s2 = I.getAlbum();
		String s3 = I.getPlace();
		String s4 = I.getName();
		Date d5 = I.getDate();
		ArrayList<String> al7 = I.getPeople();
		Object[] usableImage = {s1, s2, s3, s4, d5.toString(), al7};
		return usableImage;
	}
	
	public static Object[] useVideo(Video V) {
		String s1 = V.getCreator();
		String s2 = V.getType();
		String s3 = V.getTitle();
		Date d5 = V.getDate();
		double i6 = V.getLength();
		String s7 = Double.toString(V.getSE());
		URL u8 = V.getLink();
		File f9 = V.getFileName();
		Boolean b10 = V.getIsSeason();
		Object[] usableVideo = {s3, s1, s2, s7, f9, u8, i6, d5, b10};
		return usableVideo;
	}
}
