package pl.zak.component30.service;

import org.springframework.stereotype.Service;
import pl.zak.component30.entity.Offer;
import pl.zak.component30.model.*;
import pl.zak.component30.repository.OfferRepository;

import javax.swing.text.Caret;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GlobalCartService {
    private final OfferRepository offerRepository;

    public GlobalCartService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public String createNewSession() {
        String sessionId = UUID.randomUUID().toString().substring(0, 16).replaceAll("-", "");
        GlobalCart.createNewClient(sessionId);
        return sessionId;
    }

    public ClientCartDTO addNewItemn(String sessionId, String productCode, int quantity) throws Exception {
        if(entryDataValidation(sessionId, productCode, quantity))
            throw new Exception("ID or productCode is wrong");
        ClientCartDTO clientCartDTO = GlobalCart.getClient(sessionId);
        productAddProcess(clientCartDTO.getItems(), productCode, quantity);
        GlobalCart.update(sessionId, clientCartDTO);
        return clientCartDTO;
    }

    private void productAddProcess(HashMap<String, Integer> hashMap, String productCode, int quantity) {
        int qValue = quantityValue(quantity);
        if(hashMap.containsKey(productCode)) {
            hashMap.put(productCode, hashMap.get(productCode) + qValue);
        } else {
            hashMap.put(productCode, qValue);
        }
    }

    public OfferDTO getSingleOffer(String productCode) throws Exception {
        return offerRepository.findByItem(productCode)
                .map(offer -> OfferDTO.builder()
                        .id(offer.getId())
                        .item(offer.getItem())
                        .normalPrice(offer.getNormalPrice())
                        .requiredQuantity(offer.getRequiredQuantity())
                        .specialPrice(offer.getSpecialPrice())
                        .build())
                .orElseThrow(() -> new Exception("Product code doesn't exists"));
    }
    
    public SummaryDTO summary(String sessionId) {
        ClientCartDTO clientCartDTO = GlobalCart.getClient(sessionId);
        SummaryDTO summaryDTO = countDiscounts(clientCartDTO.getItems(), sessionId);
        GlobalCart.remove(sessionId);
        return summaryDTO;
    }

    private int quantityValue(int quantity) {
        if(quantity == 0)
            return 1;
        return quantity;
    }

    public boolean entryDataValidation(String sessionId, String productCode, int quantity) {
        if(sessionId == null || sessionId.isEmpty() || productCode == null || quantity < 0 || offerRepository.findByItem(productCode).isEmpty())
            return true;
        return false;
    }

    private SummaryDTO countDiscounts(HashMap<String, Integer> hashMap, String sessionId) {
        SummaryDTO summaryDTO = new SummaryDTO(sessionId);
        for(Map.Entry<String, Integer> e: hashMap.entrySet()) {
            OfferDTO offerDTO = offerRepository.findByItem(e.getKey())
                    .map(offer -> OfferDTO.builder()
                            .id(offer.getId())
                            .item(offer.getItem())
                            .normalPrice(offer.getNormalPrice())
                            .requiredQuantity(offer.getRequiredQuantity())
                            .specialPrice(offer.getSpecialPrice())
                            .build()).get();

            ItemDTO itemDTO = countDiscount(offerDTO, e.getValue());


            summaryDTO.addElement(itemDTO);
        }

        return summaryDTO;
    }

    private ItemDTO countDiscount(OfferDTO offerDTO, Integer quantity) {
        if(offerDTO.getRequiredQuantity() == null || offerDTO.getSpecialPrice() == null) {
            return new ItemDTO(offerDTO.getItem(), quantity, offerDTO.getNormalPrice() * quantity);
        }

        int rest = quantity % offerDTO.getRequiredQuantity();

        float finalPrice = (quantity % offerDTO.getRequiredQuantity() == quantity) ?
                quantity * offerDTO.getNormalPrice()
                : (rest * offerDTO.getNormalPrice()) + (quantity - rest) * offerDTO.getSpecialPrice();

        return new ItemDTO(
                offerDTO.getItem(),
                quantity,
                finalPrice);
    }

    //TODO: testy :(
    //TODO: zrobienie redme :(
}
