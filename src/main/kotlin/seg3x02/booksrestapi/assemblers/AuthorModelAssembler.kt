package seg3x02.booksrestapi.assemblers

import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Component
import seg3x02.booksrestapi.controller.ApiController
import seg3x02.booksrestapi.entities.Author
import seg3x02.booksrestapi.entities.Book
import seg3x02.booksrestapi.representation.AuthorRepresentation
import seg3x02.booksrestapi.representation.BookTitleRepresentation

@Component
class AuthorModelAssembler : RepresentationModelAssemblerSupport<Author, AuthorRepresentation>(
    ApiController::class.java, AuthorRepresentation::class.java
) {
    override fun toModel(entity: Author): AuthorRepresentation {
        val authorRepresentation = instantiateModel(entity)
        authorRepresentation.add(
            linkTo(ApiController::class.java)
                .slash("authors/${entity.id}").withSelfRel()
        )
        authorRepresentation.books = entity.books.map { bookRepresentation(it) } // Ensure `books` exists in `Author`
        authorRepresentation.add(
            linkTo(ApiController::class.java)
                .slash("authors/${entity.id}/bio").withRel("bio")
        )
        authorRepresentation.id = entity.id
        authorRepresentation.firstName = entity.firstName
        authorRepresentation.lastName = entity.lastName
        return authorRepresentation
    }

    private fun bookRepresentation(book: Book): BookTitleRepresentation {
        val representation = BookTitleRepresentation()
        representation.title = book.title
        return representation.add(
            linkTo(ApiController::class.java).slash("books/${book.id}").withSelfRel()
        )
    }
}
