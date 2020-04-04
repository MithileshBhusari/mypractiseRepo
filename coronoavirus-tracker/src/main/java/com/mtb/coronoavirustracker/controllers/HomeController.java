package com.mtb.coronoavirustracker.controllers;

import com.mtb.coronoavirustracker.models.LocationStats;
import com.mtb.coronoavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> locationStatsList=coronaVirusDataService.getAllStats();
        int totalReportedCases=locationStatsList.stream().mapToInt(stats->stats.getLatestTotalCases()).sum();
        int totalNewCases=locationStatsList.stream().mapToInt(stats->stats.getDiffFromPreviousDay()).sum();
        model.addAttribute("locationStats",locationStatsList);
        model.addAttribute("totalReportedCases",totalReportedCases);
        model.addAttribute("totalNewCases",totalNewCases);
        return "home";
    }

}
