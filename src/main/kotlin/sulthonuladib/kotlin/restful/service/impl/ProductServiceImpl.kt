package sulthonuladib.kotlin.restful.service.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import sulthonuladib.kotlin.restful.entity.Product
import sulthonuladib.kotlin.restful.error.NotFoundException
import sulthonuladib.kotlin.restful.model.CreateProductRequest
import sulthonuladib.kotlin.restful.model.ProductResponse
import sulthonuladib.kotlin.restful.model.UpdateProductRequest
import sulthonuladib.kotlin.restful.repository.ProductRepository
import sulthonuladib.kotlin.restful.service.ProductService
import sulthonuladib.kotlin.restful.validation.ValidationUtil
import java.util.*

@Service
class ProductServiceImpl(val productRepository: ProductRepository, val validationUtil: ValidationUtil) : ProductService {

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest)
        val product = Product(
                id = createProductRequest.id!!,
                name = createProductRequest.name!!,
                price = createProductRequest.price!!,
                quantity = createProductRequest.quantity!!,
                createdAt = Date(),
                updatedAt = null
        )

        productRepository.save(product)

        return convertProductToResponse(product)
    }

    override fun get(id: String): ProductResponse {
        val product = productRepository.findByIdOrNull(id)
        if ( product == null) {
            throw NotFoundException()
        } else {
            return convertProductToResponse(product)
        }
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        val product = productRepository.findByIdOrNull(id)

        if ( product == null) {
            throw NotFoundException()
        }

        validationUtil.validate(updateProductRequest)

        product.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updatedAt = Date()
        }

        productRepository.save(product)

        return convertProductToResponse(product)
    }

    private fun convertProductToResponse(product: Product): ProductResponse {
        return ProductResponse(
                id = product.id,
                name = product.name,
                price = product.price,
                quantity = product.quantity,
                createdAt = product.createdAt,
                updatedAt = product.updatedAt
        )
    }

}