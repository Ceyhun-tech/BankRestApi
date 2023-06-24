package com.example.myspringdata.service;

import com.example.myspringdata.entity.Hesab;
import com.example.myspringdata.repository.HesabRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HesabService {
    private final HesabRepo hesabRepo;
    public HesabService(HesabRepo hesabRepo) {
        this.hesabRepo = hesabRepo;
    }
    public List<Hesab> info() {
        return hesabRepo.findAll();
    }
    public Hesab hesabYarat(Hesab hesab) {
        return hesabRepo.save(hesab);
    }
    public Hesab balansabax(int id) {
         return hesabRepo.findById(id).orElse(null);
    }
    public int balanstap(int id) {
        return hesabRepo.balanstap(id);
    }
    public void balansartir(int id, int balans) {
        hesabRepo.depozit(id,balans);
    }
    public void balansazalt(int id, int miqdar) {
            hesabRepo.balansazalt(id, miqdar);
        }
    public void kocurme(int id, int digerid, int miqdar) {
        hesabRepo.balansazalt(id, miqdar);
        hesabRepo.depozit(digerid, miqdar);
    }
    public void hesabSil(int id) {
        hesabRepo.deleteById(id);
    }


}
