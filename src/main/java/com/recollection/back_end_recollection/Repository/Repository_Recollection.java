package com.recollection.back_end_recollection.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.recollection.back_end_recollection.Model.Model_API;

public interface Repository_Recollection extends JpaRepository<Model_API, Long>{
    
    Model_API findById(long id);
}
