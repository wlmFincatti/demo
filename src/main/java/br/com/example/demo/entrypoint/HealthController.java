package br.com.example.demo.entrypoint;

import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController("health-custom")
public class HealthController {

    @GetMapping
    public Object getHealthCustom() {
        HashMap<String, Object> metrics = new HashMap<>();
        metrics.put("avaibleCpus", Runtime.getRuntime().availableProcessors());
        metrics.put("totalMemory", Runtime.getRuntime().totalMemory());
        metrics.put("maxMemory", Runtime.getRuntime().maxMemory());
        return Health.up().withDetails(metrics).build();
    }

}
