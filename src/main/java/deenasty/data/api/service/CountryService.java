package deenasty.data.api.service;

import deenasty.data.api.dao.CountryRepository;
import deenasty.data.api.http.HttpCountry;
import deenasty.data.api.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="countryService")
public class CountryService {
    @Autowired
    private HttpCountry httpCountry;

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries(){
        String httpCountriesPage = httpCountry.getCountriesHtmlPage();
        return httpCountry.getAllCountries(httpCountriesPage);
    }

}
