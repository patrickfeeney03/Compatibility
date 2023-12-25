package ie.atu.compatibility;

import ie.atu.compatibility.HardwareComponents.CPU;
import ie.atu.compatibility.HardwareComponents.Motherboard;
import ie.atu.compatibility.HardwareComponents.RAM;
import ie.atu.compatibility.HardwareComponents.Storage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompatibilityController {
    private final CompatibilityService compatibilityService;

    public CompatibilityController(CompatibilityService compatibilityService) {
        this.compatibilityService = compatibilityService;
    }

    @PostMapping("/motherboards")
    public List<Motherboard> getMotherboards(@RequestBody(required = false) CompatibilityRequest compatibilityRequest) {
        return compatibilityService.getCompatibleMotherboards(compatibilityRequest);
    }

    @PostMapping("/rams")
    public List<RAM> getRAMs(@RequestBody(required = false) CompatibilityRequest compatibilityRequest) {
        return compatibilityService.getCompatibleRAMs(compatibilityRequest);
    }

    @PostMapping("/storages")
    public List<Storage> getStorages(@RequestBody(required = false) CompatibilityRequest compatibilityRequest) {
        return compatibilityService.getCompatibleStorages(compatibilityRequest);
    }
}
