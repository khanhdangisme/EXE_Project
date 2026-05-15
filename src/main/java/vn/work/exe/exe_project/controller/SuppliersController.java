package vn.work.exe.exe_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.work.exe.exe_project.dto.request.SupplierRequest;
import vn.work.exe.exe_project.services.SuppliersService;

@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {

    @Autowired
    private SuppliersService suppliersService;

    @PostMapping("/create")
    public ResponseEntity<?> createSupplier(@RequestBody SupplierRequest request) {
        try {
            return ResponseEntity.ok(suppliersService.createSupplier(request));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}