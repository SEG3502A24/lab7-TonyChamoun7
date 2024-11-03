import { Component } from '@angular/core';
import { BooksService } from '../books/service/books.service';

@Component({
  selector: 'app-authors',
  templateUrl: './authors.component.html',
  standalone: true
})
export class AuthorsComponent {
  authorId!: number;
  author: any = null;
  errorMessage: string | null = null;

  constructor(private booksService: BooksService) {}

  onSubmit(): void {
    this.booksService.getAuthor(this.authorId).subscribe({
      next: (data) => {
        this.author = data;
        this.errorMessage = null;
      },
      error: () => {
        this.author = null;
        this.errorMessage = 'Author not found';
      }
    });
  }
}
