package com.panpass.project.contro;


import com.panpass.project.dao.AtestaMapper;
import com.panpass.project.entity.Atesta;
import com.panpass.project.entity.AtestaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoContro {

    @Autowired
    private AtestaMapper atestaMapper;



    @RequestMapping(value = "/1")
    public Map test(){
        Map map = new HashMap<String,List>();

       AtestaExample atestaExample = new AtestaExample();
       List<Atesta> atestas = atestaMapper.selectByExample(atestaExample);

        map.put("name",atestas);

        return map;
    }
 }
