package assign02;

import java.util.Comparator;


public class OrderByAuthor<Type> implements Comparator<LibraryBookGeneric<Type>> {

  @Override
  public int compare(LibraryBookGeneric<Type> book1, LibraryBookGeneric<Type> book2) {
    int surnameCompare = book1.getAuthorSurname().compareTo(book2.getAuthorSurname());
    if (surnameCompare != 0) {
      return surnameCompare;
    }

    return book1.getTitle().compareTo(book2.getTitle());
  }
}
