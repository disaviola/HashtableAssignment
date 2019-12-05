//Disa Röed Sahlström, disa7213

/*
 * Denna klass ska förberedas för att kunna användas som nyckel i en hashtabell. 
 * Du får göra nödvändiga ändringar även i klasserna MyString och ISBN10.
 * 
 * Hashkoden ska räknas ut på ett effektivt sätt och följa de regler och 
 * rekommendationer som finns för hur en hashkod ska konstrueras. Notera i en 
 * kommentar i koden hur du har tänkt när du konstruerat din hashkod.
 */
public class Book {
	private MyString title;
	private MyString author;
	private ISBN10 isbn;
	private MyString content;
	private int price;

	public Book(String title, String author, String isbn, String content, int price) {
		this.title = new MyString(title);
		this.author = new MyString(author);
		this.isbn = new ISBN10(isbn);
		this.content = new MyString(content);
	}

	/**
	 * Tanken bakom hashkoden är att ta fält som verkar unika för varje bok,
	 * samt som ej kan ändras efter instansiering,
	 * för att sätta en så unik hashkod som möjligt. Resultatet multipliceras även
	 * med ett primtal i flera omgångar för ökad variation.
	 */
	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = result + (prime * isbn.toString().hashCode());
		result = prime * result + title.toString().hashCode();
		result = prime * result + author.toString().hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Book)) {
			return false;
		}
		final Book other = (Book) obj;
		return(title.toString().equals(other.title.toString()) && author.toString().equals(other.author.toString())
				&& isbn.toString().equals(other.isbn.toString()) && content.toString().equals(other.content.toString()));
	}
	
	public MyString getTitle() {
		return title;
	}

	public MyString getAuthor() {
		return author;
	}

	public ISBN10 getIsbn() {
		return isbn;
	}

	public MyString getContent() {
		return content;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("\"%s\" by %s Price: %d ISBN: %s lenght: %s", title, author, price, isbn, content.length());
	}

}
