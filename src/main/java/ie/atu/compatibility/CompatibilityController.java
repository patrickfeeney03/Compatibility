package ie.atu.compatibility;

import ie.atu.compatibility.HardwareComponents.CPU;
import ie.atu.compatibility.HardwareComponents.Motherboard;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompatibilityController {
    private final CompatibilityService compatibilityService;

    public CompatibilityController(CompatibilityService compatibilityService) {
        this.compatibilityService = compatibilityService;
    }

    @GetMapping("/nocheck/cpus")
    public List<CPU> getCPUsNoCheck() {
        return compatibilityService.getCPUS(null, null, null);
    }

    @PostMapping("/motherboards")
    public List<Motherboard> getMotherboards(@RequestBody(required = false) CompatilibityRequest compatibilityRequest) {
        return compatibilityService.getCompatibleMotherboards(compatibilityRequest);
    }
}
