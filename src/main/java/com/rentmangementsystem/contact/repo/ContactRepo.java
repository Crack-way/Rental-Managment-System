package com.rentmangementsystem.contact.repo;

import com.rentmangementsystem.contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact,Long> {
}
