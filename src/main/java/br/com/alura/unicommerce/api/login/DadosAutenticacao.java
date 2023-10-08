package br.com.alura.unicommerce.api.login;

import jakarta.validation.constraints.NotNull;

public record DadosAutenticacao(@NotNull String login, @NotNull String senha) {
}
