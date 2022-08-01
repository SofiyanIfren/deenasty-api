package deenasty.data.api.http;

import deenasty.data.api.model.Deenasty;
import deenasty.data.api.service.DeenastyService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class HttpDeenasty {

    public List<Deenasty> fetchAllDeenasties(String deenastiesHtmlPage){
        Document doc = Jsoup.parseBodyFragment(deenastiesHtmlPage);
        Elements elements = doc.getElementsByClass("mw-redirect");
        List<Deenasty> deenasties = new ArrayList<>();
        for (Element element : elements){
            Deenasty deenasty = new Deenasty();
            if (!element.text().equals("Islamic prophet") && !element.text().equals("his death")){
                deenasty.setName(element.text());
                deenasty.setLink("https://en.wikipedia.org" + element.attr("href"));
                deenasties.add(deenasty);
            }
        }
        return deenasties;
    }

    public String getDeenastiesHtmlPage(){
        RestTemplate restTemplate = new RestTemplate();
        String countriesUrl = "https://en.wikipedia.org/wiki/List_of_Muslim_states_and_dynasties#Mesopotamia_and_Levant_(Iraq,_Syria,_Lebanon,_Jordan,_Palestine)";
        return restTemplate.getForObject(countriesUrl, String.class);
    }

}
