package com.recollection.back_end_recollection.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import com.recollection.back_end_recollection.Model.Model_API;
import com.recollection.back_end_recollection.Model.Model_API_Page;
import com.recollection.back_end_recollection.Repository.Repository_Recollection;

@Service
public class Service_API {
    
    private final Repository_Recollection repository_Recollection;

    public Service_API(Repository_Recollection repository_Recollection) {
        this.repository_Recollection = repository_Recollection;
    }

    public Page<Model_API> getModel_API(Model_API_Page model_API_Page){


        Sort sort = Sort.by(model_API_Page.getSortDirection(), model_API_Page.getSortBy());

        Pageable pageable = PageRequest.of(

             model_API_Page.getPageNumber(), 
             model_API_Page.getPageSize(), 
             sort
             );

             return repository_Recollection.findAll(pageable);
    }

    public Model_API addApi( Model_API model_API){

        return repository_Recollection.save(model_API);
    }
}
