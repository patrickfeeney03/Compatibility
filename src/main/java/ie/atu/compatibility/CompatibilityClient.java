package ie.atu.compatibility;

import ie.atu.compatibility.HardwareComponents.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "compatibility", url = "http://localhost:8080")
public interface CompatibilityClient {

    @GetMapping("/cpus")
    List<CPU> getCPUs(@RequestParam String name, @RequestParam String brand, @RequestParam Float price);

    @GetMapping("/gpus")
    List<GPU> getGPUs(@RequestParam String name, @RequestParam String brand, @RequestParam Float price);

    @GetMapping("/motherboards")
    ResponseEntity<List<Motherboard>> getMotherboards(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Float price,
            @RequestParam(required = false) String socket,
            @RequestParam(required = false) List<String> compatibleRAMTypes);

    @GetMapping("/rams")
    ResponseEntity<List<RAM>> getRAMs(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Float price,
            @RequestParam(required = false) List<String> cpuRamTypes,
            @RequestParam(required = false) List<String> motherboardRamTypes);

    @GetMapping("/storages")
    ResponseEntity<List<Storage>> getStorages(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Float price,
            @RequestParam(required = false) List<String> storageTypes);
}
