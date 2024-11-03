package seg3502.books_rest_api.representation

import org.springframework.hateoas.RepresentationModel

class AuthorRepresentation : RepresentationModel<AuthorRepresentation>() {
    var id: Long = 0
    var firstName: String = ""
    var lastName: String = ""
}
