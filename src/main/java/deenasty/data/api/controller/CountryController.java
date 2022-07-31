package deenasty.data.api.controller;

import deenasty.data.api.model.Country;
import deenasty.data.api.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @CrossOrigin @GetMapping("/all")
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

}
