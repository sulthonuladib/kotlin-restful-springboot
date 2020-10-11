package sulthonuladib.kotlin.restful.service

import sulthonuladib.kotlin.restful.model.CreateProductRequest
import sulthonuladib.kotlin.restful.model.ProductResponse
import sulthonuladib.kotlin.restful.model.UpdateProductRequest

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse

}