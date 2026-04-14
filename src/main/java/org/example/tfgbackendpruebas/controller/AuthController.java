package org.example.tfgbackendpruebas.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.example.tfgbackendpruebas.dto.request.RegisterRequest;
import org.example.tfgbackendpruebas.dto.response.UsuarioResponse;
import org.example.tfgbackendpruebas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponse> register(
            @Valid @RequestBody RegisterRequest req) {
        return ResponseEntity.ok(usuarioService.registrar(req));
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioResponse> me(HttpServletRequest request) {
        String uid = (String) request.getAttribute("firebaseUid");
        return ResponseEntity.ok(usuarioService.getByFirebaseUid(uid));
    }
}