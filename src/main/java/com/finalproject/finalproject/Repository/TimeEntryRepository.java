package com.finalproject.finalproject.Repository;

import org.springframework.data.repository.CrudRepository;

import com.finalproject.finalproject.entity.TimeEntry;

public interface TimeEntryRepository extends CrudRepository<TimeEntry, Long>{
}
