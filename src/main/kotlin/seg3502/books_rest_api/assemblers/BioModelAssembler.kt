package seg3502.books_rest_api.assemblers

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.stereotype.Component
import seg3502.books_rest_api.controller.ApiController
import seg3502.books_rest_api.entities.Bio
import seg3502.books_rest_api.representation.BioRepresentation

@Component
class BioModelAssembler : RepresentationModelAssemblerSupport<Bio, BioRepresentation>(
    ApiController::class.java, BioRepresentation::class.java
) {
    override fun toModel(entity: Bio): BioRepresentation {
        val representation = instantiateModel(entity)
        representation.id = entity.id
        representation.biodata = entity.biodata
        representation.add(WebMvcLinkBuilder.linkTo(
            WebMvcLinkBuilder.methodOn(ApiController::class.java).getBioById(entity.id)
        ).withSelfRel())
        return representation
    }
}
