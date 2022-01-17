package bf.isge.Bank.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionDto {
    private long id;
    private double montantTran;
    private int destNum;
    private LocalDateTime date;
}
