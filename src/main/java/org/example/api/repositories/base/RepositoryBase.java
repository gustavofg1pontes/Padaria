package org.example.api.repositories.base;

public interface RepositoryBase<D, T>{
    public T consultar(D id);
}
