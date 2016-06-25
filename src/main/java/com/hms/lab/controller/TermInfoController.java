package com.hms.lab.controller;

import com.hms.lab.model.ExternalReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("term")
public class TermInfoController {

    @RequestMapping(value = "/resources", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExternalReference> getExternalReferencesForTerm(@RequestParam(value="termId", required=true) long termId) {

        // The data below is for demo purposes only. The real data should be extracted from a DB.
        List<ExternalReference> externalReferences = new ArrayList<ExternalReference>();
        externalReferences.add(new ExternalReference("Google", "https://www.google.com/search?q="));
        externalReferences.add(new ExternalReference("Yahoo!", "https://search.yahoo.com/search?p="));

        return externalReferences;
    }
}
