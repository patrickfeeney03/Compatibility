package ie.atu.compatibility;

import ie.atu.compatibility.HardwareComponents.CPU;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compatibility")
public class CompatibilityController {
    private final CompatibilityService compatibilityService;

    public CompatibilityController(CompatibilityService compatibilityService) {
        this.compatibilityService = compatibilityService;
    }

    @GetMapping("/nocheck/cpus")
    public List<CPU> getCPUsNoCheck() {
        return compatibilityService.getCPUS(null, null, null);
    }

}
