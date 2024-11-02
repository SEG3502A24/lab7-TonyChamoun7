package seg3x02.booksrestapi.controller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.hateoas.CollectionModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import seg3x02.booksrestapi.assemblers.*
import seg3x02.booksrestapi.entities.*
import seg3x02.booksrestapi.repository.*
import seg3x02.booksrestapi.representation.*
import java.net.URI

@RestController
@CrossOrigin(origins = ["http://localhost:4200"])
@RequestMapping("books-api", produces = ["application/hal+json"])
class ApiController(
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository,
    private val bioRepository: BioRepository,
    private val orderRepository: OrderRepository,
    private val authorAssembler: AuthorModelAssembler,
    private val bookAssembler: BookModelAssembler,
    private val orderAssembler: OrderModelAssembler,
    private val bioAssembler: BioModelAssembler
) {
    // --- Authors Endpoints ---
    @Operation(summary = "Get all authors")
    @GetMapping("/authors")
    fun allAuthors(): ResponseEntity<CollectionModel<AuthorRepresentation>> {
        val authors = authorRepository.findAll()
        return ResponseEntity(authorAssembler.toCollectionModel(authors), HttpStatus.OK)
    }

    @Operation(summary = "Get an author by ID")
    @GetMapping("/authors/{id}")
    fun getAuthorById(@PathVariable id: Long): ResponseEntity<AuthorRepresentation> {
        return authorRepository.findById(id)
            .map { authorAssembler.toModel(it) }
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    // --- Books Endpoints ---
    @Operation(summary = "Get all books")
    @GetMapping("/books")
    fun allBooks(): ResponseEntity<CollectionModel<BookRepresentation>> {
        val books = bookRepository.findAll()
        return ResponseEntity(bookAssembler.toCollectionModel(books), HttpStatus.OK)
    }

    @Operation(summary = "Get a book by ID")
    @GetMapping("/books/{id}")
    fun getBookById(@PathVariable id: Long): ResponseEntity<BookRepresentation> {
        return bookRepository.findById(id)
            .map { bookAssembler.toModel(it) }
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    // --- Bio Endpoints ---
    @Operation(summary = "Get a bio by ID")
    @GetMapping("/bios/{id}")
    fun getBioById(@PathVariable id: Long): ResponseEntity<BioRepresentation> {
        return bioRepository.findById(id)
            .map { bioAssembler.toModel(it) }
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }
}
