package br.com.example.demo.entrypoint.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.Builder;
import lombok.Getter;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("health-metrics-custom")
@RestController
public class HealthMetricsController {

    @Operation(
        summary = "metrics custom",
        description = "Get metrics and Health Custom",
        responses = @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = Map.class, description = "return avaible cpus, total and max memory")))
    )
    @GetMapping
    public Health getHealthCustom() {
        Runtime runtime = Runtime.getRuntime();
        HashMap<String, MetricsCustom> metrics = new HashMap<>();

        metrics.put("metrics", MetricsCustom.builder()
            .avaibleCpus(runtime.availableProcessors())
            .maxMemory(runtime.maxMemory())
            .freeMemory(runtime.freeMemory())
            .totalMemory(runtime.totalMemory())
            .build());

        return Health.up().withDetails(metrics).build();
    }

}

@Builder
@Getter
class MetricsCustom {
    private Integer avaibleCpus;
    private Long freeMemory;
    private Long totalMemory;
    private Long maxMemory;
}


