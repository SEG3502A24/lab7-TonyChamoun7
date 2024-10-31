package seg3x02.booksrestapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import seg3x02.booksrestapi.entities.Author

interface AuthorRepository : JpaRepository<Author, Long> {
    @Query("SELECT aut FROM Author aut WHERE aut.firstName = :firstName AND aut.lastName = :lastName")
    fun findAuthorsByName(firstName: String, lastName: String): List<Author>
}
