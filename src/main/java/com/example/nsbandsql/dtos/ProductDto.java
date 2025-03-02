package com.example.nsbandsql.dtos;

import java.time.LocalDateTime;

public record ProductDto(String name, Long price, LocalDateTime data) {

}
