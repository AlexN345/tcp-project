
package com.example.myapp.repository;

import com.example.myapp.model.ClientGroupId;
import com.example.myapp.model.ClientInGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientInGroup_rep extends JpaRepository<ClientInGroup, ClientGroupId> {
}




