package kr.co.sungbin.eatgo.interfaces;

import kr.co.sungbin.eatgo.application.RegionService;
import kr.co.sungbin.eatgo.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/regions")
    public List<Region> list() {

        return regionService.getRegions();
    }
}
