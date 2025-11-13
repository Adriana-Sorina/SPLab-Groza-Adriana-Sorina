package ro.uvt.observer;

import ro.uvt.models.Book;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Book book);
}
