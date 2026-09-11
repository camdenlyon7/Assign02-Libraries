package assign02;

import java.util.Comparator;

public class OrderByDueDate<Type> implements Comparator<LibraryBookGeneric<Type>> {

  @Override
  public int compare(LibraryBookGeneric<Type> book1, LibraryBookGeneric<Type> book2) {
    if (book1.getDueDate() == null && book2.getDueDate() == null) {
      return 0;
    }
    if (book1.getDueDate() == null) {
      return 1;
    }
    if (book2.getDueDate() == null) {
      return -1;
    }

    return book1.getDueDate().compareTo(book2.getDueDate());
  }
}
    
  
    

