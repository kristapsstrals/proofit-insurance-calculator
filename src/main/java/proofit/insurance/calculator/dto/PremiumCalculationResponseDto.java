package proofit.insurance.calculator.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PremiumCalculationResponseDto {
    private BigDecimal insurancePremium;

    private String error;

    public PremiumCalculationResponseDto(BigDecimal result) {
        this.insurancePremium = result;
    }

    public PremiumCalculationResponseDto(String error) {
        this.error = error;
    }

    public BigDecimal getInsurancePremium() {
        return this.insurancePremium;
    }

    public String getError() {
        return this.error;
    }
}
