package proofit.insurance.calculator.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proofit.insurance.calculator.domain.Policy;
import proofit.insurance.calculator.dto.PremiumCalculationResponseDto;
import proofit.insurance.calculator.services.PremiumCalculator;

@RestController()
@RequestMapping("/premium")
public class PremiumCalculatorController {

    private PremiumCalculator calculator;

    public PremiumCalculatorController(PremiumCalculator calculator) {
        this.calculator = calculator;
    }

    @PostMapping("/calculate")
    public ResponseEntity<PremiumCalculationResponseDto> calculatePremium(
            @RequestBody Policy policy) {
        try {
            var result = calculator.calculate(policy);
            return ResponseEntity.ok(new PremiumCalculationResponseDto(result));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new PremiumCalculationResponseDto(e.getMessage()));
        }
    }

}
