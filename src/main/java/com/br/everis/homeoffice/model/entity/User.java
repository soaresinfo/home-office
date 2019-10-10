package com.br.everis.homeoffice.model.entity;

import com.br.everis.homeoffice.enums.Status;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "USER")
public class User extends AuditModel {

    @Id
    @Column(name = "ID_USER", nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private long id_user;

    @Column(name = "STATUS", nullable = false)
    private Status status;

    @Column(name = "REGISTRATION_DATE", nullable = false)
    private LocalDateTime registration_date;

    @Column(name = "NAME", nullable = false)
    @NotNull(message = "O campo \"name\" é obrigatório")
    private String name;

    @Column(name = "EMAIL", nullable = false)
    @NotNull(message = "O campo \"email\" é obrigatório")
    private String email;

    @Column(name = "MOTHER_NAME", nullable = true)
    private String motherName;

    @Column(name = "DATE_BIRTH", nullable = true)
    private String dateBirth;
}
