package pl.zak.component30.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zak.component30.entity.Offer;
import pl.zak.component30.model.ClientCartDTO;
import pl.zak.component30.model.GlobalCart;
import pl.zak.component30.model.OfferDTO;
import pl.zak.component30.model.SummaryDTO;
import pl.zak.component30.service.GlobalCartService;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class Controller {
    private final GlobalCart globalCart;
    private final GlobalCartService globalCartService;
    public Controller(GlobalCart globalCart, GlobalCartService globalCartService) {
        this.globalCart = globalCart;
        this.globalCartService = globalCartService;
    }

    @GetMapping("/startNewSession")
    public ResponseEntity<String> createNewSession() {
        String result = globalCartService.createNewSession();
        return ResponseEntity
                .ok("Cart with " + result + " has been created. Use the sessionId to identify your shopping cart.");
    }

    @PostMapping("/add")
    public ResponseEntity<HashMap<String, Integer>> addNewProduct(
            @RequestHeader("sessionId") String sessionId,
            @RequestParam(name = "productCode") String productCode,
            @RequestParam(name = "quantity", required = false, defaultValue = "0") Integer quantity) throws Exception {
        ClientCartDTO clientCartDTO = globalCartService.addNewItemn(sessionId, productCode, quantity);
        return ResponseEntity.ok(clientCartDTO.getItems());
    }

    @GetMapping("/checkout")
    public ResponseEntity<SummaryDTO> summary(
            @RequestHeader(name = "sessionId") String sessionId
    ) {
        return ResponseEntity.ok(globalCartService.summary(sessionId));
    }

    @GetMapping("/scan")
    public ResponseEntity<OfferDTO> scanProduct(
            @RequestParam(name = "productCode") String productCode) throws Exception {
        return ResponseEntity.ok(globalCartService.getSingleOffer(productCode));
    }
}
