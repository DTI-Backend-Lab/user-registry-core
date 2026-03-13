package io.github.henriqueaguiiar.user_registry_core_api.util;


import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DataConfiguration {

    /**
     * Return the current date and time in the "America/Sao_Paulo" timezone as an Instant.
     * @return the current date and time in the "America/Sao_Paulo" timezone as an Instant
     */
    public static ZonedDateTime nowAtSaoPaulo() {
        return ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }

}
