package com.green.todo.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@OpenAPIDefinition(
        info = @Info(
                title = "투두리스트",
                description = "투두리스트",
                version = "v1"
        )
)

public class SwaggerConfiguration {

}
