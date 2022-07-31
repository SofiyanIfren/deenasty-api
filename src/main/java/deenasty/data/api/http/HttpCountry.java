package deenasty.data.api.http;

import deenasty.data.api.model.Country;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service(value="httpCountryService")
public class HttpCountry {
    public ArrayList<Country> getAllCountries(String htmlCountriesPage){
        Document doc = Jsoup.parseBodyFragment(htmlCountriesPage);
        Elements mainTbodyNodes = doc.getElementsByTag("tbody");
        ArrayList <Country> countries = new ArrayList <>();
        for (Element element : mainTbodyNodes.get(0).select("tr > td")){
            if(!element.select("span > img").attr("src").equals("")){
                Country country = new Country();
                country.setName(element.select("a").text());
                country.setFlagLink("https:" + element.select("span > img").attr("src"));
                // TODO : get details from html page + add it to the country then return it (City + Langauges)
                // setCountryDetails(country, getCountryDetailsHtmlPage(country.getName()));
                countries.add(country);
            }
        }
        return countries;
    }

    public Country setCountryDetails (Country country, String countryDetailsHtmlPage){
        return country;
    }

    public String getCountriesHtmlPage(){
        RestTemplate restTemplate = new RestTemplate();
        String countriesUrl = "https://en.wikipedia.org/wiki/List_of_Arab_countries_by_population";
        return restTemplate.getForObject(countriesUrl, String.class);
    }

    public String getCountryDetailsHtmlPage(String countryName){
        RestTemplate restTemplate = new RestTemplate();
        String countryDetailsUrl = "https://en.wikipedia.org/wiki/" + countryName;
        return restTemplate.getForObject(countryDetailsUrl, String.class);
    }
}
