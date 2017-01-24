package hu.lamsoft.experiment.parkhouse.service;

import java.util.List;

import hu.lamsoft.experiment.parkhouse.persistence.model.BaseModel;

public interface BaseCrudService<T extends BaseModel> {

	T findById(Long id);
	
	List<T> findAll();
	
	T create(T t);
	
	T update(T t);
	
}
