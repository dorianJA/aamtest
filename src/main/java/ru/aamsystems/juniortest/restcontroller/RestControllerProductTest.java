package ru.aamsystems.juniortest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aamsystems.juniortest.model.entity.Product;
import ru.aamsystems.juniortest.service.ProductService;

@RestController
@RequestMapping("/aamsystems/api/v1")
public class RestControllerProductTest {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
        productService.save(product);
        return ResponseEntity.ok("Product saved");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.ok("Product with id: "+id+" was deleted");
    }
    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PutMapping("/update")
    public ResponseEntity<?> editProduct(@RequestBody Product p){
        productService.updateProduct(p);
        return ResponseEntity.ok(p);
    }

    @GetMapping("/find")
    public ResponseEntity<?> getProductsByName(@RequestParam String name){
        return ResponseEntity.ok(productService.getProductByName(name));
    }

}
