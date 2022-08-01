package deenasty.data.api.service;

import deenasty.data.api.dao.DeenastyRepository;
import deenasty.data.api.http.HttpDeenasty;
import deenasty.data.api.model.Deenasty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="deenastyService")
public class DeenastyService {

    @Autowired
    private DeenastyRepository deenastyRepository;

    @Autowired
    private HttpDeenasty httpDeenasty;

    public List<Deenasty> fetchAllWikipediaDeenasties(){
        return httpDeenasty.fetchAllDeenasties(httpDeenasty.getDeenastiesHtmlPage());
    }

    public void updateAllDeenasties(){
        deenastyRepository.saveAll(fetchAllWikipediaDeenasties());
    }

    public List<Deenasty> getAllDeenasties(){
        return deenastyRepository.findAll();
    }

}
