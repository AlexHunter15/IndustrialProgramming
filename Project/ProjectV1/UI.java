import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/fabric")
public class FabricController {
    private final ArrayList<Fabric> fabrics = new ArrayList<>();

    @GetMapping("/details")
    public String displayFabricDetails(Model model) {
        model.addAttribute("fabrics", fabrics);
        return "fabric-details";
    }

    @PostMapping("/update")
    public String updateFabricDetails(@RequestParam String type, @RequestParam String place, @RequestParam int amount) {
        Fabric fabric = new Fabric(type, place, amount);
        fabrics.add(fabric);
        return "redirect:/fabric/details";
    }
}
