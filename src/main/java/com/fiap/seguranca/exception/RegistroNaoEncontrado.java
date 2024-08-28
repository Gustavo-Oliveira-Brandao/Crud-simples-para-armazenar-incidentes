package com.fiap.seguranca.exception;


import java.io.Serial;

public class RegistroNaoEncontrado extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public RegistroNaoEncontrado(Long id){
        super("Registro não encontrado");
    }
}
