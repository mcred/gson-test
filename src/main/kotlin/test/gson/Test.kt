package test.gson

import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName

data class Operation(
    var id: String,
    var type: Type
) {
    enum class Type(val value: String) {
        @SerializedName("PUSH")
        PUSH("PUSH"),
        @SerializedName("PULL")
        PULL("PULL")
    }
}

object Test {./g
    private val json = """{
    "id": "b5aa8d7f-423b-48d4-bd47-7e14a15f26e2",
    "type": "PULL"
}"""
    private val adapter = RuntimeTypeAdapterFactory
        .of(Operation::class.java)

    private val gson = GsonBuilder()
        .create()

    @JvmStatic
    fun main(args: Array<String>) {
        val operation = gson.fromJson(json, Operation::class.java)
        println(operation)
    }
}