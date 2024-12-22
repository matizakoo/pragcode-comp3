package pl.zak.component30.model;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.util.LangUtil;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@Component
public class GlobalCart {
    private final static HashMap<String, ClientCartDTO> hashMap = new HashMap<>();

    public static void createNewClient(String sessionId) {
        hashMap.put(sessionId, new ClientCartDTO(LocalDateTime.now()));
    }

    public static ClientCartDTO getClient(String sessionId) {
        ClientCartDTO clientCartDTO = hashMap.get(sessionId);
        if(clientCartDTO == null)
            throw new RuntimeException("Client doesn't exist or expired (expiration time is 5m)");

        return clientCartDTO;
    }

    public static void update(String sessionId, ClientCartDTO clientCartDTO) {
        clientCartDTO.setLocalDateTime(LocalDateTime.now());
        hashMap.put(sessionId, clientCartDTO);
    }

    public static void remove(String sessionId) {
        hashMap.remove(sessionId);
    }

    public static HashMap<String, ClientCartDTO> getHashMap() {
        return hashMap;
    }
}
