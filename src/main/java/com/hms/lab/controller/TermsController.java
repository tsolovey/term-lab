package com.hms.lab.controller;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.lab.TermsProperties;
import com.hms.lab.exception.TermsException;
import com.hms.lab.model.Fault;
import com.hms.lab.model.Term;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TermsController {

    private final TermsProperties termsProperties;
    private final ObjectMapper objectMapper;

    public TermsController(TermsProperties termsProperties, ObjectMapper objectMapper) {
        this.termsProperties = termsProperties;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/")
    public String welcome(Model model) {
        // The data below is for demo purposes only. The real data should be extracted from a DB.
        List<Term> terms = new ArrayList<>();
        terms.add(new Term(1, "Flu", 42));
        terms.add(new Term(2, "Allergies", 12));

        // add a list of terms to the model
        model.addAttribute("terms", terms);

        // add the list of external references read from application.properties to the model
        String json = "";
        try {
            json = objectMapper.writeValueAsString(termsProperties.getReferences());
        } catch (Exception e) {
            throw new TermsException(e.getMessage());
        }
        model.addAttribute("references", json);

        return "terms";
    }

    @ExceptionHandler(TermsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    Fault handleMyRuntimeException(TermsException exception) {
        return new Fault("Internal system error. Message = " + exception.getMessage());
    }
}