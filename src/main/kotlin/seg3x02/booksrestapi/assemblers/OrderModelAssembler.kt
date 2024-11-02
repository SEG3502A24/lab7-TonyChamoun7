package seg3x02.booksrestapi.assemblers

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Component
import seg3x02.booksrestapi.controller.ApiController
import seg3x02.booksrestapi.entities.Order
import seg3x02.booksrestapi.representation.OrderRepresentation

@Component
class OrderModelAssembler : RepresentationModelAssemblerSupport<Order, OrderRepresentation>(
    ApiController::class.java, OrderRepresentation::class.java
) {
    override fun toModel(entity: Order): OrderRepresentation {
        val orderRepresentation = instantiateModel(entity)
        orderRepresentation.add(
            linkTo(ApiController::class.java)
                .slash("orders/${entity.id}").withSelfRel()
        )
        return orderRepresentation
    }
}
