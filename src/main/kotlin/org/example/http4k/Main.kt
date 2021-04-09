package org.example.http4k

import org.http4k.core.*
import org.http4k.filter.CorsPolicy
import org.http4k.filter.Only
import org.http4k.filter.OriginPolicy
import org.http4k.filter.ServerFilters
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.routing.singlePageApp

val router: HttpHandler =
    ServerFilters.Cors(
        CorsPolicy(
            OriginPolicy.Only("http://localhost:8080"),
            headers = listOf("accept", "authorization", "content-type"),
            methods = listOf(Method.GET, Method.POST, Method.OPTIONS, Method.PUT, Method.DELETE),
            credentials = true,
        )
    ).then(
        routes(
            routes(
                "/do" bind Method.GET to { Response(Status.OK) },
                "/do" bind Method.POST to { Response(Status.CREATED) },
            ).withBasePath("/api"),

            singlePageApp()
        )
    )
