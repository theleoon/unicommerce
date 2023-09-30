package br.com.alura.unicommerce.api.auth;

import jakarta.validation.constraints.NotNull;

public record DadosAutenticacao(@NotNull String login, @NotNull String senha) {
}
