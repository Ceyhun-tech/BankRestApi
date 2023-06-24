package com.example.myspringdata.controller;

import com.example.myspringdata.entity.Hesab;

import com.example.myspringdata.entity.Logging;
import com.example.myspringdata.service.HesabService;
import com.example.myspringdata.service.LogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hesab")
public class HesabController {


   private HesabService hesabService;
   private LogController logController;
    private LogService logService;

   public HesabController(HesabService hesabService){
       this.hesabService=hesabService;
   }
   @GetMapping("/butun")
    public List<Hesab> info(){
    return hesabService.info();
   }
   @PostMapping("/yeni")
    public Hesab hesabYarat(@RequestBody Hesab hesab){
       return hesabService.hesabYarat(hesab);
   }
   @GetMapping("/balans/{id}")
    public Hesab balansabax(@PathVariable int id){
      return hesabService.balansabax(id);
   }
    @GetMapping("/hesab/{id}/balans")
    public int balanstap(@PathVariable int id) {
        return hesabService.balanstap(id);
    }
    @PutMapping("/depozit/{id}/{miqdar}")
    public void balansartir(@PathVariable Integer id, @PathVariable Integer miqdar){
        int initBal = balanstap(id);
        hesabService.balansartir(id, miqdar);
        Logging logging = new Logging(id,initBal+miqdar);
        logController.yadda(logging);
    }
    @PutMapping("/depozitazalt/{id}/{miqdar}")
    public void balansazalt(@PathVariable Integer id, @PathVariable Integer miqdar){
        int initBal = balanstap(id);
        hesabService.balansazalt(id, miqdar);
        Logging logging = new Logging(id,initBal-miqdar);
        logController.yadda(logging);
    }

    @PutMapping("/hesab/{id}/kocurme/{digerid}/{miqdar}")
    public void kocurme(@PathVariable int id, @PathVariable int digerid, @PathVariable int miqdar) {
        int balansgonder = balanstap(id);
        int balanseldeet = balanstap(digerid);
        hesabService.kocurme(id, digerid, miqdar);
        Logging gonderen = new Logging(id,  balansgonder - miqdar);
        logController.yadda(gonderen);
        Logging alan = new Logging(digerid, balanseldeet + miqdar);
        logController.yadda(alan);
    }
    @DeleteMapping("/hesab/{id}")
    public void hesabSil(@PathVariable int id) {
        hesabService.hesabSil(id);
    }
}
