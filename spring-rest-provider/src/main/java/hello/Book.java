/**
 * 
 */
package hello;

/**
 * Book POJO which will be the model for 'books' REST endpoint
 *
 * http://localhost:8080/books => few hardcoded books to be returned
 */
public class Book {
	
	private long id;
	private String name;
	private String author;
	
	public Book(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	

}
