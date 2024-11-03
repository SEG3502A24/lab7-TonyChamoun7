package seg3502.books_rest_api.representation

import org.springframework.hateoas.RepresentationModel

class BookTitleRepresentation : RepresentationModel<BookTitleRepresentation>() {
    var title: String = ""
    var isbn: String = ""
}
