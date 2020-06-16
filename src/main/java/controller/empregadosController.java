package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exeption.ResourceNotFoundException;
import model.empregados;
import repository.empregadosRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class empregadosController {
    @Autowired
    private empregadosRepository empregadoRepository;

    @GetMapping("/empregados")
    public List<empregados> getAllEmployees() {
        return empregadoRepository.findAll();
    }

    @GetMapping("/empregados/{id}")
    public ResponseEntity<empregados> getEmployeeById(@PathVariable(value = "id") Long empregadoId)
        throws ResourceNotFoundException {
        empregados empregado = empregadoRepository.findById(empregadoId)
          .orElseThrow(() -> new ResourceNotFoundException("Não existe funcionado para este id :: " + empregadoId));
        return ResponseEntity.ok().body(empregado);
    }
    
    @PostMapping("/empregados")
    public empregados createEmployee(@Validated @RequestBody empregados empregados) {
        return empregadoRepository.save(empregados);
    }

    @PutMapping("/empregados/{id}")
    public ResponseEntity<empregados> updateEmployee(@PathVariable(value = "id") Long empregadoId,
         @Validated @RequestBody empregados employeeDetails) throws ResourceNotFoundException {
        empregados empregado = empregadoRepository.findById(empregadoId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empregadoId));

        empregado.setEmailId(employeeDetails.getEmailId());
        empregado.setPrimeroNome(employeeDetails.getPrimeroNome());
        empregado.setSobrenome(employeeDetails.getSobrenome());
        final empregados updatedEmpregado = empregadoRepository.save(empregado);
        return ResponseEntity.ok(updatedEmpregado);
    }

    @DeleteMapping("/empregados/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long empregadoId)
         throws ResourceNotFoundException {
    	empregados empregados = empregadoRepository.findById(empregadoId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empregadoId));

    	empregadoRepository.delete(empregados);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}
