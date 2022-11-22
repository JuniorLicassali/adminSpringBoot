package com.news.login.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.news.login.model.Administrador;
import com.news.login.model.Noticia;

public interface NoticiaRepo extends CrudRepository<Noticia, Long> {
	  @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from noticia where id = :id", nativeQuery = true)
	  public boolean exist(int id);

	  @Query(value="select * from administradores where email = :email and senha = :senha", nativeQuery = true)
	  public Administrador Login(String email, String senha);
}
