package com.asai.jpa.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;


@Transactional("TxnManagerHibernate")
public class AbstractFacade<T> {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public AbstractFacade() {
    }
    
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

  
    public void create(T entity) {
        this.entityManager.persist(entity);
    }

    public void edit(T entity) {
        this.entityManager.merge(entity);
    }

    public void remove(T entity) {
        this.entityManager.remove(this.entityManager.merge(entity));
    }

    public T find(Long primaryKey) {
        return this.entityManager.find(entityClass, primaryKey);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll() {
		CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return this.entityManager.createQuery(cq).getResultList();
    }
    
   
    /**
     * 
     * @param stored procedure/sql
     * @return resultset
     */
    @SuppressWarnings("unchecked")
	public List<T> createNativeQuery(String query){
    	
    	//List<T> resultList=this.entityManager.createNativeQuery(query).getResultList();
    	
    	Query storedQuery =this.entityManager.createNamedStoredProcedureQuery(query);
    	
    	List<T> resultList=(List<T>)storedQuery.getResultList();
    	return resultList;
    }
}
