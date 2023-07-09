package com.example.springsource.hbn;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping()
public class HbnController {
    @GetMapping("/event/save/{title}")
    public Long save(@PathVariable("title") String title){
        return createAndStoreEvent(title, new Date());
    }


    @GetMapping("/event/join/{personId}/{eventId}")
    public void join(@PathVariable("personId") Long personId,@PathVariable("eventId") Long eventId){
        addPersonToEvent(personId, eventId);
    }

    @GetMapping("/event/email/{personId}/{email}")
    public void email(@PathVariable("personId") Long personId,@PathVariable("email") String email){
        addEmailToPerson(personId, email);
    }
    private Long createAndStoreEvent(String title, Date theDate) {

        Long id = -1l;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {

            session.beginTransaction();

            Event theEvent = new Event();
            theEvent.setTitle(title);
            theEvent.setDate(theDate);

            id = (Long)session.save(theEvent);
        }finally {
            session.getTransaction().commit();
        }
        return id;
    }

    private void addPersonToEvent(Long personId, Long eventId) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person aPerson = (Person) session.load(Person.class, personId);
        Event anEvent = (Event) session.load(Event.class, eventId);

        aPerson.getEvents().add(anEvent);

        session.getTransaction().commit();
    }

    private void addEmailToPerson(Long personId, String emailAddress) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person aPerson = (Person) session.load(Person.class, personId);

        // The getEmailAddresses() might trigger a lazy load of the collection
        aPerson.getEmailAddresses().add(emailAddress);

        session.getTransaction().commit();
    }
}
