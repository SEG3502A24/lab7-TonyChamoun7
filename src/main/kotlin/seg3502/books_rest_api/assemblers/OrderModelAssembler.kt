package seg3502.books_rest_api.assemblers

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.stereotype.Component
import seg3502.books_rest_api.controller.ApiController
import seg3502.books_rest_api.entities.Order
import seg3502.books_rest_api.representation.OrderRepresentation

@Component
class OrderModelAssembler : RepresentationModelAssemblerSupport<Order, OrderRepresentation>(
    ApiController::class.java, OrderRepresentation::class.java
) {
    override fun toModel(entity: Order): OrderRepresentation {
        val representation = instantiateModel(entity)
        representation.id = entity.id
        representation.quantity = entity.quantity
        representation.add(WebMvcLinkBuilder.linkTo(
            WebMvcLinkBuilder.methodOn(ApiController::class.java).getOrderById(entity.id)
        ).withSelfRel())
        return representation
    }
}
