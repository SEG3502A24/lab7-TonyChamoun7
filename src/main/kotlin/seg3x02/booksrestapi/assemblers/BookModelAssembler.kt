package seg3x02.booksrestapi.assemblers

import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Component
import seg3x02.booksrestapi.controller.ApiController
import seg3x02.booksrestapi.entities.Book
import seg3x02.booksrestapi.entities.Order
import seg3x02.booksrestapi.representation.BookRepresentation
import seg3x02.booksrestapi.representation.OrderRepresentation

@Component
class BookModelAssembler : RepresentationModelAssemblerSupport<Book, BookRepresentation>(
    ApiController::class.java, BookRepresentation::class.java
) {
    override fun toModel(entity: Book): BookRepresentation {
        val bookRepresentation = instantiateModel(entity)
        bookRepresentation.add(
            linkTo(ApiController::class.java)
                .slash("books/${entity.id}").withSelfRel()
        )
        bookRepresentation.orders = entity.orders.map { orderRepresentation(it) } // Ensure `orders` exists in `Book`
        return bookRepresentation
    }

    private fun orderRepresentation(order: Order): OrderRepresentation {
        val representation = OrderRepresentation()  // Check OrderRepresentation structure
        return representation.add(
            linkTo(ApiController::class.java).slash("orders/${order.id}").withSelfRel()
        )
    }
}
