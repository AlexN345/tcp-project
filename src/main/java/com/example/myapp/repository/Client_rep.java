
package com.example.myapp.repository;



import com.example.myapp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;//не нужно писать базовые CRUD-методы (Create, Read, Update, Delete) вручную
import org.springframework.stereotype.Repository;//автоматически обрабатывает исключения, связанные с доступом к данным, и преобразует их в Spring-исключения
//позволяет Spring управлять этим классом как частью контекста приложения
/*import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;*/
@Repository
public interface Client_rep extends JpaRepository<Client, String> {//Интерфейс client_rep расширяет (наследует) интерфейс JpaRepository. Сущность client, тип первичного ключа Long

    /*
    //если бы небыло .JpaRepository

    private final Session session;

    public client_rep(Session session) {
        this.session = session;
    }

    public void save(client Client) {
        Transaction transaction = session.beginTransaction();
        session.save(Client);
        transaction.commit();
    }

    public client findById(Long id) {
        return session.get(client.class, id);
    }

    public List<client> findAll() {
        Query<client> query = session.createQuery("FROM Client", client.class);
        return query.getResultList();
    }

    public void update(client client) {
        Transaction transaction = session.beginTransaction();
        session.update(client);
        transaction.commit();
    }

    public void delete(client client) {
        Transaction transaction = session.beginTransaction();
        session.delete(client);
        transaction.commit();
    }*/
}

