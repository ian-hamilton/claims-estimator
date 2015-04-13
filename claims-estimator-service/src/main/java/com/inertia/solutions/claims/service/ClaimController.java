package com.inertia.solutions.claims.service;
import com.inertia.solutions.claims.service.domain.Claim;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebJson(jsonObject = Claim.class)
@Controller
@RequestMapping("/claims")
public class ClaimController {
}
