package test.automation.common;

public class CreatePost {

	private int id;
	private String title;
	private String author;
	
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "CreatePost [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
