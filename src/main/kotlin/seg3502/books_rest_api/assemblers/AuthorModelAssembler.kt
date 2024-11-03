package seg3502.books_rest_api.assemblers

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.stereotype.Component
import seg3502.books_rest_api.controller.ApiController
import seg3502.books_rest_api.entities.Author
import seg3502.books_rest_api.representation.AuthorRepresentation

@Component
class AuthorModelAssembler : RepresentationModelAssemblerSupport<Author, AuthorRepresentation>(
    ApiController::class.java, AuthorRepresentation::class.java
) {
    override fun toModel(entity: Author): AuthorRepresentation {
        val representation = instantiateModel(entity)
        representation.id = entity.id
        representation.firstName = entity.firstName
        representation.lastName = entity.lastName
        representation.add(WebMvcLinkBuilder.linkTo(
            WebMvcLinkBuilder.methodOn(ApiController::class.java).getAuthorById(entity.id)
        ).withSelfRel())
        return representation
    }
}
