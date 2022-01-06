package com.rkoyanagui.rest_assured_demo.steps.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UsuarioModel
{
  private String firstName;
  private String lastName;
}
