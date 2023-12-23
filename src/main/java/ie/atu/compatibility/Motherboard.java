package ie.atu.compatibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Motherboard {
    private Long id;

    private String name;
    private float price;
    private String brand;
    private String socket;
    private String chipset;
    private String ebaylink;
}
