package pl.zak.component30.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class SummaryDTO {
    private String sessionId;
    private List<ItemDTO> listOfItems;

    public SummaryDTO(String sessionId) {
        this.sessionId = sessionId;
        this.listOfItems = new ArrayList<>();
    }

    public void addElement(ItemDTO item) {
        listOfItems.add(item);
    }

    @Override
    public String toString() {
        return "SummaryDTO{" +
                "sessionId='" + sessionId + '\'' +
                ", listOfItems=" + listOfItems +
                '}';
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<ItemDTO> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(List<ItemDTO> listOfItems) {
        this.listOfItems = listOfItems;
    }
}
