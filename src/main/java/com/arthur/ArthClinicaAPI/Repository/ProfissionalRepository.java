package com.arthur.ArthClinicaAPI.Repository;

import com.arthur.ArthClinicaAPI.Entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long>
{
}
