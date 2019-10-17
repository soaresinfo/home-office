package com.br.everis.homeoffice.model.entity;

import com.br.everis.homeoffice.enums.Status;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Position extends AuditModel {

    @Id
    @Column(name = "ID_POSITION", nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private long id_position;

    @Column(name = "STATUS", nullable = false)
    @NotNull(message = "O campo \"status\" é obrigatório")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime registrationDate;

    @Column(name = "TOTAL_POSITION")
    private int totalPosition;

}
