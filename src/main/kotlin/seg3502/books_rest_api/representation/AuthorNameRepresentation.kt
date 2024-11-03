package seg3502.books_rest_api.representation

import org.springframework.hateoas.RepresentationModel

class AuthorNameRepresentation : RepresentationModel<AuthorNameRepresentation>() {
    var firstName: String = ""
    var lastName: String = ""
}
