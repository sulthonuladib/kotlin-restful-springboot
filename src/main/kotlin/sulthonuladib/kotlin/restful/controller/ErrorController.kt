package sulthonuladib.kotlin.restful.controller

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import sulthonuladib.kotlin.restful.model.WebResponse
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String?> {
        return WebResponse(
                code = 400,
                status = "Bad request",
                data = constraintViolationException.message!!
        )
    }

}