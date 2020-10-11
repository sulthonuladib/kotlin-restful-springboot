package sulthonuladib.kotlin.restful.service

import sulthonuladib.kotlin.restful.model.CreateProductRequest
import sulthonuladib.kotlin.restful.model.ProductResponse

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

}