package co.com.mend1001.springbootbakend.DTO;

import java.math.BigDecimal;

public class SalarySumResponseDTO {
    private BigDecimal sum;

    public SalarySumResponseDTO(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
