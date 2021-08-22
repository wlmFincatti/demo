package br.com.example.demo.config.token;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Authorization {
    private String key;
    private LocalDateTime requestDateTime;
}
