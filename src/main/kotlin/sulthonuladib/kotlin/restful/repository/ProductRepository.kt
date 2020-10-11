package sulthonuladib.kotlin.restful.repository

import org.springframework.data.jpa.repository.JpaRepository
import sulthonuladib.kotlin.restful.entity.Product

interface ProductRepository : JpaRepository<Product, String> {

}