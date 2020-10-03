package com.finalproject.finalproject.Repository;

import org.springframework.data.repository.CrudRepository;

import com.finalproject.finalproject.entity.AttorneyTimeEntry;

public interface TimeEntryRepository extends CrudRepository<AttorneyTimeEntry, Long>{
}
