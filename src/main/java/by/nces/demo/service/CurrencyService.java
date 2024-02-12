package by.nces.demo.service;

import by.nces.demo.dto.CurrencyResponse;
import by.nces.demo.dto.RateResponse;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private static final String NBRB_API_URL = "https://api.nbrb.by/exrates/rates/dynamics/%s?startDate=%s&endDate=%s";
    private static final String CURRENCY_API_URL = "https://api.nbrb.by/exrates/currencies";

    public List<RateResponse> getRateList(String id,LocalDate startDate, LocalDate endDate) {
        return getJSONArray(String.format(NBRB_API_URL, id, startDate, endDate)).stream()
            .map(json -> getRateData((JSONObject) json))
            .toList();
    }

    public List<CurrencyResponse> getCurrencyList() {
        return getJSONArray(CURRENCY_API_URL).stream()
            .map(json -> getCurrencyData((JSONObject) json))
            .toList();
    }

    private JSONArray getJSONArray(String strUrl) {
        try {
            URL url = new URL(strUrl);
            JSONParser parser = new JSONParser();
            return (JSONArray) parser.parse(new InputStreamReader(url.openStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private CurrencyResponse getCurrencyData(JSONObject json) {
        return CurrencyResponse.builder()
            .id(json.get("Cur_ID").toString())
            .name(json.get("Cur_Name").toString())
            .build();
    }

    private RateResponse getRateData(JSONObject json) {

        return RateResponse.builder()
            .id(json.get("Cur_ID").toString())
            .date(LocalDateTime.parse(json.get("Date").toString()).toLocalDate())
            .money(json.get("Cur_OfficialRate").toString())
            .build();

    }


}
