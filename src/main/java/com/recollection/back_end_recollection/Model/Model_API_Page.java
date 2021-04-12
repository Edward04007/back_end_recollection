package com.recollection.back_end_recollection.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class Model_API_Page {

    private int pageSize = 10;
    private int  pageNumber = 0;
    private String sortBy= "Id";
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    
}
