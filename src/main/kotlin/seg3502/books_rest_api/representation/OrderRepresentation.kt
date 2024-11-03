package seg3502.books_rest_api.representation

import org.springframework.hateoas.RepresentationModel

class OrderRepresentation : RepresentationModel<OrderRepresentation>() {
    var id: Long = 0
    var quantity: Int = 0
}
