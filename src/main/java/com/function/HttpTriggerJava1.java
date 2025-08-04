package com.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class HttpTriggerJava1 {
    /**
     * This function listens at endpoint "/api/HttpTriggerJava1". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpTriggerJava1
     * 2. curl {your host}/api/HttpTriggerJava1?name=HTTP%20Query
     */
   @FunctionName("HttpTriggerJava1")
public HttpResponseMessage run(
        @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS)
        HttpRequestMessage<Optional<String>> request,
        final ExecutionContext context) {

    context.getLogger().info("Java HTTP trigger processed a request.");

    // Log the raw body for debugging webhook data
    String body = request.getBody().orElse("No body received");
    context.getLogger().info("Webhook Payload Body: " + body);

    return request.createResponseBuilder(HttpStatus.OK).body("Webhook received!").build();
}

}
