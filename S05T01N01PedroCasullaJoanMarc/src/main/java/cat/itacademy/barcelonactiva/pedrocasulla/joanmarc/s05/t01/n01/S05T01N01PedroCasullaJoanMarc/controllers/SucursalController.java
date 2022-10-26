package cat.itacademy.barcelonactiva.pedrocasulla.joanmarc.s05.t01.n01.S05T01N01PedroCasullaJoanMarc.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n01.S05T01N01PedroCasullaJoanMarc.services.SucursalServiceImpl;
import java.util.List;
import java.util.Optional;
import cat.itacademy.barcelonactiva.pedrocasulla.joanmarc.s05.t01.n01.S05T01N01PedroCasullaJoanMarc.dto.SucursalDTO;

@Controller
//@CrossOrigin(origins = "http://localhost:8082/")
public class SucursalController {

    @Autowired
    private SucursalServiceImpl sucursalService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allsuclist", sucursalService.findAll());
        return "index";
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<SucursalDTO> getById(@PathVariable("id") long id) {
        Optional<SucursalDTO> sucursal = sucursalService.findById(id);

        if (sucursal.isPresent()) {
            return new ResponseEntity<>(sucursal.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/addnew")
    public String addNewSucursal (Model model){
        SucursalDTO sucursalDTO= new SucursalDTO();
        model.addAttribute("sucursal", sucursalDTO);
        return "newsucursal";
    }

    @PostMapping("/save")
    public String saveSucursal(@ModelAttribute("sucursal")SucursalDTO sucursalDTO) {
        sucursalService.add(sucursalDTO);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model){
        Optional<SucursalDTO> sucursalDTO = sucursalService.findById(id);
        model.addAttribute("sucursal", sucursalDTO);
        return "update";
    }

    @PutMapping("/update/{id}")

    public ResponseEntity<SucursalDTO> update(@PathVariable("id") long id, @RequestBody SucursalDTO sucursal) {
        Optional<SucursalDTO> sucursalFound = sucursalService.findById(id);

        if (sucursalFound.isPresent()) {
            SucursalDTO _sucursal = sucursalFound.get();
            _sucursal.setName(sucursal.getName());
            _sucursal.setCountry(sucursal.getCountry());
            return new ResponseEntity<>(sucursalService.add(_sucursal), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        try {
            sucursalService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/deleteSucursal/{id}")
    public String deleteById(@PathVariable(value ="id") long id)
    {
        sucursalService.deleteById(id);
        return "redirect:/";
    }
}
