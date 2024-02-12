package by.nces.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyResponse {

    public String id;
    public String name;
}
