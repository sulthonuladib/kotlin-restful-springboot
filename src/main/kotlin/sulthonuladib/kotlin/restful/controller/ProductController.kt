package sulthonuladib.kotlin.restful.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import sulthonuladib.kotlin.restful.model.CreateProductRequest
import sulthonuladib.kotlin.restful.model.ProductResponse
import sulthonuladib.kotlin.restful.model.WebResponse
import sulthonuladib.kotlin.restful.service.ProductService

@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
            value = ["/api/products"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )

    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)

        return WebResponse(
                code = 200,
                status = "success",
                data = productResponse
        )

    }
}