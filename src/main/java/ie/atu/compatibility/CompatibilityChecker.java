package ie.atu.compatibility;

import ie.atu.compatibility.HardwareComponents.CPU;
import ie.atu.compatibility.HardwareComponents.Motherboard;
import ie.atu.compatibility.HardwareComponents.RAM;
import org.springframework.stereotype.Component;

@Component
public class CompatibilityChecker {
    public boolean isCPUandMotherboardCompatible(CPU cpu, Motherboard motherboard) {
        return cpu.getSocket().equals(motherboard.getSocket());
    }

    public boolean isRAMandMotherboardCompatible(RAM ram, Motherboard motherboard) {
        return motherboard.getCompatibleRAMTypes().contains(ram.getRamtype());
    }
}
