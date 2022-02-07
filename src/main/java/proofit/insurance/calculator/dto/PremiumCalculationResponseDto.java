package proofit.insurance.calculator.dto;

import java.math.BigDecimal;

public class PremiumCalculationResponseDto {
    private BigDecimal result;

    private String error;

    public PremiumCalculationResponseDto(BigDecimal result) {
        this.result = result;
    }

    public PremiumCalculationResponseDto(String error) {
        this.error = error;
    }

    public BigDecimal getResult() {
        return this.result;
    }

    public String getError() {
        return this.error;
    }
}
