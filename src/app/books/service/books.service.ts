import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book, Author } from '../model/book';

@Injectable({
  providedIn: 'root'
})
export class BooksService {
  private books = [
    new Book(1001, 'Tech', 'Introduction to Angular', 50.25, [new Author('Bob', 'T')], 2017),
    new Book(1002, 'Tech', 'Angular Advanced Concepts', 125.95, [new Author('Zorb', 'Tar')], 2019),
    new Book(1003, 'Kids', 'A Fantastic Story', 12.25, [new Author('Jane', 'C'), new Author('Tala', 'Tolo')], 2009),
    new Book(1004, 'Cook', 'The Best Shawarmas', 18.99, [new Author('Chef', 'Z')], 1978),
    new Book(1005, 'Tech', 'Angular Demystified', 210.50, [new Author('Zorb', 'Tar')], 2020)
  ];

  private url = 'http://localhost:8080/books-api';

  constructor(private http: HttpClient) {}

  // Retrieves a book by its ID from the local array
  public getBook(id: string): Book {
    return <Book>this.books.find(book => book.id === Number.parseInt(id));
  }

  // Adds a new book to the local array
  public addBook(b: Book): void {
    this.books.push(b);
  }

  // New method to get an author by ID from the backend
  getAuthor(id: number): Observable<Author> {
    return this.http.get<Author>(`${this.url}/authors/${id}`);
  }
}
