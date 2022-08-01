package deenasty.data.api.controller;

import deenasty.data.api.model.Deenasty;
import deenasty.data.api.service.DeenastyService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController @RequestMapping("/deenasty")
public class DeenastyController {

    @Autowired
    private DeenastyService deenastyService;

    @CrossOrigin @GetMapping("/wiki/all")
    public List<Deenasty> fetchAllDeenasties(){
        return deenastyService.fetchAllWikipediaDeenasties();
    }

    @CrossOrigin @GetMapping("/update/all")
    public void updateAllDeenasties(){
        deenastyService.updateAllDeenasties();
    }

    @CrossOrigin @GetMapping("/all")
    public List<Deenasty> getAllDeenasties(){
        return deenastyService.getAllDeenasties();
    }

}
