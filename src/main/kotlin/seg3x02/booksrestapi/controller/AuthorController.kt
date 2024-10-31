package seg3x02.booksrestapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import seg3x02.booksrestapi.entities.Author
import seg3x02.booksrestapi.repository.AuthorRepository

@RestController
@RequestMapping("/books-api")
class AuthorController(private val authorRepository: AuthorRepository) {

    @GetMapping("/authors/{id}")
    fun getAuthorById(@PathVariable id: Long): ResponseEntity<Author> {
        val author = authorRepository.findById(id)
        return if (author.isPresent) {
            ResponseEntity.ok(author.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
