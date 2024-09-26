package construcao_software.ingresso_back.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import construcao_software.ingresso_back.controller.dto.SampleDTO;


public class Controller {
    @GetMapping("/")
    @CrossOrigin
    public String getSample() {
        return "hello world";
    }

    @PutMapping("/")
    @CrossOrigin
    public void updateSample(@RequestParam SampleDTO sample){

    }

    @PatchMapping("/")
    @CrossOrigin
    public SampleDTO update(@RequestParam SampleDTO sample){
        return sample;
    }

    @DeleteMapping
    @CrossOrigin
    public SampleDTO deleteSample(@RequestParam SampleDTO sample){
        return sample;
    }

}
