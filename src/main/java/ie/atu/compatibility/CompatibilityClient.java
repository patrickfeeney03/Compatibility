package ie.atu.compatibility;

import ie.atu.compatibility.HardwareComponents.CPU;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "compatibility", url="http://localhost:8080")
public interface CompatibilityClient {

    @GetMapping("/cpus")
    List<CPU> getCPUs(@RequestParam String name, @RequestParam String brand, @RequestParam Float price);
}
