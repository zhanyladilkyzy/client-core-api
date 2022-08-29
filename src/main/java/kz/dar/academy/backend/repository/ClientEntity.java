package kz.dar.academy.backend.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="client_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String clientId;

    @NotNull
    @Column(nullable = false, length = 80)
    private String name;

    @NotNull
    @Column(nullable = false, length = 80)
    private String surname;

    @NotNull
    @Column(nullable = false, length = 80)
    private String phoneNumber;

}
