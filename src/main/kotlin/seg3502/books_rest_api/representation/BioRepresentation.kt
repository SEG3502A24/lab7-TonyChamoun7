package seg3502.books_rest_api.representation

import org.springframework.hateoas.RepresentationModel

class BioRepresentation : RepresentationModel<BioRepresentation>() {
    var id: Long = 0
    var biodata: String = ""
}
