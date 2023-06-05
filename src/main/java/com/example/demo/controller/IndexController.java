package com.example.demo.controller;


import com.example.demo.Calculator;
import com.example.demo.Database;
import com.example.demo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

    @Autowired
    private Repository repository;

    @GetMapping("/calc")
    public HashMap user(@RequestParam("first") Integer firstParam, @RequestParam("second") Integer secondParam) {

        HashMap<String, Integer> response = new HashMap<>();
        Calculator calculator = new Calculator();

        int     add = calculator.add(firstParam, secondParam),
                sub = calculator.sub(firstParam, secondParam),
                mult = calculator.mult(firstParam, secondParam),
                div = calculator.div(firstParam, secondParam);


        Database db = new Database(add, sub, mult, div);


        response.put("add", add);
        response.put("sub", sub);
        response.put("mult", mult);
        response.put("div", div);

        repository.save(db);

        return response;
    }


    @GetMapping("/all")
    public List<Database> getAll(){
        return repository.findAll();
    }
}
//1.  В среде Intellij IDEA Ultimate и используя Spring Framework Java написать клиент серверное приложение с микросервисной архитектурой.
//        2.  Сервер должен принимать два аргумента и возвращать их сумму/разность.
//        3.  Сгенерировать веб-интерфейс для ваших SpringBoot API с помощью Swagger 3.0.0.
//        4.  * Написать тесты на проект.
//        5.  *** Подключить in-memory БД и сохранять туда все результаты расчетов калькулятора.
//        6.  *** Добавить еще одну API, которая по GET-запросу будет возвращать все сохранённые записи в БД.