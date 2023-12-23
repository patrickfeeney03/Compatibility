package ie.atu.compatibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GPU {
    private Long id;

    private String name;
    private float price;
    private String brand;
    private float vram;
    private String ebaylink;
}
