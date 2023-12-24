package ie.atu.compatibility;

import ie.atu.compatibility.HardwareComponents.CPU;
import ie.atu.compatibility.HardwareComponents.Motherboard;
import ie.atu.compatibility.HardwareComponents.RAM;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CompatibilityService {
    private final CompatibilityClient compatibilityClient;

    public CompatibilityService(CompatibilityClient compatibilityClient) {
        this.compatibilityClient = compatibilityClient;
    }

    public List<CPU> getCPUS(String name, String brand, Float price) {
        List<CPU> CPUs = compatibilityClient.getCPUs(name, brand, price);
        return CPUs;
    }

    public List<Motherboard> getCompatibleMotherboards(CompatilibityRequest compatibilityRequest) {
        String socket = null;
        List<String> compatibleRAMTypes = null;

        if (compatibilityRequest != null) {
            if (compatibilityRequest.getCpu() != null) {
                socket = compatibilityRequest.getCpu().getSocket();
            } else {
                System.out.println("CPU is null");
            }

            if (compatibilityRequest.getRam() != null) {
                compatibleRAMTypes = Arrays.asList(compatibilityRequest.getRam().getRamtype());
            } else {
                System.out.println("RAM is null");
            }
        }

        ResponseEntity<List<Motherboard>> motherboards = compatibilityClient.getMotherboards(
                null,
                null,
                null,
                socket,
                compatibleRAMTypes
        );
        return motherboards.getBody();
    }
}
