package ie.atu.compatibility;

import ie.atu.compatibility.HardwareComponents.CPU;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompatibilityService {
    private final CompatibilityChecker compatibilityChecker;
    private final CompatibilityClient compatibilityClient;

    public CompatibilityService(CompatibilityChecker compatibilityChecker, CompatibilityClient compatibilityClient) {
        this.compatibilityChecker = compatibilityChecker;
        this.compatibilityClient = compatibilityClient;
    }

    public List<CPU> getCPUS(String name, String brand, Float price) {
        List<CPU> CPUs = compatibilityClient.getCPUs(name, brand, price);
        return CPUs;
    }

    //public boolean checkCompatibility()


}
