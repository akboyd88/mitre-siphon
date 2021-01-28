package xyz.andrewkboyd.mitresiphon.controllers;

import org.springframework.web.bind.annotation.*;
import xyz.andrewkboyd.mitresiphon.dao.interfaces.CVEDAO;
import xyz.andrewkboyd.mitresiphon.dto.SearchCriteria;
import xyz.andrewkboyd.mitresiphon.dto.SearchResult;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * Provides indexed search capability on live updated CVE list from NVD
 */
@RestController
@RequestMapping("api/cve")
public class CVEController {

    final CVEDAO cveDao;

    public CVEController(CVEDAO cvedao) {
        this.cveDao = cvedao;
    }

    @GetMapping("/search, produces=application/json")
    public SearchResult searchCVEList(@RequestParam @Size(min = 0) long offset,
                                      @RequestParam @Size(min = 0, max = 100) long count,
                                      @RequestParam @Size(min = 1, max = 10) List<String> terms) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setTerms(terms);
        criteria.setOffset(offset);
        criteria.setCount(count);
        return cveDao.searchForCve(criteria);
    }
}