package pl.zak.component30.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.HashMap;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientCartDTO {
    private HashMap<String, Integer> items = new HashMap<>();
    private LocalDateTime localDateTime;

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public ClientCartDTO(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
