package com.br.everis.homeoffice.model.entity;

import com.br.everis.homeoffice.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "MANAGE_HOME_OFFICE")
public class ManageHomeOffice extends AuditModel {

    @Id
    @Column(name = "ID_MANAGE_HOME_OFFICE", nullable = false, unique = true)
    private long idManageHomeOffice;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime registrationDate;

    @Column(name = "DESCRITPION", nullable = false)
    private String description;

}
