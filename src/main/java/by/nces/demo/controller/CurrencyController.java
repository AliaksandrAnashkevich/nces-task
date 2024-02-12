package by.nces.demo.controller;

import by.nces.demo.dto.CurrencyResponse;
import by.nces.demo.dto.RateResponse;
import by.nces.demo.service.CurrencyService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/data")
    public List<RateResponse> getRate(
        @RequestParam("id") String id,
        @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
        @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return currencyService.getRateList(id, startDate, endDate);
    }

    @GetMapping("/currency")
    public List<CurrencyResponse> getCurrency() {
        return currencyService.getCurrencyList();
    }
}
