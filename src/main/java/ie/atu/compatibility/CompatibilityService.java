package ie.atu.compatibility;

import ie.atu.compatibility.HardwareComponents.CPU;
import ie.atu.compatibility.HardwareComponents.Motherboard;
import ie.atu.compatibility.HardwareComponents.RAM;
import ie.atu.compatibility.HardwareComponents.Storage;
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

    public List<Motherboard> getCompatibleMotherboards(CompatibilityRequest compatibilityRequest) {
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
                socket,
                compatibleRAMTypes
        );
        return motherboards.getBody();
    }

    public List<RAM> getCompatibleRAMs(CompatibilityRequest compatibilityRequest) {
        List<String> cpuRamTypes = null;
        List<String> motherboardRamTypes = null;

        if (compatibilityRequest != null) {
            if (compatibilityRequest.getCpu() != null) {
                cpuRamTypes = compatibilityRequest.getCpu().getCompatibleRAMTypes();
            }
            if (compatibilityRequest.getMotherboard() != null) {
                motherboardRamTypes = compatibilityRequest.getMotherboard().getCompatibleRAMTypes();
            }
        }

        ResponseEntity<List<RAM>> rams = compatibilityClient.getRAMs(
                cpuRamTypes,
                motherboardRamTypes
        );

        return rams.getBody();
    }

    public List<Storage> getCompatibleStorages(CompatibilityRequest compatibilityRequest) {
        List<String> storageTypes = null;

        if (compatibilityRequest != null) {
            if (compatibilityRequest.getMotherboard() != null) {
                storageTypes = compatibilityRequest.getMotherboard().getCompatibleStorageTypes();
            }
        }

        ResponseEntity<List<Storage>> storages = compatibilityClient.getStorages(
                storageTypes
        );

        return storages.getBody();
    }
}
