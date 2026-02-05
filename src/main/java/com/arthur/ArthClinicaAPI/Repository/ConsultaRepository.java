package com.arthur.ArthClinicaAPI.Repository;

import com.arthur.ArthClinicaAPI.Entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>
{
}
