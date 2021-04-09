package org.example.http4k

import org.http4k.core.Method
import org.http4k.core.Request
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestCase {

    @Test
    fun `should set correct cors header on response for options request`() {
        val response = router(Request(Method.OPTIONS, "/api/do").header("Origin", "http://localhost:8080"))
        assertEquals("http://localhost:8080", response.header("access-control-allow-origin"))
    }
}
