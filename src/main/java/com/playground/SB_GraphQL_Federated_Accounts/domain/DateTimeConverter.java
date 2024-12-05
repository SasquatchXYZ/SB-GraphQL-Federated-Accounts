package com.playground.SB_GraphQL_Federated_Clients.domain;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Objects;

public class DateTimeConverter {
    public static OffsetDateTime toOffsetDateTime(LocalDateTime localDateTime) {
        if (Objects.isNull(localDateTime)) return null;
        return localDateTime.atZone(ZoneId.systemDefault()).toOffsetDateTime();
    }
}
