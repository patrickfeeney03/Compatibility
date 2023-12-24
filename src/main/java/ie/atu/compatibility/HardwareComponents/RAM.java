package ie.atu.compatibility.HardwareComponents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RAM {
    private Long id;

    private String name;
    private float price;
    private int capacity;
    private String ramtype;
    private String ebaylink;
}
