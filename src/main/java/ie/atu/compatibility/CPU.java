package ie.atu.compatibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CPU {
    private Long id; // Unique Key

    private String name;
    private float price;
    private String socket;
    private String frequency;
    private String brand;
    private String ebaylink;
}
