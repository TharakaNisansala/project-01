abstract class LibraryItem {
    private String title;
    private String itemID;
    private boolean checkedOut;

    public LibraryItem(String title, String itemID) {
        this.title = title;
        this.itemID = itemID;
        this.checkedOut = false;
    }
	public String getTitle(){
		return title;
	}
	public String getItemID(){
		return itemID;
	}

    public void checkOut() {
        if (checkedOut) {
            System.out.println(title + " is already checked out.");
        } else {
            checkedOut = true;
            System.out.println(title + " has been checked out.");
        }
    }

    public void checkIn() {
        if (!checkedOut) {
            System.out.println(title + " is already checked in.");
        } else {
            checkedOut = false;
            System.out.println(title + " has been checked in.");
        }
    }

    public abstract void displayItemDetails();
}

class Book extends LibraryItem {
    private String author;
    private int numPages;

    public Book(String title, String itemID, String author, int numPages) {
        super(title, itemID);
        this.author = author;
        this.numPages = numPages;
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Title: " + super.getTitle());
        System.out.println("Item ID: " + super.getItemID());
        System.out.println("Author: " + author);
        System.out.println("Number of Pages: " + numPages);
    }
}

class Magazine extends LibraryItem {
    private String issueDate;
    private String publisher;

    public Magazine(String title, String itemID, String issueDate, String publisher) {
        super(title, itemID);
        this.issueDate = issueDate;
        this.publisher = publisher;
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Title: " + super.getTitle());
        System.out.println("Item ID: " + super.getItemID());
        System.out.println("Issue Date: " + issueDate);
        System.out.println("Publisher: " + publisher);
    }
}

class LibraryMember {
    private String memberID;
    private String name;

    public LibraryMember(String memberID, String name) {
        this.memberID = memberID;
        this.name = name;
    }

    public void displayMemberDetails() {
        System.out.println("Member ID: " + memberID);
        System.out.println("Name: " + name);
    }
}

public class LibraryManagementSysterm {
    public static void main(String[] args) {
        // Create 5 objects of the Book class
        Book[] books = {
                new Book("The Catcher in the Rye", "B001", "J.D. Salinger", 240),
                new Book("To Kill a Mockingbird", "B002", "Harper Lee", 281),
                new Book("1984", "B003", "George Orwell", 328),
                new Book("Pride and Prejudice", "B004", "Jane Austen", 432),
                new Book("The Hobbit", "B005", "J.R.R. Tolkien", 320)
        };

        // Create 5 objects of the Magazine class
        Magazine[] magazines = {
                new Magazine("National Geographic", "M001", "August 2023", "National Geographic Society"),
                new Magazine("Time", "M002", "September 2023", "Time USA, LLC"),
                new Magazine("Forbes", "M003", "June 2023", "Forbes Media"),
                new Magazine("Vogue", "M004", "July 2023", "Condé Nast"),
                new Magazine("Sports Illustrated", "M005", "July 2023", "Maven Coalition")
        };

        // Create 5 objects of the LibraryMember class
        LibraryMember[] members = {
                new LibraryMember("L001", "John Doe"),
                new LibraryMember("L002", "Jane Smith"),
                new LibraryMember("L003", "David Johnson"),
                new LibraryMember("L004", "Sarah William"),
				new LibraryMember("L005","Michael Brow")
        };

        // Call the checkOut() and checkIn() methods on one of the library items
        books[0].checkOut();
        books[0].checkIn();

        // Display the details of all the library items and library members
        System.out.println("Books:");
        for (Book book : books) {
            book.displayItemDetails();
            System.out.println();
        }

        System.out.println("Magazines:");
        for (Magazine magazine : magazines) {
            magazine.displayItemDetails();
            System.out.println();
        }

        System.out.println("Library Members:");
        for (LibraryMember member : members) {
            member.displayMemberDetails();
            System.out.println();
        }
    }
}
