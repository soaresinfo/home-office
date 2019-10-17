package com.br.everis.homeoffice.model.entity;

import com.br.everis.homeoffice.enums.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "PROGRAMMING_LANGUAGE")
public class ProgrammingLanguage extends AuditModel {

    @Id
    @Column(name = "ID_PROGRAMMING_LANGUAGE", nullable = false, unique = true)
    private long idProgrammingLanguage;

    @Column(name = "STATUS", nullable = false)
    @NotNull(message = "O campo \"status\" é obrigatório")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime registrationDate;

}
