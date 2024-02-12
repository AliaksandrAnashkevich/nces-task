package by.nces.demo.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RateResponse {

    private String id;
    private LocalDate date;
    private String money;
}
