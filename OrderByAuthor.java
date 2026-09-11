package assign02;

import java.util.Comparator;


public classs OrderByAuthor<Type> implements Comparator<LibraryBookGeneric<Type>> {

  @Override
  public int compare(LibraryBookGeneric<Type> book1, LibraryBookGeneric<Type> book 2) {
    int surnameCompare = book1.getAuthorSurname().compareTo(book2.getAuthorSurname());
    if (surnameCompare != 0) {
      return surnameCompare;
    }

    return book1.getTitle().compareTo(book2.getTitle());
  }
}
