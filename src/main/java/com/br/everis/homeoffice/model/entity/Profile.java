package com.br.everis.homeoffice.model.entity;

import com.br.everis.homeoffice.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "PROFILE")
public class Profile extends AuditModel {

    private static final long serialVersionUID = 2854362072294029605L;

    @Id
    @Column(name = "ID_PROFILE", nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private long id_profile;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime registrationDate;

    @Column(name = "DESCRIPTION", nullable = true)
    private String description;

    @Column(name = "URL")
    private String url;

}
