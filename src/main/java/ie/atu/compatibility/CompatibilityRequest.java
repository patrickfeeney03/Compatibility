package ie.atu.compatibility;
import ie.atu.compatibility.HardwareComponents.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompatibilityRequest {
    private CPU cpu;
    private GPU gpu;
    private Motherboard motherboard;
    private RAM ram;
    private Storage storage;
}
