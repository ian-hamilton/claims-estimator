package com.inertia.solutions.claims.mvc.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inertia.solutions.claims.mvc.app.calculator.command.impl.OperatorCommandInvoker;
import com.inertia.solutions.claims.mvc.web.model.CalculationModel;
import com.inertia.solutions.claims.mvc.web.model.OperatorModel;

/*
 * http://localhost:8080/claims-estimator-mvc/calculator
 */

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
	
	@Autowired
	OperatorCommandInvoker operatorCommandInvoker;
	
	@RequestMapping(method = RequestMethod.GET)
	public String get(@ModelAttribute CalculationModel calculationModel, Model model) {
		return "calculator";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute @Valid CalculationModel calculationModel, BindingResult bindingResult, Model model) {
		if(!bindingResult.hasErrors()) {
			Integer intVal1 = new Integer(calculationModel.getValue1());
			Integer intVal2 = new Integer(calculationModel.getValue2());
			Integer result = operatorCommandInvoker.invoke(calculationModel.getOperator()).exec(intVal1, intVal2);
			model.addAttribute("result", result);
		}
		return "calculator";
	}
	
	@ModelAttribute
	public void processSubmit(@ModelAttribute CalculationModel calculationModel, Model model) {
		if(calculationModel == null)
			model.addAttribute(new CalculationModel());
		model.addAttribute(new OperatorModel());	
	}
	
}
