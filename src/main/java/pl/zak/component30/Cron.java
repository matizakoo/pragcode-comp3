package pl.zak.component30;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.hibernate.validator.internal.util.logging.Log_$logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.zak.component30.model.ClientCartDTO;
import pl.zak.component30.model.GlobalCart;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class Cron {
    private final GlobalCart globalCart;

    public Cron(GlobalCart globalCart) {
        this.globalCart = globalCart;
    }

//    if there is no action during 5 minutes shopping card is being removed
//    cron runs every 10s
    @Scheduled(fixedRate = 10 * 1000)
    public void runCron() {
        System.out.println("Starting cron");
        HashMap<String, ClientCartDTO> hashMap = GlobalCart.getHashMap();
        if(hashMap.isEmpty())
            return;
        for(Map.Entry<String, ClientCartDTO> entry: hashMap.entrySet()) {
            if(entry.getValue().getLocalDateTime().plusMinutes(5).isBefore(LocalDateTime.now())) {
                System.out.println("Removing shopping card: " + entry.getKey());
                GlobalCart.remove(entry.getKey());
            }
        }
    }
}
