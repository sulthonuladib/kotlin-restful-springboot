package sulthonuladib.kotlin.restful.model

class WebResponse<T>(
        val code: Int,
        val status: String,
        val data: T
) {
}